package _leetcode._math._390;

/**
 * @Description: 390. 消除游戏
 * 给定一个从1 到 n 排序的整数列表。
 * 首先，从左到右，从第一个数字开始，每隔一个数字进行删除，直到列表的末尾。
 * 第二步，在剩下的数字中，从右到左，从倒数第一个数字开始，每隔一个数字进行删除，直到列表开头。
 * 我们不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
 * 返回长度为 n 的列表中，最后剩下的数字。
 * @Created by: matreeix
 * @Date: 2021/5/10
 */
public class Solution {
    //模拟法
    public int lastRemaining(int n) {
        return leftToRight(n);
    }

    // eliminate [1...n] first from left to right, then alternate
    private int leftToRight(int n) {
        if (n == 1) return 1;
        // scan from left to right is simple, the length of array doesn't matter
        // [1, 2, 3, 4] -> 2 * [1, 2]
        // [1, 2, 3, 4, 5] -> 2 * [1, 2]
        return 2 * rightToLeft(n / 2);
    }

    // eliminate [1...n] first from right to left, then alternate
    private int rightToLeft(int n) {
        if (n == 1) return 1;
        // if the length of array is even, we will get only odd number
        // [1, 2, 3, 4] -> [1, 3] = 2 * [1, 2] - 1
        if (n % 2 == 0) return 2 * leftToRight(n / 2) - 1;
            // else if the length of array is odd, we will get only even number
            // [1, 2, 3, 4, 5] -> [2, 4] = 2 * [1, 2]
        else return 2 * leftToRight(n / 2);
    }

    //简单递归，妙啊！
    /**
     * 假如输入为 n，我们使用 f(n) 表示 从左到右(forward) 的最终结果，使用 b(n)表示 从右到左(backward) 的最终结果。则：
     * <p>
     * 当 n = 1 时，存在 f(n) = 1, b(n) = 1
     * 对于任意 n，存在 f(n) + b(n) = n + 1
     * 对于 n > 2 的情况下，f(n) = 2 * b(n / 2)
     * 所以：f(n) = 2 * (n / 2 + 1 - f(n / 2))
     */
    public int lastRemaining2(int n) {
        return n == 1 ? 1 : 2 * (n / 2 + 1 - lastRemaining2(n / 2));
    }

    //迭代法
    public int lastRemaining3(int n) {
        boolean left = true;
        int remaining = n;
        int step = 1;
        int head = 1;
        while (remaining > 1) {
            if (left || remaining % 2 == 1) {
                head = head + step;
            }
            remaining = remaining / 2;
            step = step * 2;
            left = !left;
        }
        return head;
    }

}
