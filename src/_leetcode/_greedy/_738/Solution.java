package _leetcode._greedy._738;

/**
 * @Description: 738. 单调递增的数字
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 * @Created by: matreeix
 * @Date: 2021/6/23
 */
public class Solution {
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        int idx = -1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                idx = i;
                break;
            }
        }

        while (idx >= 1 && s.charAt(idx) == s.charAt(idx - 1)) {
            idx--;
        }

        System.out.println("idx:" + idx);
        StringBuilder sb = new StringBuilder();
        if (idx == -1) return n;
        for (int i = 0; i < s.length(); i++) {
            if (i < idx)
                sb.append(s.charAt(i));
            else if (i == idx)
                sb.append((char) (s.charAt(i) - 1));
            else
                sb.append("9");
        }
        return Integer.parseInt(sb.toString());

    }

    public int monotoneIncreasingDigits2(int n) {
        char[] strN = Integer.toString(n).toCharArray();
        int i = 1;
        while (i < strN.length && strN[i - 1] <= strN[i]) {
            i += 1;
        }
        if (i < strN.length) {
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1] -= 1;
                i -= 1;
            }
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));
    }

}
