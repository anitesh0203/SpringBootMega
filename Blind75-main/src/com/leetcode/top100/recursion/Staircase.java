package com.leetcode.top100.recursion;

public class Staircase {
    public static int ways(int arr[], int n, int stairs) {
        if (n == 0 || stairs == 0) {
            return 0;
        }

        if (arr[n-1] <= stairs) {
            return 1+ ways(arr, n-1, stairs - arr[n-1]) + ways(arr, n - 1, stairs);
        } else {
            return ways(arr, n - 1, stairs);
        }
    }

    public static int ways2(int arr[], int n, int sum) {
        if (sum==0) {
            return 1;
        }
        if(sum < 0 || n<0) {
            return 0;
        }
        return ways2(arr,n,sum-arr[n]) + ways2(arr, n-1, sum);

    }


    public static void main(String[] args) {
        int arr [] = {1,2,3};
        System.out.println(ways2(arr, 2, 3));
    }
}
