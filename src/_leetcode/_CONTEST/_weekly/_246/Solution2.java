package _leetcode._CONTEST._weekly._246;

/**
 * @Description: 5789. 你完成的完整对局数
 * 一款新的在线电子游戏在近期发布，在该电子游戏中，以 刻钟 为周期规划若干时长为 15 分钟 的游戏对局。
 * 这意味着，在 HH:00、HH:15、HH:30 和 HH:45 ，将会开始一个新的对局，其中 HH 用一个从 00 到 23 的整数表示。
 * 游戏中使用 24 小时制的时钟 ，所以一天中最早的时间是 00:00 ，最晚的时间是 23:59 。
 * 给你两个字符串 startTime 和 finishTime ，
 * 均符合 "HH:MM" 格式，分别表示你 进入 和 退出 游戏的确切时间，请计算在整个游戏会话期间，你完成的 完整对局的对局数 。
 * <p>
 * 例如，如果 startTime = "05:20" 且 finishTime = "05:59" ，这意味着你仅仅完成从 05:30 到 05:45 这一个完整对局。
 * 而你没有完成从 05:15 到 05:30 的完整对局，因为你是在对局开始后进入的游戏；同时，你也没有完成从 05:45 到 06:00 的完整对局，因为你是在对局结束前退出的游戏。
 * 如果 finishTime 早于 startTime ，这表示你玩了个通宵（也就是从 startTime 到午夜，再从午夜到 finishTime）。
 * <p>
 * 假设你是从 startTime 进入游戏，并在 finishTime 退出游戏，请计算并返回你完成的 完整对局的对局数 。
 * @Created by: matreeix
 * @Date: 2021/6/20
 */
public class Solution2 {
    public int numberOfRounds(String startTime, String finishTime) {
        int startMM = Integer.parseInt(startTime.substring(0, 2)) * 60 + Integer.parseInt(startTime.substring(3));
        int finishMM = Integer.parseInt(finishTime.substring(0, 2)) * 60 + Integer.parseInt(finishTime.substring(3));
        if (startMM > finishMM) {//第二天
            finishMM += 1440;
        }
        finishMM = finishMM / 15 * 15;// 第一个小于等于 finishTime 的完整对局的结束时间
        return Math.max(0, finishMM - startMM) / 15;
    }
}
