package _Cracking_the_Coding_Interview._16._10;

/**
 * @Description: 面试题 16.10. 生存人数
 * 给定 N 个人的出生年份和死亡年份，第 i 个人的出生年份为 birth[i]，死亡年份为 death[i]，实现一个方法以计算生存人数最多的年份。
 *
 * 你可以假设所有人都出生于 1900 年至 2000 年（含 1900 和 2000 ）之间。如果一个人在某一年的任意时期处于生存状态，那么他应该被纳入那一年的统计中。例如，生于 1908 年、死于 1909 年的人应当被列入 1908 年和 1909 年的计数。
 *
 * 如果有多个年份生存人数相同且均为最大值，输出其中最小的年份。
 * @Author: matreeix
 * @Date: 2020/10/31
 */

public class Solution {
    public int maxAliveYear(int[] birth, int[] death) {
        int[] changes = new int[102];
        int len = birth.length, res = 1900, max_alive = 0, cur_alive = 0;
        for (int i = 0; i < len; ++i) {
            ++changes[birth[i] - 1900];
            --changes[death[i] - 1899];
        }
        for (int i = 1; i < 101; ++i) {
            cur_alive += changes[i];
            if (cur_alive > max_alive) {
                max_alive = cur_alive;
                res = 1900 + i;
            }
        }
        return res;
    }
}
