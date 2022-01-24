package _leetcode._CONTEST._weekly._277;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 5990. 找出数组中的所有孤独数字
 * 给你一个整数数组 nums 。如果数字 x 在数组中仅出现 一次 ，且没有 相邻 数字（即，x + 1 和 x - 1）出现在数组中，则认为数字 x 是 孤独数字 。
 * 返回 nums 中的 所有 孤独数字。你可以按 任何顺序 返回答案。
 * 提示：
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^6
 * @Date: 2022/1/23
 */

public class Solution3 {
    public List<Integer> findLonely(int[] nums) {
        int N = 1000001;
        int[] cnt = new int[N];
        for (int num : nums)
            cnt[num]++;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 1
                    && (i <= 0 || cnt[i - 1] == 0)
                    && (i >= N - 1 || cnt[i + 1] == 0)) {
                res.add(i);
            }
        }
        return res;
    }
}
