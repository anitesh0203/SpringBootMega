package com.leetcode.top100.recursion;

public class Knapsack {
    public static int knapsack(int weight, int[]wt, int[]value, int n) {
        if (n==0 || weight==0) {
            return 0;
        }
        if(wt[n-1] <= weight) {
            return Math.max(value[n-1]+knapsack(weight-wt[n-1], wt, value,n-1),
                    knapsack(weight,wt,value, n-1));
        } else {
            return knapsack(weight,wt,value, n-1);
        }
    }
    public static void main(String[] args) {
            int wt [] = {10,20,30} ;
            int value [] = {60,100,120};
        System.out.println(knapsack(50,wt,value,3));
    }
}
