package com.leetcode.top100.dynamicProgrammingbottomUp;

public class SubsetSum {

    public static boolean subset(int []arr, int sum, int n) {
        // Dynamic program subset matrix
        boolean t[][] = new boolean [sum+1][n+1];

        // Initialization of base condition
        for (int i=1 ;i< sum+1;i++) {
            t[i][0] = false;
        }
        for (int i=0 ;i< n+1;i++) {
            t[0][i] = true;
        }

        //Coding for the main logic
        for (int i=1; i<sum+1;i++) {
            for(int j=1 ;j<n+1;j++) {
                if (arr[j - 1] <= i) {
                    t[i][j] =   t [i - arr[j - 1]][j-1] || t[i][j-1];
                } else {
                    t[i][j] = t[i][j-1];
                }
            }
        }
        return t[sum][n];
    }


    public static void main(String[] args) {
        int arr [] = {2,3,7,8,10};
        System.out.println(subset(arr,11,5));

    }
}
