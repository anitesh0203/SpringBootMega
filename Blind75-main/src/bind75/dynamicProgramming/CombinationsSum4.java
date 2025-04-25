package bind75.dynamicProgramming;

public class CombinationsSum4 {

    public int ways(int [] nums, int target, int n) {
        if(n==0) {
            return 0;
        }
        if(target==0) {
            return 1;
        }
        if(nums[n-1]<= target) {
            return ways(nums,target-nums[n-1],n-1) + ways(nums, target,n-1);
        } else {
            return ways(nums, target, n-1);
        }
    }
    public int combinationSum4(int[] nums, int target) {
        return ways(nums, target, nums.length);
    }


    public static void main(String[] args) {

    }
}
