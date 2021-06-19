package _leetcode._CONTEST._biweekly._31;

/**
 * @Description: 1526. 形成目标数组的子数组最少增加次数
 * 给你一个整数数组 target 和一个数组 initial ，initial 数组与 target  数组有同样的维度，且一开始全部为 0 。
 * 请你返回从 initial 得到  target 的最少操作次数，每次操作需遵循以下规则：
 * 在initial中选择 任意 子数组，并将子数组中每个元素增加 1 。
 * 答案保证在 32 位有符号整数以内。
 * @Author: matreeix
 * @Date: 2020/7/27
 */

public class Solution4 {
    public int minNumberOperations(int[] A) {
        int res = 0, pre = 0;
        for (int a : A) {
            res += Math.max(a - pre, 0);
            pre = a;
        }
        return res;
    }

}




