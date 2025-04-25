package bind75.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LongestIncreasingSubsequence {

    List<List<Integer>> megaList = new ArrayList<>();
     void lengthOfLIS(int [] nums, int n, List<Integer> finalAnswer) {
         if(n == -1) {
             megaList.add(finalAnswer);
             return;
         }
         if (nums[n] < finalAnswer.get(finalAnswer.size()-1)) {
             lengthOfLIS(nums,n-1,finalAnswer);
             finalAnswer.add(nums[n]);
             lengthOfLIS(nums, n-1,finalAnswer);
         }

    }

    public int lengthOfLIS(int [] nums) {
         int max = 0;
         for(int i = nums.length-1 ; i >=0; i--) {
             List<Integer> list = new ArrayList<>();
             list.add(nums[i]);
             for(int j=i ;j>0 ;j--) {
                 if(nums[j-1]<list.get(list.size()-1)) {
                     list.add(nums[j-1]);
                 }
             }
             max = list.size()>max?list.size():max;
         }
         return max;
    }



    public static void main(String[] args) {
        //int nums[] = {1,3,2,3};
        int nums[] = {0,1,0,3,2,3};
        LongestIncreasingSubsequence longestCommonSubsequence = new LongestIncreasingSubsequence();
        System.out.println(longestCommonSubsequence.lengthOfLIS(nums));
    }
}
