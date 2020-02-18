package _other._485;

/**
 * @Description:
 * @Author: 67ng
 * @Date: 2019/7/26 22:41
 */
public class Solution {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int i = 0;//维持全为1的子数组的左边界
        int j = 0;//维持全为1的子数组的右边界
        int res = 0;
        for (int k = 0; k < nums.length - 1; k++) {
            if ((nums[k] == 0 && nums[k + 1] == 1) || nums[0] == 1) {
                i = k + 1;
                j = k + 1;
            }
            if (nums[k] == 1 && nums[k + 1] == 0) {
                res = Math.max(res, j - i + 1);
            }
            j = k;
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0};
        System.out.println(findMaxConsecutiveOnes(nums));//6
    }
}
