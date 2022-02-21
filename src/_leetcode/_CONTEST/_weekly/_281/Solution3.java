package _leetcode._CONTEST._weekly._281;

/**
 * @Description: 6014. 构造限制重复的字符串
 * 给你一个字符串 s 和一个整数 repeatLimit ，用 s 中的字符构造一个新字符串 repeatLimitedString ，
 * 使任何字母 连续 出现的次数都不超过 repeatLimit 次。你不必使用 s 中的全部字符。
 * 返回 字典序最大的 repeatLimitedString 。
 * 如果在字符串 a 和 b 不同的第一个位置，字符串 a 中的字母在字母表中出现时间比字符串 b 对应的字母晚，
 * 则认为字符串 a 比字符串 b 字典序更大 。如果字符串中前 min(a.length, b.length) 个字符都相同，那么较长的字符串字典序更大。
 * 提示：
 * 1 <= repeatLimit <= s.length <= 10^5
 * s 由小写英文字母组成
 * @Date: 2022/2/20
 */

public class Solution3 {
    public static String repeatLimitedString(String s, int repeatLimit) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        StringBuilder res = new StringBuilder();
        int tmp = 0;
        int j = 0;
        for (int i = 25; i >= 0; ) {
            if (cnt[i] > 0) {
                if (tmp < repeatLimit) {
                    res.append((char) ('a' + i));
                    System.out.println("i:" + i);
                    cnt[i]--;
                    tmp++;
                } else {
                    j = i - 1;
                    if (j > -1) {
                        if (cnt[j] == 0) {
                            while (j > -1) {
                                if (cnt[j] > 0) {
                                    res.append((char) ('a' + j));
                                    System.out.println("j:" + j);
                                    cnt[j]--;
                                    break;
                                }
                                j--;
                            }
                        } else {
                            res.append((char) ('a' + j));
                            System.out.println("j:" + j);
                            cnt[j]--;
                        }
                    }

                    tmp = cnt[i] > 0 ? 0 : 1;
                    if (j < 0) return res.toString();
                }
            } else {
                i--;
                tmp = 0;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s1 = "cczazcc";
        String s2 = "aababab";
        int repeatLimit1 = 3;
        int repeatLimit2 = 2;
        System.out.println(repeatLimitedString(s1, repeatLimit1));//zzcccac
        System.out.println(repeatLimitedString(s2, repeatLimit2));//bbabaa
    }
}
