package com.leetcode.top100.dynamicProgrammingbottomUp;

//TODO TO BE DONE LATER
public class PrintShortestCommonSubsequence {
    public static String lcs(String x, String y, int n, int m) {
        String t[][] = new String [n+1][m+1];
        for (int i=0 ;i<n+1 ;i++){
            t[i][0] = "";
        }
        for (int i=0 ;i<m+1 ;i++){
            t[0][i] = "";
        }

        for ( int i=1 ; i<n+1; i++) {
            for (int j=1;j<m+1;j++) {
                if (x.charAt(i-1)==y.charAt(j-1)) {
                    t[i][j] = lcs(x,y,i-1,j-1)+x.charAt(i-1);
                }else{
                    t[i][j] = (t[i][j-1].length()>t[i-1][j].length())?t[i][j-1]:t[i-1][j];
                }
            }
        }
        return t[n][m];
    }
    public static void main(String[] args) {
        System.out.println(lcs("abi","agb",3,3));
    }

}
