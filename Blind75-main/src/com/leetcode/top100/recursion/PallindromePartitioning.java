package com.leetcode.top100.recursion;

public class PallindromePartitioning {
    public static int countPartitions(String arr, int i, int j) {
        if(i>=j) {
            return 0;
        }
        if(isPallindrome(arr, i, j)) {
            return 0;
        }
        int temp;
        int min = Integer.MAX_VALUE;
        for (int k=i;k<=j-1;k++) {
            temp = countPartitions(arr,i,k) + countPartitions(arr,k+1,j) +1;
            if(temp < min){
                min = temp;
            }
        }
     return min;
    }

    private static boolean isPallindrome(String arr, int i, int j) {
        while(i<=j) {
            if(arr.charAt(i) != arr.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "nitin";
        System.out.println(countPartitions(str,0,str.length()-1));
    }
}
