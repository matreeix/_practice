package _leetcode._CONTEST._weekly._244;

/**
 * @Description: 5778. 使二进制字符串字符交替的最少反转次数
 * 给你一个二进制字符串 s 。你可以按任意顺序执行以下两种操作任意次：
 * 类型 1 ：删除 字符串 s 的第一个字符并将它 添加 到字符串结尾。
 * 类型 2 ：选择 字符串 s 中任意一个字符并将该字符 反转 ，也就是如果值为 '0' ，则反转得到 '1' ，反之亦然。
 * 请你返回使 s 变成 交替 字符串的前提下， 类型 2 的 最少 操作次数 。
 * 我们称一个字符串是 交替 的，需要满足任意相邻字符都不同。
 * <p>
 * 比方说，字符串 "010" 和 "1010" 都是交替的，但是字符串 "0100" 不是。
 * @Created by: matreeix
 * @Date: 2021/6/6
 */
public class Solution3 {

    /**
     * 最终答案要么是101010或者是010101，任取一种模式去匹配统计不匹配个数，最后取两者最小值就是最终答案
     * */
    public int minFlips(String s) {
        int len = s.length();
        char[] target = "01".toCharArray();//01模式去匹配
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            cnt += (s.charAt(i) != target[i % 2]) ? 1 : 0;//统计需要改变的字符数
        }

        s += s;//前后拼接，方便滑动窗口
        int ans = Math.min(cnt, len - cnt);
        for (int i = 0; i < len; i++) {
            cnt -= (s.charAt(i) != target[i % 2]) ? 1 : 0;//弹出窗口
            cnt += (s.charAt(i + len) != target[(i + len) % 2]) ? 1 : 0;//加入窗口
            ans = Math.min(ans, Math.min(cnt, len - cnt));
        }
        return ans;
    }
}
