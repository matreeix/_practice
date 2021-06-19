package _leetcode._stack._394;

import java.util.Stack;

/**
 * @Description: 字符串的解码
 * @Author: matreeix
 * @Date: 2020/6/4
 */
public class Solution {
    public static String decodeString(String s) {
        StringBuffer ans = new StringBuffer();//存储字母
        Stack<Integer> multiStack = new Stack<>();//存储次数
        Stack<StringBuffer> ansStack = new Stack<>();//存储结果
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

    //递归，利用编译原理的巴科斯范式(BNF)
    String src;
    int ptr;

    public String decodeString2(String s) {
        src = s;
        ptr = 0;
        return getString();
    }

    public String getString() {
        if (ptr == src.length() || src.charAt(ptr) == ']') {
            // String -> EPS
            return "";
        }

        char cur = src.charAt(ptr);
        int repTime = 1;
        String ret = "";

        if (Character.isDigit(cur)) {
            // String -> Digits [ String ] String
            // 解析 Digits
            repTime = getDigits();
            // 过滤左括号
            ++ptr;
            // 解析 String
            String str = getString();
            // 过滤右括号
            ++ptr;
            // 构造字符串
            while (repTime-- > 0) {
                ret += str;
            }
        } else if (Character.isLetter(cur)) {
            // String -> Char String
            // 解析 Char
            ret = String.valueOf(src.charAt(ptr++));
        }

        return ret + getString();
    }

    public int getDigits() {
        int ret = 0;
        while (ptr < src.length() && Character.isDigit(src.charAt(ptr))) {
            ret = ret * 10 + src.charAt(ptr++) - '0';
        }
        return ret;
    }

    //递归，DFS
    public String decodeString3(String s) {
        return dfs(s, 0)[0];
    }

    private String[] dfs(String s, int i) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {//数字
                multi = multi * 10 + s.charAt(i) - '0';
            } else if (Character.isAlphabetic(s.charAt(i))) {//字母
                res.append(s.charAt(i));
            } else if (s.charAt(i) == '[') {
                String[] tmp = dfs(s, i + 1);
                i = Integer.parseInt(tmp[0]);
                while (multi > 0) {
                    res.append(tmp[1]);
                    multi--;
                }
            } else {//if (s.charAt(i) == ']')
                return new String[]{String.valueOf(i), res.toString()};
            }
            i++;
        }
        return new String[]{res.toString()};
    }

    public static void main(String[] args) {
        String s1 = "3[a]2[bc]";
        String s2 = "3[a2[c]]";
        System.out.println(decodeString(s1));//aaabcbc
        System.out.println(decodeString(s2));//accaccacc
    }
}
