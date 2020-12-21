package _CONTEST._weekly._220;

/**
 * @Description: 1694. 重新格式化电话号码
 * 给你一个字符串形式的电话号码 number 。number 由数字、空格 ' '、和破折号 '-' 组成。
 * <p>
 * 请你按下述方式重新格式化电话号码。
 * <p>
 * 首先，删除 所有的空格和破折号。
 * 其次，将数字从左到右 每 3 个一组 分块，直到 剩下 4 个或更少数字。剩下的数字将按下述规定再分块：
 * 2 个数字：单个含 2 个数字的块。
 * 3 个数字：单个含 3 个数字的块。
 * 4 个数字：两个分别含 2 个数字的块。
 * 最后用破折号将这些块连接起来。注意，重新格式化过程中 不应该 生成仅含 1 个数字的块，并且 最多 生成两个含 2 个数字的块。
 * <p>
 * 返回格式化后的电话号码。
 * @Author: matreeix
 * @Date: 2020/12/21
 */

public class Solution1 {
    public static String reformatNumber(String number) {
        String s = number.replace("-", "").replace(" ", "");
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (i % 3 == 0) {
                sb.append("-");
                sb.append(s.charAt(i));
            } else {
                sb.append(s.charAt(i));
            }
        }

        if (s.length() % 3 == 1) {
            char tmp = sb.charAt(sb.length() - 3);
            sb.setCharAt(sb.length() - 3, '-');
            sb.setCharAt(sb.length() - 2, tmp);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "123 4-567";
        System.out.println(reformatNumber(s));
    }
}
