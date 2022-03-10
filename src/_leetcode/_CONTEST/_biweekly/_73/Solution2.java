package _leetcode._CONTEST._biweekly._73;

import java.util.Arrays;

/**
 * @Description: 2191. 将杂乱无章的数字排序
 * 给你一个下标从 0 开始的整数数组 mapping ，它表示一个十进制数的映射规则，mapping[i] = j 表示这个规则下将数位 i 映射为数位 j 。
 * 一个整数 映射后的值 为将原数字每一个数位 i （0 <= i <= 9）映射为 mapping[i] 。
 * 另外给你一个整数数组 nums ，请你将数组 nums 中每个数按照它们映射后对应数字非递减顺序排序后返回。
 * 注意：
 * 如果两个数字映射后对应的数字大小相同，则将它们按照输入中的 相对顺序 排序。
 * nums 中的元素只有在排序的时候需要按照映射后的值进行比较，返回的值应该是输入的元素本身。
 * @Date: 2022/3/8
 */

public class Solution2 {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        long[] hash = new long[n];
        for (int i = 0; i < n; i++) {
            hash[i] = (long) map(mapping, nums[i]) * (n + 1) + i;
        }
        Arrays.sort(hash);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nums[(int) (hash[i] % (n + 1))];
        }
        return res;
    }

    private int map(int[] mapping, int num) {
        if (num == 0) return mapping[0];
        int res = 0;
        int bit = 1;
        while (num > 0) {
            res += mapping[num % 10] * bit;
            bit *= 10;
            num /= 10;
        }
        return res;
    }
}
