package _leetcode._CONTEST._biweekly._55;

/**
 * @Description: 5780. 删除一个元素使数组严格递增
 * 给你一个下标从 0 开始的整数数组 nums ，如果 恰好 删除 一个 元素后，数组 严格递增 ，那么请你返回 true ，否则返回 false 。如果数组本身已经是严格递增的，请你也返回 true 。
 * <p>
 * 数组 nums 是 严格递增 的定义为：对于任意下标的 1 <= i < nums.length 都满足 nums[i - 1] < nums[i] 。
 * @Created by: matreeix
 * @Date: 2021/6/26
 */
public class Solution1 {
    public static boolean canBeIncreasing(int[] nums) {
        int cnt = 0;
        int mark = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                cnt++;
                mark = i - 1;
                if (cnt > 1) return false;
            }
        }
        if (mark == 0 || mark == -1 || mark == nums.length - 2) return true;
        int min = Math.min(nums[mark], nums[mark + 1]);
        int max = Math.max(nums[mark], nums[mark + 1]);
        if (nums[mark - 1] < min && min < nums[mark + 2]
                || nums[mark - 1] < max && max < nums[mark + 2]) return true;
        else return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 10, 5, 7};
        int[] nums2 = {2, 3, 1, 2};
        int[] nums3 = {1, 1, 1};
        int[] nums4 = {1, 2, 3};
        int[] nums5 = {105, 924, 32, 968};
//        System.out.println(canBeIncreasing(nums1));
//        System.out.println(canBeIncreasing(nums2));
//        System.out.println(canBeIncreasing(nums3));
//        System.out.println(canBeIncreasing(nums4));
        System.out.println(canBeIncreasing(nums5));
    }
}
