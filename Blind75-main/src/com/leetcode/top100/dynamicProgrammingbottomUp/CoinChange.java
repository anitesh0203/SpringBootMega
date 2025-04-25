package com.leetcode.top100.dynamicProgrammingbottomUp;

public class CoinChange {
    public static int  countCoinChange(int coin[] , int sum, int n) {
        // intialiazation

        int t[][] = new int [sum+1][n+1];
        for (int i=1 ; i < sum +1;i++ ) {
            t[i][0] = 0;
        }

        for (int j =0 ;j< n+1; j++) {
            t[0][j] = 1;
        }

        // dp implementation

        for (int i=1; i<sum+1;i++) {
            for(int j=1 ;j<n+1;j++) {
                if (coin[j - 1] <= i) {
                    // Unbounded means the same element can be considered again and again so the element would be "n"
                    t[i][j] = t [i - coin[j - 1]][j] + t[i][j-1];
                } else {
                    t[i][j] = t[i][j-1];
                }
            }
        }
        return t[sum][n];




    }
    public static void main(String[] args) {

        int coin[] = {1,2,3};
        System.out.println(countCoinChange(coin, 3,3));

    }
}
