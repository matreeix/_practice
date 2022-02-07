package _leetcode._CONTEST._biweekly._71;

/**
 * @Description: 2160. 拆分数位后四位数字的最小和
 * 给你一个四位 正 整数 num 。请你使用 num 中的 数位 ，将 num 拆成两个新的整数 new1 和 new2 。new1 和 new2 中可以有 前导 0 ，且 num 中 所有 数位都必须使用。
 * 比方说，给你 num = 2932 ，你拥有的数位包括：两个 2 ，一个 9 和一个 3 。一些可能的 [new1, new2] 数对为 [22, 93]，[23, 92]，[223, 9] 和 [2, 329] 。
 * 请你返回可以得到的 new1 和 new2 的 最小 和。
 * @Date: 2022/2/7
 */

public class Solution1 {
    public int minimumSum(int num) {
        int[] nums = new int[4];
        int idx = 0;
        while (num > 0) {
            nums[idx++] = num % 10;
            num /= 10;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        int res = 0;
        res += nums[3];
        res += nums[2];
        res += 10 * nums[1];
        res += 10 * nums[0];
        return res;
    }
}
