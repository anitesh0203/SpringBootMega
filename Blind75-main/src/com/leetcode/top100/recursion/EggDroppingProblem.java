package com.leetcode.top100.recursion;

public class EggDroppingProblem {
    public static int solve(int eggs, int floors) {
        // base condition
        if(floors==0||floors==1) {
            return floors;
        }
        if(eggs == 1) {
            return floors;
        }

        int min = Integer.MAX_VALUE;
        int temp;
        // run the loop for k
        for (int k=1 ; k<=floors; k++) {
            temp = 1 + Math.max(solve(eggs-1,k-1), solve(eggs,floors-k));
            if(temp < min) {
                min = temp;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        System.out.println(solve(2,4));
    }
}
