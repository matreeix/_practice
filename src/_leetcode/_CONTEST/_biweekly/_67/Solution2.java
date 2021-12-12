package _leetcode._CONTEST._biweekly._67;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 5935. 适合打劫银行的日子
 * 你和一群强盗准备打劫银行。给你一个下标从 0 开始的整数数组 security ，其中 security[i] 是第 i 天执勤警卫的数量。日子从 0 开始编号。同时给你一个整数 time 。
 * 如果第 i 天满足以下所有条件，我们称它为一个适合打劫银行的日子：
 * 第 i 天前和后都分别至少有 time 天。
 * 第 i 天前连续 time 天警卫数目都是非递增的。
 * 第 i 天后连续 time 天警卫数目都是非递减的。
 * 更正式的，第 i 天是一个合适打劫银行的日子当且仅当：security[i - time] >= security[i - time + 1] >= ... >= security[i] <= ... <= security[i + time - 1] <= security[i + time].
 * 请你返回一个数组，包含 所有 适合打劫银行的日子（下标从 0 开始）。返回的日子可以 任意 顺序排列。
 * 提示：
 * 1 <= security.length <= 10^5
 * 0 <= security[i], time <= 10^5
 * @Date: 2021/12/11
 */

public class Solution2 {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> res = new ArrayList<>();
        int n = security.length;
        int left[] = new int[n], right[] = new int[n];

        for (int i = 1; i < n; i++)
            if (security[i] <= security[i - 1])
                left[i] = left[i - 1] + 1;// 从左往右统计连续递减的元素数量
        for (int i = n - 2; i >= 0; i--)
            if (security[i] <= security[i + 1])
                right[i] = right[i + 1] + 1;// 从右往左统计连续递增的元素数量
        for (int i = time; i < n - time; i++)
            if (left[i] >= time && right[i] >= time)
                res.add(i);
        return res;
    }
}
