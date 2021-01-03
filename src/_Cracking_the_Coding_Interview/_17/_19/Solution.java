package _Cracking_the_Coding_Interview._17._19;

import java.util.Arrays;

/**
 * @Description: 面试题 17.19. 消失的两个数字
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 * 以任意顺序返回这两个数字均可。
 * 提示：
 * nums.length <= 30000
 * @Date: 2021/1/1
 */

public class Solution {
    //排序法,O(n * logn)
    public int[] missingTwo(int[] nums) {
        Arrays.sort(nums);
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i + 2 == nums[i]) {
                a = a == 0 ? i + 1 : a;
            } else if (i + 3 == nums[i]) {
                b = i + 2;
                a = a == 0 ? i + 1 : a;
                break;
            }
        }
        if (a == 0) a = nums.length + 1;
        if (b == 0) b = nums.length + 2;


        return new int[]{a, b};
    }

    //求和
    public int[] missingTwo2(int[] nums) {
        int n = nums.length + 2;
        int sum = 0;
        for (int x : nums) sum += x;

        int sumTwo = n * (n + 1) / 2 - sum, limits = sumTwo / 2;
        sum = 0;
        for (int x : nums)
            if (x <= limits) sum += x; // 两个数不相同那么一个大于，一个小于
        int one = limits * (limits + 1) / 2 - sum;
        return new int[]{one, sumTwo - one};

    }
}












