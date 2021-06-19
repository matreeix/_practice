package _leetcode._CONTEST._weekly._225;

/**
 * @Description: 5661. 替换隐藏数字得到的最晚时间
 * 给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
 * 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
 * 替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
 * @Date: 2021/1/24
 */

public class Solution1 {
    public String maximumTime(String time) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < time.length(); i++) {
            if (time.charAt(i) == '?') {
                if (i == 0) {
                    if (time.charAt(1) != '?' && time.charAt(1) > '3')
                        sb.append(1);
                    else
                        sb.append(2);
                } else if (i == 1) {
                    if (time.charAt(0) == '0' || time.charAt(0) == '1')
                        sb.append(9);
                    else
                        sb.append(3);
                } else if (i == 3) {
                    sb.append(5);
                } else {
                    sb.append(9);
                }
            } else {
                sb.append(time.charAt(i));
            }
        }
        return sb.toString();
    }
}
