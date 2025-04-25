package com.leetcode.top100.dynamicProgrammingbottomUp;

public class KnapsackUnbounded {

    public static int knapsack(int weight, int[] wt, int[] value, int n) {
        int t[][] = new int [weight+1][n+1];
        for (int i=0 ; i < weight +1;i++ ) {
            t[i][0] = 0;
        }

        for (int j =0 ;j< n+1; j++) {
            t[0][j] = 0;
        }

        for (int i=1; i<weight+1;i++) {
            for(int j=1 ;j<n+1;j++) {
                if (wt[j - 1] <= i) {
                    // Unbounded means the same element can be considered again and again so the element would be "n"
                    t[i][j] =  Math.max(value[j - 1] + t [i - wt[j - 1]][j], t[i][j-1]);
                } else {
                    t[i][j] = t[i][j-1];
                }
            }
        }


        for (int i=0; i<weight+1;i++) {
            System.out.println("");
            for(int j=0 ;j<n+1;j++) {
                System.out.print(t[i][j]+"|");
            }
        }
        return t[weight][n];
    }

    public static void main(String[] args) {
        int wt[] = {1,2,3};
        int value[] = {1,1,1};
        knapsack(4, wt, value, 3);
    }
}
