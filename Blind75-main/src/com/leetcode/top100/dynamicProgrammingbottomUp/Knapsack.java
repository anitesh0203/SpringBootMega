package com.leetcode.top100.dynamicProgrammingbottomUp;

public class Knapsack {
    static int t[][];

    //Initialize the array
    Knapsack(int weight, int n) {
        t = new int[weight + 1][n + 1];
    }

    public static int knapsack(int weight, int[] wt, int[] value, int n) {
        for (int i=0 ; i < weight +1;i++ ) {
            t[i][0] = 0;
        }

        for (int j =0 ;j< n+1; j++) {
            t[0][j] = 0;
        }

        for (int i=1; i<weight+1;i++) {
            for(int j=1 ;j<n+1;j++) {
                if (wt[j - 1] <= i) {
                    t[i][j] =  Math.max(value[j - 1] + t [i - wt[j - 1]][j-1], t[i][j-1]);
                } else {
                    t[i][j] = t[i][j-1];
                }
            }
        }
        return t[weight][n];
    }

    public static void main(String[] args) {
        int wt[] = {1,2,4,3,5};
        int value[] = {2,3,1,4,2};
        Knapsack k = new Knapsack(7, 5);
        System.out.println(k.knapsack(7, wt, value, 5));
    }
}
