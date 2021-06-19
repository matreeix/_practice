package _leetcode._stack._155;

import java.util.Stack;

/**
 * @Description: 使用一个栈
 * @Date: 2021/4/1
 */

public class MinStack3 {

    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();

    public void push(int x) {//这种操作会压入很多无关的元素，并不会节省空间，只是一种炫技。。。。
        //当前值更小
        if (x <= min) {
            //将之前的最小值保存
            stack.push(min);
            //更新最小值
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        //如果弹出的值是最小值，那么将下一个元素更新为最小值
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

}
