package com.leetcode.top100.dynamicProgrammingbottomUp;

public class LongestCommonSubsequenceCount {
    public static int lcs(String x, String y, int n, int m) {
        int t[][] = new int [n+1][m+1];
        for (int i=0 ;i<n+1 ;i++){
            t[i][0] = 0;
        }
        for (int i=0 ;i<m+1 ;i++){
            t[0][i] = 0;
        }

        for ( int i=1 ; i<n+1; i++) {
            for (int j=1;j<m+1;j++) {
                if (x.charAt(i-1)==y.charAt(j-1)) {
                    t[i][j] = 1+t[i-1][j-1];
                }else{
                    t[i][j] =  0;
                }
            }
        }
        return t[n][m];
    }
    public static void main(String[] args) {
        LongestCommonSubsequenceCount lc = new LongestCommonSubsequenceCount();

        int ans = lc.lcs("babbd","dbbab",5,5);
        System.out.println(ans);
    }
}
