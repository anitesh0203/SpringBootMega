package practice;

import java.util.*;

public class TopK {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(x->{
            if(map.containsKey(x)){
                map.put(x,map.get(x)+1);
            } else {
                map.put(x,1);
            }
        });
        Comparator<Map.Entry<Integer,Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if(o1.getValue()> o2.getValue()) {
                    return 1;
                }
                return 0;
            }
        };
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            list.add(entry);
        }
        Collections.sort(list,comparator);
        int ans [] = new int[k];
        int ct=0;
        for(int i=0 ;i<k;i++) {
            ans[ct++]=list.get(i).getKey();
        }
        return ans;
    }


    public int longestConsecutive(int[] nums) {

        Arrays.sort(nums);
        int count =1;
        int ans = Integer.MIN_VALUE;

        for (int i=1;i<nums.length;i++) {
            if(nums[i]-nums[i-1]==1){
                count++;
            } else if(nums[i]>nums[i-1] || (nums[i]-nums[i-1]>1)) {
                if(ans<count){
                    ans=count;
                    count=1;
                }
            }
        }
        return count>ans?count:ans;
    }
}
