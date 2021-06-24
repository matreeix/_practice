package _leetcode._stack._735;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Description: 735. 行星碰撞
 * 给定一个整数数组 asteroids，表示在同一行的行星。
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 * <p>
 * 提示：
 * 2 <= asteroids.length <= 10^4
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 * @Created by: matreeix
 * @Date: 2021/6/24
 */
public class Solution {
    //栈
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int a : asteroids) {
            if (stack.size() > 0 && a < 0) {
                while (stack.size() != 0 && stack.peek() > 0 && stack.peek() + a < 0) {
                    stack.pop();
                }
                if (stack.size() == 0 || stack.peek() < 0) stack.push(a);
                if (stack.peek() + a == 0) stack.pop();
            } else {
                stack.push(a);
            }
        }
        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

    //双指针
    public int[] asteroidCollision2(int[] asteroides) {
        int i = 1;
        int j = 0;
        int quantidade = asteroides.length;
        while (i < quantidade) {
            if (j >= 0 && asteroides[j] > 0 && asteroides[i] < 0) {
                if (Math.abs(asteroides[i]) == asteroides[j]) {
                    j--;
                    i++;
                } else if (asteroides[j] > Math.abs(asteroides[i])) {
                    i++;
                } else {
                    j--;
                }
            } else {
                asteroides[j + 1] = asteroides[i];
                j++;
                i++;
            }
        }
        int[] resposta = new int[j + 1];
        for (int y = 0; y <= j; y++) {
            resposta[y] = asteroides[y];
        }
        return resposta;
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, -5};
        System.out.println(Arrays.toString(asteroidCollision(arr)));
    }
}
