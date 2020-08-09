package _CONTEST._weekly._201;

import java.util.Stack;

/**
 * @Description: 5483. 整理字符串
 * 给你一个由大小写英文字母组成的字符串 s 。
 * <p>
 * 一个整理好的字符串中，两个相邻字符 s[i] 和 s[i + 1] 不会同时满足下述条件：
 * <p>
 * 0 <= i <= s.length - 2
 * s[i] 是小写字符，但 s[i + 1] 是对应的大写字符；反之亦然 。
 * 请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。
 * <p>
 * 请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。
 * <p>
 * 注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。
 * @Author: Pythagodzilla
 * @Date: 2020/8/9
 */

public class Solution1 {

    public String makeGood(String s) {
        if (s == null || s.length() == 0) return s;
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (stack.size() != 0 && Math.abs(stack.peek() - ch) == 32) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() != 0) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {


    }
}
