package _leetcode._search._410;

/**
 * @Description: 410. 分割数组的最大值
 * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。
 * 设计一个算法使得这 m 个子数组各自和的最大值最小。
 * 注意:
 * 数组长度 n 满足以下条件:
 * 1.1 ≤ n ≤ 1000
 * 2.1 ≤ m ≤ min(50, n)
 * @Author: matreeix
 * @Date: 2020/8/16
 */

public class Solution {

    public int splitArray(int[] nums, int m) {
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
            if (left < nums[i]) {
                left = nums[i];
            }
        }
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (check(nums, mid, m)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[] nums, int x, int m) {
        int sum = 0;
        int cnt = 1;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > x) {
                cnt++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        return cnt <= m;
    }


    public static void main(String[] args) {
//        int[] nums = {7, 2, 5, 10, 8};
//        int m = 2;

        int[] nums = {1, 2147483647};
        int m = 2;

        Solution solution = new Solution();
        System.out.println(solution.splitArray(nums, m));
    }
}
