package _leetcode._CONTEST._weekly._287;

/**
 * @Description: 6055. 转化时间需要的最少操作数
 * 给你两个字符串 current 和 correct ，表示两个 24 小时制时间 。
 * 24 小时制时间 按 "HH:MM" 进行格式化，其中 HH 在 00 和 23 之间，而 MM 在 00 和 59 之间。最早的 24 小时制时间为 00:00 ，最晚的是 23:59 。
 * 在一步操作中，你可以将 current 这个时间增加 1、5、15 或 60 分钟。你可以执行这一操作 任意 次数。
 * 返回将 current 转化为 correct 需要的 最少操作数 。
 * 提示：
 * current 和 correct 都符合 "HH:MM" 格式
 * current <= correct
 * @Date: 2022/4/4
 */

public class Solution1 {
    public int convertTime(String current, String correct) {
        int cur = Integer.parseInt(current.substring(0, 2)) * 60 + Integer.parseInt(current.substring(3));
        int cor = Integer.parseInt(correct.substring(0, 2)) * 60 + Integer.parseInt(correct.substring(3));
        int dif = cor - cur;
        int res = 0;
        int[] t = {60, 15, 5, 1};
        for (int j : t) {
            res += dif / j;
            dif %= j;
        }
        return res;
    }
}
