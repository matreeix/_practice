package _leetcode._CONTEST._weekly._270;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 5942. 找出 3 位偶数
 * 给你一个整数数组 digits ，其中每个元素是一个数字（0 - 9）。数组中可能存在重复元素。
 * 你需要找出 所有 满足下述条件且 互不相同 的整数：
 * 该整数由 digits 中的三个元素按 任意 顺序 依次连接 组成。
 * 该整数不含 前导零
 * 该整数是一个 偶数
 * 例如，给定的 digits 是 [1, 2, 3] ，整数 132 和 312 满足上面列出的全部条件。
 * 将找出的所有互不相同的整数按 递增顺序 排列，并以数组形式返回。
 * 提示：
 * 3 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * @Date: 2021/12/5
 */

public class Solution1 {
    public int[] findEvenNumbers(int[] digits) {
        int[] nums = new int[10];
        for (int digit : digits) {
            nums[digit]++; // 统计原有的每一个数字[0-9]的计数
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 100; i <= 998; i += 2) {
            int x = i;
            int[] cnt = new int[10]; // 统计目前判断的偶数的每一位数字[0-9]的计数
            boolean flag = true;
            while (x != 0) {
                int c = x % 10;
                cnt[c]++;
                if (cnt[c] > nums[c]) {
                    flag = false;
                    break;
                }
                x /= 10;
            }
            if (flag) {
                ans.add(i);
            }
        }
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int[] findEvenNumbers2(int[] digits) {
        List<Integer> ans = new ArrayList<>();
        int[] cnt = new int[10];
        for (int d : digits)
            ++cnt[d];
        for (int i = 1; i < 10; ++i)// 百位数
            for (int j = 0; cnt[i] > 0 && j < 10; ++j)// 十位数
                for (int k = 0; cnt[j] > (i == j ? 1 : 0) && k < 10; k += 2)// 个位数
                    if (cnt[k] > (k == i ? 1 : 0) + (k == j ? 1 : 0))
                        ans.add(i * 100 + j * 10 + k);
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }
}
