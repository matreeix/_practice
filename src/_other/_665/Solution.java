package _other._665;

/**
 * @Description: 最多修改一个元素使数列不减
 * @Author: 67ng
 * @Date: 2019/8/6 23:52
 */
public class Solution {

    public static boolean checkPossibility(int[] nums) {

        int count = 0;
        for (int i = 1; i < nums.length && count <= 1; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
                if (i - 2 < 0 || nums[i - 2] <= nums[i])
                    nums[i - 1] = nums[i];//注意两种合并的区别
                else nums[i] = nums[i - 1];

            }
        }
        return count <= 1;

    }

    public static void main(String[] args) {
        int[] nums1 = {4, 2, 3};
        int[] nums2 = {4, 2, 1};
        int[] nums3 = {1, 8, 10, 5, 7, 8, 11};
        int[] nums4 = {1, 2, 3, 5, 4};

        System.out.println(checkPossibility(nums1));
        System.out.println(checkPossibility(nums2));
        System.out.println(checkPossibility(nums3));
        System.out.println(checkPossibility(nums4));
    }
}
