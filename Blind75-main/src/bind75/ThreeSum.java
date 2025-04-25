package bind75;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {
//    public List<Integer> twoSum(int[] nums, int target) {
//
//        Map<Integer, Integer> map = new HashMap<>();
//
//
//        List<Integer> ans = new ArrayList<>();
//
//        for (int i=0; i< nums.length; i++) {
//            if (map.containsKey(target-nums[i])) {
//                ans.add(i);
//                ans.add(map.get(target-nums[i]));
//                break;
//            } else {
//                map.put(nums[i],i);
//            }
//        }
//        return ans;
//    }

    int size;
    boolean visited [];
    public List<Integer> twoSum(int[] nums, int target, int currIndex) {
        List<Integer> map = Arrays.stream(nums).boxed().collect(Collectors.toList());

        int ans[] = new int[2];

        for (int i=0; i< nums.length; i++) {
            if (map.contains(target-nums[i]) &&(map.indexOf(target-nums[i])!= currIndex) && i!=currIndex) {
                if (!visited[currIndex] || !visited[i] || !visited[map.indexOf(target-nums[i])]){
                    ans[0] = nums[i];
                    ans[1] = target - nums[i];
                    visited[currIndex] =  true;
                    visited[i] = true;
                    visited[map.indexOf(target-nums[i])] = true;
                    break;
                }
            }
        }
        return Arrays.stream(ans).boxed().collect(Collectors.toList());
    }

    public List<List<Integer>> threeSum(int[] nums) {

        this.size = nums.length;
        this.visited = new boolean[size];

        List<List<Integer>> retunrnAns = new ArrayList<>();

        for (int i=0 ;i< nums.length;i++) {
            List<Integer> temp = twoSum(nums,(-1*nums[i]),i);
            if(!temp.isEmpty()) {
                List<Integer> ans = new ArrayList<>();
                ans.add(nums[i]);
                ans.addAll(temp);
                retunrnAns.add(ans);
            }
        }
        return retunrnAns;
    }


    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {-1,0,1,2,-1,-4} ;
        List<List<Integer>> ans = threeSum.threeSum(nums);
        System.out.println("Hold");

    }
}
