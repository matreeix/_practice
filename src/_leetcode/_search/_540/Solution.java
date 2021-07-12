package _leetcode._search._540;

/**
 * @Description: 540. 有序数组中的单一元素
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 * @Date: 2021/7/9
 */

public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == nums[mid + 1]) {
                int len = r - mid + 1;
                if (len % 2 == 0) r = mid - 1;
                else l = mid;
            } else if (nums[mid] == nums[mid - 1]) {
                int len = mid - l + 1;
                if (len % 2 == 0) l = mid + 1;
                else r = mid;
            } else {
                return nums[mid];
            }
        }
        return nums[l];
    }

    public int singleNonDuplicate2(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid % 2 == 1) mid--;
            if (nums[mid] == nums[mid + 1]) {
                lo = mid + 2;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }
}
