package _other._232;

import java.util.Stack;

/**
 * @Description: 两个栈实现队列
 * @Author: caffebaby
 * @Date: 2019/8/14 20:40
 */
public class Solution {
    class MyQueue {
        private Stack<Integer> stackPush;//压入栈
        private Stack<Integer> stackPop;//弹出栈

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            stackPush.push(x);
            dao();
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {//经过两个栈，数据变为先进先出
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            }
            dao();
            return stackPop.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            }
            dao();
            return stackPop.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            if (stackPop.empty() && stackPush.empty()) return true;
            return false;
        }
        public void dao() {//如果弹出栈为空，压入栈将所有数据放进弹出栈
            if (!stackPop.isEmpty()) {//注意这里，弹出栈为空后，压入站才能往里面放数据，否则数据顺序会混乱
                return;
            }
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */


}
