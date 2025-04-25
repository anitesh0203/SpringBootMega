package com.leetcode.top100.recursion;

public class MatrixChainMultiplication {
    //1. Determine the values of i & j here i =1 and j =n-1
    public static int solve(int arr[], int i, int j) {
        // 2. base condition, since i==j wont have valid dim
        if(i>=j) {
            return 0;
        }
        int temp;
        int min = Integer.MAX_VALUE;
        //3. Write the loop for k, k =i to k=j-1
        for(int k=i; k<=j-1;k++) {
            //4. calculate value for 2 halves
            temp = solve(arr,i,k)+ solve(arr,k+1,j)
                    + (arr[i-1] * arr[j] * arr[k]);
            if(temp < min){
                min = temp;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int arr[] = {10,20,30};
        System.out.println(solve(arr,1,arr.length-1));
    }
}
