package _leetcode.IQ_test._1025;

/**
 * @Description: 除数游戏
 * <p>
 * 题目：
 * 爱丽丝和鲍勃轮流玩游戏，爱丽丝先开始。
 * 最初，N 黑板上有一个数字。在每个玩家的回合中，该玩家可以做出一些操作，包括：
 *
 * x，用0 < x < N和选择任何一个N % x == 0。
 * N ，用N - x替换黑板上的数字 N。
 *
 * 同样，如果下一位玩家不能做任何操作，他就会输掉比赛。
 * True当且仅当爱丽丝（Alice）赢得比赛时才返回，假设两个玩家都十分聪明。
 * <p>
 *
 * 分析：爱丽丝只要保证每次返给鲍勃的数是奇数即可保证稳赢。
 *
 * @Author: matreeix
 * @Date: 2020/2/24
 */
public class Solution {

    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }

}
