package _leetcode._CONTEST._biweekly._73;

/**
 * @Description: 2190. 数组中紧跟 key 之后出现最频繁的数字
 * 给你一个下标从 0 开始的整数数组 nums ，同时给你一个整数 key ，它在 nums 出现过。
 * 统计 在 nums 数组中紧跟着 key 后面出现的不同整数 target 的出现次数。换言之，target 的出现次数为满足以下条件的 i 的数目：
 * 0 <= i <= n - 2
 * nums[i] == key 且
 * nums[i + 1] == target 。
 * 请你返回出现 最多 次数的 target 。测试数据保证出现次数最多的 target 是唯一的
 * @Date: 2022/3/8
 */

public class Solution1 {
    public int mostFrequent(int[] nums, int key) {

        int[] cnt = new int[1001];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                cnt[nums[i + 1]]++;
            }
        }
        int res = 0;
        int cur = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > cur) {
                res = i;
                cur = cnt[i];
            }
        }
        return res;
    }
}
