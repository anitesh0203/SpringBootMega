package bind75;

public class MaximumSubarray {


    public int maxSubArray(int[] nums) {
        int max = nums[nums.length-1];
        return maxSum(nums, nums.length-1, max);
    }

    private int maxSum(int[] arr, int n, int max) {
        //base condition
        if (n==0) {
            return 0;
        }
        if(max <= arr[n-1]) {
            return Math.max(max+arr[n-1], maxSum(arr, n-1,max));
        } else
            return maxSum(arr, n-1, max);
    }


    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        int ans = maximumSubarray.maxSubArray(arr);
        System.out.println(ans);
    }
}
