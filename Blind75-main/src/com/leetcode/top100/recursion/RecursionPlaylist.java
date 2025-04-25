package com.leetcode.top100.recursion;

public class RecursionPlaylist {

    // log of anything base that number input
    public static double myPow(double x, int n) {
        if(n>0) {
            return median(x,n);
        } else {
            return 1/(median(x,n*(-1)));
        }
    }
    public static double median(double x, int n) {

        if(n==0){
            return 1;
        }

        return x * (median(x, n-1));

    }



    public static void main(String[] args) {

        System.out.println(myPow(0.00001,2147483647));
    }
}
