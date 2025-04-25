package practice;

import java.util.*;

public class UndergroundSystem {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(row -> row[0]));
        int rooms =1;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(intervals[0][1]);
        for (int i=1;i< intervals.length;i++) {
            int now = priorityQueue.peek();
            if(intervals[i][0]<now) {
                rooms++;
                priorityQueue.add(intervals[i][1]);
            } else {
                priorityQueue.poll();
                priorityQueue.add(intervals[i][1]);
            }
        }
        return rooms;
    }

    public int findPeakElement(int[] nums) {
        int left=0;
        int right = 2;
        for (int i=1 ; i< nums.length-1; i++) {
            if(nums[i]>nums[left] && nums[i]>right) {
                return i;
            } else {
                left++;
                right++;
            }
        }
        return -1;
    }



    public static void main(String[] args) {

    }
}