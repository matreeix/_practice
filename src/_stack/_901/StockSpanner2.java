package _stack._901;

import java.util.Stack;

/**
 * @Description: 栈
 * @Date: 2021/3/18
 */

public class StockSpanner2 {
    //双栈
    Stack<Integer> prices, weights;

    public StockSpanner2() {
        prices = new Stack();
        weights = new Stack();
    }

    public int next(int price) {
        int w = 1;
        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            w += weights.pop();
        }

        prices.push(price);
        weights.push(w);
        return w;
    }

    //单栈
    Stack<int[]> stack = new Stack<>();

    public int next2(int price) {
        int res = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price)
            res += stack.pop()[1];
        stack.push(new int[]{price, res});
        return res;
    }

}
