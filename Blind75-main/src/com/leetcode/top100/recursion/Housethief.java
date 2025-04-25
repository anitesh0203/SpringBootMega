package com.leetcode.top100.recursion;

public class Housethief {
    public static int jump(int arr[], int n) {
        if(n<=0) {
            return 0;
        }
        return Math.max(arr[n-1]+jump(arr, n-2), jump(arr, n-1));
    }

    public static void main(String[] args) {
        int arr[] ={2, 5, 1, 3, 6, 2, 4} ;
        System.out.println(jump(arr,arr.length));
    }
}
