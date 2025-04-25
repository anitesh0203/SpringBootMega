package bind75.dynamicProgramming;

public class CombinationSum {
    public int combinationSum(int[] nums, int target) {
        return subsetSum(nums, target, nums.length);

    }

    private int subsetSum(int[] nums, int target, int length) {

        int t[][] = new int[target + 1][length + 1];
        for (int i = 1; i < target + 1; i++) {
            t[i][0] = 0;
        }

        for (int j = 0; j < length + 1; j++) {
            t[0][j] = 1;
        }
        for (int i = 1; i < target + 1; i++) {
            for (int j = 1; j < length + 1; j++) {
                if (nums[j - 1] <= i) {
                    t[i][j] = t[i - nums[j - 1]][j] + t[i][j-1];
                } else {
                    t[i][j] = t[i][j - 1];
                }
            }
        }
        return t[target][length];
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] nums ={1,2,3};
        System.out.println(combinationSum.combinationSum(nums, 4));
    }
}
