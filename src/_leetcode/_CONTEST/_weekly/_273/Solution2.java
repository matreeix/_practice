package _leetcode._CONTEST._weekly._273;

/**
 * @Description: 5964. 执行所有后缀指令
 * 现有一个 n x n 大小的网格，左上角单元格坐标 (0, 0) ，右下角单元格坐标 (n - 1, n - 1) 。给你整数 n 和一个整数数组 startPos ，其中 startPos = [startrow, startcol] 表示机器人最开始在坐标为 (startrow, startcol) 的单元格上。
 * 另给你一个长度为 m 、下标从 0 开始的字符串 s ，其中 s[i] 是对机器人的第 i 条指令：'L'（向左移动），'R'（向右移动），'U'（向上移动）和 'D'（向下移动）。
 * 机器人可以从 s 中的任一第 i 条指令开始执行。它将会逐条执行指令直到 s 的末尾，但在满足下述条件之一时，机器人将会停止：!
 * 下一条指令将会导致机器人移动到网格外。
 * 没有指令可以执行。
 * 返回一个长度为 m 的数组 answer ，其中 answer[i] 是机器人从第 i 条指令 开始 ，可以执行的 指令数目 。
 * 提示：
 * m == s.length
 * 1 <= n, m <= 500
 * startPos.length == 2
 * 0 <= startrow, startcol < n
 * s 由 'L'、'R'、'U' 和 'D' 组成
 * @Date: 2021/12/26
 */

public class Solution2 {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] res = new int[s.length()];
        for (int i = 0; i < res.length; i++) {
            for (int j = i, x = startPos[0], y = startPos[1]; j < s.length(); j++) {
                switch (s.charAt(j)) {
                    case 'U':
                        x -= 1;
                        break;
                    case 'D':
                        x += 1;
                        break;
                    case 'L':
                        y -= 1;
                        break;
                    case 'R':
                        y += 1;
                        break;
                }
                if (0 <= x && x < n && 0 <= y && y < n) res[i]++;
                else break;
            }
        }
        return res;
    }
}
