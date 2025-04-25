package com.leetcode.top100.recursion;

public class TargetSum {

    public static int counti(int arr[], int sum, int n, int val) {

        // base condition
        if(n==0) {
            if(sum==val) {
                return 1;
            } else
                return 0;
        }

        // Hypothesis + Induction

        return (counti(arr,sum-arr[n-1] ,n-1,val)) + (counti(arr, sum+arr[n-1], n-1, val));

    }

    public static void main(String[] args) {
        int arr [] = {1,1,2,3} ;
        System.out.println(counti(arr,0,4,1));

    }
}
