package com.leetcode.top100.recursion;

public class LongestCommonSubsequence {

    public static int lcs(String x, String y, int n, int m) {
        // base condition
        if(n==0 || m==0) {
            return 0;
        }
        // recursive code
        if (x.charAt(n-1)==y.charAt(m-1)) {
            return 1+lcs(x,y,n-1,m-1);
        }else{
            return Math.max(lcs(x,y,n-1,m), lcs(x,y,n,m-1));
        }
    }


    public static void main(String[] args) {
        System.out.println(lcs("abcdgh","abedfhr",6,7));
    }
}
