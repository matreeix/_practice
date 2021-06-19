package _leetcode.IQ_test._292;

/**
 * @Description: 292. Nim 游戏
 * 你和你的朋友，两个人一起玩 Nim 游戏：
 * <p>
 * 桌子上有一堆石头。
 * 你们轮流进行自己的回合，你作为先手。
 * 每一回合，轮到的人拿掉 1 - 3 块石头。
 * 拿掉最后一块石头的人就是获胜者。
 * j假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为 n 的情况下赢得游戏。如果可以赢，返回 true；否则，返回 false 。
 * @Author: matreeix
 * @Date: 2020/10/27
 */

public class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    //DP
    public boolean canWinNim2(int n) {
        if(n <= 0)
            throw new IllegalArgumentException();
        if(n < 4)
            return true;
        boolean[] res = new boolean[n + 1];
        res[0] = true;
        res[1] = true;
        res[2] = true;
        res[3] = true;
        for(int i = 4 ; i <= n ; i++)
            res[i] = !(res[i - 1] && res[i - 2] && res[i - 3]);
        return res[n];
    }
}
