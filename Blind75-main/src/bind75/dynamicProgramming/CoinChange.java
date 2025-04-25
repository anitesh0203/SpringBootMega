package bind75.dynamicProgramming;

import practice.Man;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        return ccRecursive(coins, coins.length-1, amount);

    }

    private int ccRecursive(int[] coins, int n, int amount) {
        if(amount ==0 || n==0) {
            return 0;
        }

        //recursion

        if(coins[n] <= amount) {

            return Math.min((ccRecursive(coins,n-1,amount-coins[n])+1)
            , ccRecursive(coins, n-1, amount));

        } else {
            return ccRecursive(coins,n-1,amount);
        }
    }

    public static void main(String[] args) {

    }
}
