package _stack._394;

import java.util.Stack;

/**
 * @Description: 字符串的解码
 * @Author: 67ng
 * @Date: 2020/6/4
 */
public class Solution {
    public static String decodeString(String s) {
        StringBuffer ans = new StringBuffer();//存储字母
        Stack<Integer> multiStack = new Stack<>();//存储次数
        Stack<StringBuffer> ansStack = new Stack<>();
        int multi = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {//数字
                multi = multi * 10 + c - '0';//注意可能有多位数字
            } else if (c == '[') {//左中括号
                ansStack.add(ans);
                multiStack.add(multi);

                //注意置为0
                ans = new StringBuffer();
                multi = 0;
            } else if (Character.isAlphabetic(c)) {//字母
                ans.append(c);
            } else {//右中括号
                StringBuffer ansTmp = ansStack.pop();
                int count = multiStack.pop();
                for (int i = 0; i < count; i++)
                    ansTmp.append(ans);
                ans = ansTmp;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s1 = "3[a]2[bc]";
        String s2 = "3[a2[c]]";
        System.out.println(decodeString(s1));//aaabcbc
        System.out.println(decodeString(s2));//accaccacc
    }
}
