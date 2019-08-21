package _150;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: 计算逆波兰表达式
 * @Author: 67ng
 * @Date: 2019/8/20 21:44
 */
public class Solution {
    public static int evalRPN(String[] tokens) {

        List<String> list = new ArrayList<String>();
        for (String ele : tokens) {
            list.add(ele);
        }
        // 创建给栈, 只需要一个栈即可
        Stack<String> stack = new Stack<String>();
        // 遍历 ls
        for (String item : list) {
            // 这里使用正则表达式来取出数
            if (item.matches("\\d+") || item.length() >= 2) { // 匹配的是多位数
                // 入栈
                stack.push(item);
            } else {
                // pop出两个数，并运算， 再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //把res 入栈
                stack.push("" + res);
            }

        }
        //最后留在stack中的数据是运算结果
        return Integer.parseInt(stack.pop());

    }

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));

    }


}
