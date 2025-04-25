package bind75;

import java.util.Arrays;

public class SearchRotatedArray {
    public int search(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}
