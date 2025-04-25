package bind75;

import java.util.Arrays;

public class MaxMultiplySubArray {
    public int maxProduct(int[] nums) {

        if (nums.length ==1) {
            return nums[0];
        }

        // call zero check service

        int pos = getTheZeroIndex(nums);
        if (pos == -1) {
            return extracted(nums);
        } else {
            // split into two and call the determine service
            int b[] = new int[pos];
            int c[] = new int[nums.length - pos];
            b = Arrays.copyOfRange(nums, 0, pos);
            c = Arrays.copyOfRange(nums, pos+1, nums.length);
            int bAns = extracted(b);
            int cAns = extracted(c);
            if (bAns <0 && cAns<0) {
                return 0;
            }
            if (bAns > cAns) {
                return bAns;
            } else {
                return cAns;
            }
        }
    }

    private int extracted(int[] nums) {
        if (nums.length ==1) {
            return nums[0];
        }
        // there is no zero in the array
        int num_Neg = countNegatives(nums);
        if (num_Neg%2==0 &&  nums.length>1) {
            //multiply all numbers in the array
            return multiplyAll(nums);
        } else if (num_Neg == nums.length && nums.length>1) {
            return  multiplyAll(nums) / (getLargestNumber(nums));
        } else {
            int max =1;
            int allMax = Integer.MIN_VALUE;
            for (int i = 0; i< nums.length; i++) {
                max = max * nums[i];
                if (max > allMax) {
                    allMax = max;
                }
                if(max < 0 ) {
                    max =1;
                }
            }
            return allMax;
        }
    }

    private int getLargestNumber(int[] nums) {
        int large = Integer.MIN_VALUE;
        for (int a : nums) {
            if(a>large) {
                large = a;
            }
        }
        return large;
    }

    private int multiplyAll(int[] nums) {
        if(nums.length==1) {
            return nums[0];
        }
        int ans = 1;
        for (int x : nums) {
            ans = ans * x;
        }
        return ans;
    }

    private int countNegatives(int[] nums) {
        int ans = 0 ;
        for (int x : nums) {
            if(x<0) {
                ans++;
            }
        }
        return ans;
    }

    private int getTheZeroIndex(int[] nums) {
        for (int i=0 ;i< nums.length; i++) {
            if(nums[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MaxMultiplySubArray maxMultiplySubArray = new MaxMultiplySubArray();
        int[] nums = {-4,-3,-2};
        System.out.println(maxMultiplySubArray.maxProduct(nums));

    }
}
