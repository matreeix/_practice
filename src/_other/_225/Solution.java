package _other._225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 两个队列实现栈
 * @Author: caffebaby
 * @Date: 2019/8/14 20:41
 */
public class Solution {
    class MyStack {
        private Queue<Integer> data;
        private Queue<Integer> help;//存储数据使用

        /**
         * Initialize your data structure here.
         */
        public MyStack() {//用链表实现的队列
            data = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        /**
         * Push element x onto stack.
         */
        //data:1->2->3->4->5->null
        public void push(int x) {
            data.add(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            if (data.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            while (data.size() > 1) {
                help.add(data.poll());//help:1->2->3->4->null
            }
            int res = data.poll();//5
            swap();//help:null,data:1->2->3->4->null
            return res;
        }

        /**
         * Get the top element.
         */
        public int top() {
            if (data.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            while (data.size() != 1) {
                help.add(data.poll());
            }
            int res = data.poll();
            help.add(res);//记着要添加取出的栈顶元素
            swap();
            return res;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            if (data.isEmpty()) return true;
            return false;
        }

        private void swap() {//交换两个链表的引用
            Queue<Integer> tmp = help;
            help = data;
            data = tmp;
        }

    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */


}
