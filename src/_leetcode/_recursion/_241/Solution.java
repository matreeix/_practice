package _leetcode._recursion._241;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 241. 为运算表达式设计优先级
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 * @Date: 2021/12/31
 */

public class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        int len = expression.length();
        for (int i = 0; i < len; i++) {
            char ch = expression.charAt(i);
            if (ch == '-' || ch == '+' || ch == '*') {
                String exp1 = expression.substring(0, i);
                String exp2 = expression.substring(i + 1);
                List<Integer> set1 = diffWaysToCompute(exp1);
                List<Integer> set2 = diffWaysToCompute(exp2);
                for (int res1 : set1) {
                    for (int res2 : set2) {
                        switch (ch) {
                            case '-':
                                res.add(res1 - res2);
                                break;
                            case '+':
                                res.add(res1 + res2);
                                break;
                            case '*':
                                res.add(res1 * res2);
                                break;
                        }
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.parseInt(expression));
        return res;
    }
}
