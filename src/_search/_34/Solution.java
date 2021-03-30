package _search._34;

/**
 * @Description: 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * @Date: 2021/3/30
 */

public class Solution {

    public static int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                //注意：特殊情况下是O(n)
                int min = mid, max = mid;
                while (min > -1 && nums[min] == target) min--;
                while (max < nums.length && nums[max] == target) max++;
                return new int[]{min + 1, max - 1};
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] searchRange2(int[] nums, int target) {
        return new int[]{
                find(nums, target, true),
                find(nums, target, false),
        };
    }

    //O（log n）
    private static int find(int[] nums, int target, boolean isMin) {
        int l = 0;
        int r = nums.length - 1;
        int keyIndex = -1;
        while (l <= r) {
            int middle = l + (r - l) / 2;
            if (target > nums[middle]) {
                l = middle + 1;
            } else if (target < nums[middle]) {
                r = middle - 1;
            } else {
                keyIndex = middle;
                if (isMin) r = middle - 1;
                else l = middle + 1;
            }
        }
        return keyIndex;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(searchRange(nums, 1));
    }

}
