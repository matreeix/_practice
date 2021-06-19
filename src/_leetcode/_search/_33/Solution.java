package _leetcode._search._33;

/**
 * @Description: 查找类似[4,5,6,7,0,1,2]数组的指定数
 * @Author: matreeix
 * @Date: 2019/9/1 10:01
 */
public class Solution {

    public int search(int[] nums, int target) {
        if (nums.length == 0)return -1;
        int minIdx = findMinIdx(nums);
        if (target == nums[minIdx]) return minIdx;
        int m = nums.length;
        //确定二分查找的左右边界
        int start = (target <= nums[m - 1]) ? minIdx : 0;
        int end = (target > nums[m - 1]) ? minIdx : m - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (target > nums[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    //找到最小值的索引
    public int findMinIdx(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) start = mid + 1;
            else end = mid;
        }
        return start;
    }
}
