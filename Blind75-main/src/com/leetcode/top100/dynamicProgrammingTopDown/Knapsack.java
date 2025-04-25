package com.leetcode.top100.dynamicProgrammingTopDown;

public class Knapsack {
    static int t[][];

    //Initialize the array
    Knapsack(int weight, int n) {
        t = new int[weight + 1][n + 1];
        for(int i=0 ; i < weight+1;i++ ) {
            for (int j=0 ; j< n+1; j++) {
                t[i][j] = -1;
            }
        }
    }

    public static int knapsack(int weight, int[] wt, int[] value, int n) {
        if (n == 0 || weight == 0) {
            return 0;
        }

        if(t[weight][n] != -1) {
            return t[weight][n];
        }
        if (wt[n - 1] <= weight) {
            t[weight][n] =  Math.max(value[n - 1] + knapsack(weight - wt[n - 1], wt, value, n - 1),
                    knapsack(weight, wt, value, n - 1));
        } else {
            t[weight][n] = knapsack(weight, wt, value, n - 1);
        }
        return t[weight][n];
    }

    public static void main(String[] args) {
        int wt[] = {10, 20, 30};
        int value[] = {60, 100, 120};
        Knapsack k = new Knapsack(50, 3);
        System.out.println(k.knapsack(50, wt, value, 3));
    }
}
