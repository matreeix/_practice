package _leetcode._stack._844;

import java.util.Stack;

/**
 * @Description: 844. 比较含退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * 提示：
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 * 进阶：你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 * @Created by: matreeix
 * @Date: 2021/5/4
 */
public class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '#' && stack1.size() > 0) stack1.pop();
            else if (ch != '#') stack1.push(ch);
        }

        for (char ch : t.toCharArray()) {
            if (ch == '#' && stack2.size() > 0) stack2.pop();
            else if (ch != '#') stack2.push(ch);
        }

        if (stack1.size() != stack2.size()) return false;
        while (stack1.size() > 0)
            if (stack1.pop() != stack2.pop())
                return false;
        return true;
    }

    //重构字符串
    public boolean backspaceCompare2(String s, String t) {
        return getString(s).equals(getString(t));
    }

    public String getString(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        while (stringBuilder.indexOf("#") != -1) {
            int index = stringBuilder.indexOf("#");
            if (index >= 1) {
                stringBuilder.delete(index - 1, index + 1);
            } else {
                stringBuilder.deleteCharAt(index);
            }
        }
        return stringBuilder.toString();
    }

    //双指针
    public boolean backspaceCompare3(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;
        while (i >= 0 || j >= 0) {
            //找到c1中的有效字母
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            // 找到c2中的有效字母
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {//这里是为了避免outofindex问题
                if (i >= 0 || j >= 0) {//如果只有一个为负这说明长短不一致
                    return false;
                }//都为负的时候说明都没有字母可以比较了，为空，也为true
            }
            //比较成功才会到这里，说明当前字母匹配，继续下一位
            i--;
            j--;
        }
        return true;
    }
}
