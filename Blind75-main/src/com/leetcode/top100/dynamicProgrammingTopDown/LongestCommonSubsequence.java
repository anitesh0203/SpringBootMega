package com.leetcode.top100.dynamicProgrammingTopDown;

public class LongestCommonSubsequence {
    static int  [][] t;

    public LongestCommonSubsequence() {
        t= new int [100][100];
        for (int i=0 ;i < 100; i++ ) {
            for (int j=0; j<100;j++) {
                t[i][j] = -1;
            }
        }
    }

    public static int lcs(String x, String y, int n, int m) {
        t= new int [100][100];
        for (int i=0 ;i < 100; i++ ) {
            for (int j=0; j<100;j++) {
                t[i][j] = -1;
            }
        }
        // base condition
        if(n==0 || m==0) {
            return 0;
        }
        // recursive code
        if(t[n][m] != -1) {
            return t[n][m];
        } else  {
            if (x.charAt(n-1)==y.charAt(m-1)) {
                t[n][m] = 1+lcs(x,y,n-1,m-1);
            }else{
                t[n][m] =  Math.max(lcs(x,y,n-1,m), lcs(x,y,n,m-1));
            }
        }
        return t[n][m];
    }
    public static void main(String[] args) {
        LongestCommonSubsequence s = new LongestCommonSubsequence();
        System.out.println(s.lcs("abcdgh","abedfhr",6,7));
    }
}
