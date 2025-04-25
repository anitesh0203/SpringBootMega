//package com.leetcode.top100.recursion;
//
////TODO : Complete the method
//public class LongestCommonSubstring {
//    public static  int countSubstrings(String s) {
//
//        int n = s.length();
//
//        int [][] t = new int [n][n];
//
//        // Intialise the single chars
//        for(int i =0 ;i<n;i++) {
//            t[i][i]=1;
//        }
//        //initilaise for 2 chars
//
//        for (int j=0 ; j< n-1;j++) {
//            if(s.charAt(j)==s.charAt(j+1)) {
//                t[j][j+1] =1;
//            }
//        }
//
//
//        for (int k=3;k<=n;k++) {
//            for (int i=0;i<n-k+1;i++) {
//                int j = k+i-1;
//                if(s.charAt(i)==s.charAt(j)&&(t[i+1][j-1]==1)) {
//                    t[i][i]=1;
//                }
//            }
//        }
//
//        int sum =0;
//        for (int i=0;i<n;i++) {
//            for(int j=0;j<n;j++) {
//                if(t[i][j]==1) {
//                    sum++;
//                }
//            }
//        }
//        return sum;
//    }
//
//    public static int maxProductd(int[] nums) {
//
//        int n = nums.length;
//        int t[][] = new int [n][n];
//
//        for (int i=0 ;i<n;i++) {
//            t[i][i] = nums[i];
//        }
//
//        int max = Integer.MIN_VALUE;
//
//        for (int i=0 ;i<n;i++) {
//            for (int j=i+1;j<n;j++) {
//                t[i][j] = t[i][j-1]*nums[j];
//                if(t[i][j]>max) {
//                    max= t[i][j];
//                }
//            }
//        }
//        return max;
//    }
//
//    public static int maxProduct(int[] nums) {
//        int left =1;
//        int right =1;
//        int temp;
//        int n = nums.length-1;
//        int max=Integer.MIN_VALUE;
//
//        for(int i=0 ;i<=n; i++) {
//            left= left * nums[i];
//            right = right * nums[n-i];
//            if(left>right) {
//                temp =left;
//            } else {
//                temp = right;
//            }
//            if(left==0) {
//                left=1;
//            }
//            if(right==0) {
//                right=1;
//            }
//            if(temp>max) {
//                max= temp;
//            }
//        }
//        return max;
//
//    }
//
//    public static int rob(int[] nums) {
//        int n = nums.length;
//
//        int t[][] = new int[n][n];
//
//        for(int i=0 ;i<n;i++){
//            t[i][i]=nums[i];
//        }
//
//        for (int j=0 ;j<n-1;j++) {
//            t[j][j+1]=0;
//        }
//
//
//        for(int i=0;i<n;i++) {
//            for (int j=i+2;j<n;j++){
//                t[i][j]= t[i][j-2]+nums[j];
//            }
//        }
//        int temp = t[0][n-1];
//        if(t.length!=1)
//        t[0][n-1]=0;
//
//        int sum = Integer.MIN_VALUE;
//        for(int i=0;i<n;i++) {
//            for (int j=0;j<n;j++){
//                if(t[i][j]>sum) {
//                    sum = t[i][j];
//                }
//            }
//        }
//        return sum>temp?sum:temp;
//    }
//
//
//
//
//    public int ctr(int [] ch, int n) {
//        if(n==0) {
//            return 1;
//        }
//        if(isVld(ch,n-1)) {
//            return ctr(ch,n-1)+ctr(ch,n-2);
//        } else {
//            return 0;
//        }
//    }
//
//
//
//
//    public static void main(String[] args) {
//        System.out.println(rob(new int[]{1,3,1,3,100}));
//    }
//}
