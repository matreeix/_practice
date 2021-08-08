package _leetcode._CONTEST._weekly._253;

import org.omg.CORBA.INTERNAL;

import java.util.Stack;

/**
 * @Description: 5840. 使字符串平衡的最小交换次数
 * 给你一个字符串 s ，下标从 0 开始 ，且长度为偶数 n 。字符串 恰好 由 n / 2 个开括号 '[' 和 n / 2 个闭括号 ']' 组成。
 * 只有能满足下述所有条件的字符串才能称为 平衡字符串 ：
 * 字符串是一个空字符串，或者
 * 字符串可以记作 AB ，其中 A 和 B 都是 平衡字符串 ，或者
 * 字符串可以写成 [C] ，其中 C 是一个 平衡字符串 。
 * 你可以交换 任意 两个下标所对应的括号 任意 次数。
 * 返回使 s 变成 平衡字符串 所需要的 最小 交换次数。
 * 提示：
 * <p>
 * n == s.length
 * 2 <= n <= 10^6
 * n 为偶数
 * s[i] 为'[' 或 ']'
 * 开括号 '[' 的数目为 n / 2 ，闭括号 ']' 的数目也是 n / 2
 * @Date: 2021/8/8
 */

public class Solution3 {
    public static int minSwaps(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.size() > 0) {
                if (s.charAt(i) == ']') {
                    if (stack.peek() == -1) {
                        stack.pop();
                    } else {
                        stack.push(1);
                    }
                } else {
                    stack.push(-1);
                }
            } else {
                stack.push(s.charAt(i) == '[' ? -1 : 1);
            }
        }
        int cnt = stack.size();
        if (cnt == 0) return 0;
        return (cnt / 2 + 1) / 2;
    }

    public static void main(String[] args) {
        System.out.println(minSwaps("[[[]]]][][]][[]]][[["));
    }
}
