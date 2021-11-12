package _leetcode._hashtable._2023;

/**
 * @Description: 2023. 连接后等于目标字符串的字符串对
 * 给你一个 数字 字符串数组 nums 和一个 数字 字符串 target ，请你返回 nums[i] + nums[j] （两个字符串连接）结果等于 target 的下标 (i, j) （需满足 i != j）的数目。
 * @Date: 2021/11/11
 */

public class Solution {

    /**
     * 前缀和、后缀和
     */
    public int numOfPairs(String[] nums, String target) {
        int n = target.length(), ans = 0;
        int[] startRes = new int[n], endRes = new int[n];
        for (String num : nums) {
            int m = num.length();
            if (m >= n) continue;
            boolean start = target.startsWith(num);
            boolean end = target.endsWith(num);
            if (start) ans += endRes[n - m];
            if (end) ans += startRes[n - m];
            if (start) startRes[m]++;
            if (end) endRes[m]++;
        }

        return ans;
    }
}
