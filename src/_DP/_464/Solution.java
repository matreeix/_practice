package _DP._464;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

/**
 * @Description: 464. 我能赢吗
 * 在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和达到或超过 100 的玩家，即为胜者。
 * 如果我们将游戏规则改为 “玩家不能重复使用整数” 呢？
 * 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
 * 给定一个整数 maxChoosableInteger （整数池中可选择的最大数）和另一个整数 desiredTotal（累计和），判断先出手的玩家是否能稳赢（假设两位玩家游戏时都表现最佳）？
 * 你可以假设 maxChoosableInteger 不会大于 20， desiredTotal 不会大于 300。
 * @Author: matreeix
 * @Date: 2020/4/19
 */
public class Solution {

    //回溯法
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;
        return canIWin(desiredTotal, new int[maxChoosableInteger], new HashMap<>());
    }

    private boolean canIWin(int total, int[] state, HashMap<String, Boolean> hashMap) {
        String curr = Arrays.toString(state);//记录选择数字的状态
        if (hashMap.containsKey(curr))//跳过选择了的
            return hashMap.get(curr);
        for (int i = 0; i < state.length; i++) {//遍历所有数字，索引代表数字大小
            if (state[i] == 0) {//未选择过
                state[i] = 1;
                if (total <= i + 1 || !canIWin(total - (i + 1), state, hashMap)) {
                    hashMap.put(curr, true);
                    state[i] = 0;
                    return true;
                }
                state[i] = 0;
            }
        }
        hashMap.put(curr, false);//遍历完数字都没得到结果
        return false;
    }

    public boolean canIWin2(int maxChoosableInteger, int desiredTotal) {
        if (IntStream.rangeClosed(1, maxChoosableInteger).sum() < desiredTotal) {
            return false;
        } else {
            int[] dp = new int[1 << maxChoosableInteger];
            return canIWin2(dp, 0, desiredTotal, maxChoosableInteger);
        }
    }

    private boolean canIWin2(int[] dp, int state, int goal, int max) {
        if (dp[state] != 0)
            return dp[state] == 1 ? true : false;
        for (int ptr = 1 << max - 1, num = max; ptr > 0; ptr >>= 1, num--) {
            if ((ptr & state) != 0) continue;
            if (num >= goal) {
                dp[state] = 1;
                return true;
            }
            state |= ptr;
            boolean flag = canIWin2(dp, state, goal - num, max);
            state ^= ptr;
            if (!flag) {
                dp[state] = 1;
                return true;
            }
        }
        dp[state] = -1;
        return false;
    }
}
