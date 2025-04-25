package bind75;

public class RotatedArray {

    public int findMin(int[] nums) {
        return func(nums,0,  nums.length-1);
    }

    private int func(int[] nums, int start, int n) {
        if(n-start==0) {
            return nums[start];
        }
        if(nums[start] > nums[n]) {
            int mid = (start+n) / 2;
            return Math.min(func(nums,start,mid),func(nums,mid+1,n));
        } else {
            return nums[start];
        }
    }

    public static void main(String[] args) {
        RotatedArray rotatedArray = new RotatedArray();
        int[] nums = {2,3,4,5,1};
        //int[] nums = {2,3,1};

        System.out.println(rotatedArray.findMin(nums));
    }
}
