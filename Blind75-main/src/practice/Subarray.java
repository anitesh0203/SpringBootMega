package practice;

public class Subarray {

    int counter;
    public int subarraySum(int[] nums, int k) {
        counter = 0;
        count(nums,k,k, nums.length-1);
        if(nums[0]+nums[1]==k) {
            counter++;
        }
        return counter;

    }

    private void count(int[] nums, int curr, int target, int n) {
        if(curr==0) {
            counter++;
            curr=target;
            if(n!=0) {
                n++;
            }

        }
        if(n<0) {
            return;
        }

        if(nums[n]<=curr) {
             count(nums, curr-nums[n], target,n-1);
        }else {
            count(nums,target,target,n-1);
        }
    }

    public static void main(String[] args) {
        Subarray subarray = new Subarray();
        System.out.println( subarray.subarraySum(new int[]{1,1,1},2));
    }
}
