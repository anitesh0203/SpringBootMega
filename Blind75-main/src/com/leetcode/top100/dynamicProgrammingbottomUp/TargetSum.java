package com.leetcode.top100.dynamicProgrammingbottomUp;

public class TargetSum {
    public static int tSum(int arr[], int sum, int n, int val) {

        int t[][] = new int [sum+1][n+1];

        for (int i=0 ; i<sum+1;i++) {
            t[i][0] = 0;
        }
        for (int i=0 ; i<n+1;i++) {
            t[0][i] = 1;
        }

        for (int i=1; i< sum+1;i++) {
            for(int j=1 ; j< n+1;j++) {
                t[i][j] = t[sum-arr[j-1]][j-1] + t[sum+arr[j-1]][j-1];
            }
        }
        return t[sum][n];

    }

    public static void main(String[] args) {
        int arr [] = {1,1,2,3} ;
        System.out.println(tSum(arr,0,4,1));

    }
}
