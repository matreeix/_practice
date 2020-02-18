package _other._81;

/**
 * @Description: 和问题33类似，不过含有重复数字
 * @Author: 67ng
 * @Date: 2019/9/1 10:01
 */
public class Solution {
    public static boolean search(int[] nums, int target) {

        int left = 0, right = nums.length - 1, mid;

        while (left <= right) {
            mid = (left + right) >> 1;
            if (nums[mid] == target) return true;

            // the only difference from the first one, trickly case, just update left and right
            if ((nums[left] == nums[mid]) && (nums[right] == nums[mid])) {
                ++left;
                --right;
            } else if (nums[left] <= nums[mid]) {
                if ((nums[left] <= target) && (nums[mid] > target)) right = mid - 1;
                else left = mid + 1;
            } else {
                if ((nums[mid] < target) && (nums[right] >= target)) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 0, 0, 1, 2};
        System.out.println(search(arr, 0));
    }
}
