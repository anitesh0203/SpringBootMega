package bind75;

import java.util.*;

public class CanJump {
    public boolean canJump(int[] nums) {
        if (nums.length==1 && nums[0]==0) {
            return true;
        }
        boolean canJump = true;
        int ptr = 0;
        int residue;
        for (int i = nums.length-1 ;i>= 0 ; i--) {
            canJump = true;
            if(nums[i] == 0) {
                ptr = i;
                canJump = false;
                if (ptr == nums.length-1) {
                    residue = 1;
                } else {
                    residue = 2;
                }
                if(isCanJump(nums, canJump, ptr, residue) == false) {
                    return false;
                }
            }
        }
        return canJump;
    }

//    public int[] productExceptSelf(int[] nums) {
//
//        int ans [] = new int[nums.length];
//        for (int i = 0 ;i<nums.length;i++) {
//            ans[i] = multi(nums,0,i-1) * multi(nums,i+1, nums.length-1);
//        }
//        return ans;
//    }

    private int multi(int[] nums, int start, int end) {
        if (start<0 || end > nums.length-1) {
            return 1;
        }
        int m=1;
        for (int i = start ; i <=end ;i++) {
            m = m*nums[i];
        }
        return m;
    }


    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i=0 ; i< nums.length;i++) {
            if(set.contains(nums[i])) {
                return false;
            } else {
                set.add(nums[i]);
            }
        }
        return true;
    }


    private boolean isCanJump(int[] nums, boolean canJump, int ptr, int residue) {
        for (int i = ptr -1; i>=0; i--) {
            if (nums[i]< residue) {
                residue++;
            } else {
                canJump = true;
            }
        }
        return canJump;
    }

    public int[] productExceptSelf(int[] nums) {

        int [] product = new int[nums.length];

        for (int i=0 ; i< product.length; i++) {
            product[i] = 1;
        }
        int left = 1;
        int right =1;


        for (int i=0 ; i< nums.length; i++) {
            product[i] = product[i] * left;
            left*= nums[i];
        }

        for (int j=nums.length-1 ; j>=0;j--) {
            product[j] = product[j] * right;
            right *= nums[j];
        }

        return product;

    }

    public int maxSubArray(int[] nums) {

        int curr_max=0;
        int max = Integer.MIN_VALUE;

        for (int i =0 ; i<nums.length;i++) {
            curr_max+=nums[i];
            if(curr_max == 0 && nums[i]>0) {
                curr_max = nums[i];
            }
            if(i==nums.length-1 && nums[i]>curr_max) {
                curr_max = nums[i];
            }
            if(curr_max>=max) {
                max = curr_max;
            }
        }
        return max;
    }

    public int maxProduct(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum =1;
        List<Integer> list = new ArrayList<>();
        for(int i=0 ; i<nums.length; i++) {
            if(nums[i]==0) {
                return 0;
            }
            if(nums[i]<0) {
                list.add(nums[i]);
                currSum =1;
            } else {
                currSum *= nums[i];
                if(currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }
        if(list.size()%2==0) {
            for (int val : list) {
                maxSum *= val;
            }
        } else if(list.size()%2!=0 && maxSum == Integer.MIN_VALUE) {
            maxSum =1;
            for (int val : list) {
                maxSum *= val;
            }        }
        return maxSum;
    }


    public int findMin(int[] nums) {
        int low=0;
        int high = nums.length-1;

        while(high>low) {
            int mid = low + high  /2;
            if(high-low==1) {
                return nums[high]<nums[low]?nums[high]:nums[low];
            }
            if(nums[mid]>nums[mid-1] && nums[mid+1]>nums[mid]) {
                if (nums[low]>nums[mid]) {
                    high = mid-1;
                } else {
                    return nums[mid-1];
                }
            } else {
                return nums[mid];
            }

        }
        return nums[0];
    }

    public static void main(String[] args) {
        int ans = Integer.MIN_VALUE;
        CanJump canJump = new CanJump();
        int[] nums = {3,1,2};
        System.out.println(canJump.findMin(nums));

    }
}
