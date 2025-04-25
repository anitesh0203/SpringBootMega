package com.leetcode.top100.dynamicProgrammingbottomUp;

public class Trust {

    public int coinChange(int[] coins, int amount) {
        int t[][] = new int[coins.length+1][amount+1];

        // intialise the 2d array
        // first the row

        for (int i=0;i<=amount;i++ ) {
            t[0][i]= Integer.MAX_VALUE-1;
        }

        for (int i=1 ;i<=coins.length+1;i++) {
            t[i][0] = 0;
        }

        // intialise the second row

        for (int i=1;i<=amount;i++) {
            if(i%coins[0]==0) {
                t[1][i]= i/coins[0];
            } else {
                t[1][i] = Integer.MAX_VALUE-1;
            }
        }

        for (int i=2 ;i<=coins.length+1;i++) {
            for(int j=1 ;j<=amount;j++){
                if(coins[i-1]<=j) {
                    t[i][j] = Math.min(1+t[i][j-coins[i-1]],t[i-1][j]);
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        if(t[coins.length][amount]==Integer.MAX_VALUE-1) {
            return -1;
        }
        return t[coins.length][amount];
    }

}
