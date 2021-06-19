package _leetcode._CONTEST._biweekly._39;

/**
 * @Description: 5551. 使字符串平衡的最少删除次数
 * 给你一个字符串 s ，它仅包含字符 'a' 和 'b'​​​​ 。
 * <p>
 * 你可以删除 s 中任意数目的字符，使得 s 平衡 。我们称 s 平衡的 当不存在下标对 (i,j) 满足 i < j 且 s[i] = 'b' 同时 s[j]= 'a' 。
 * <p>
 * 请你返回使 s 平衡 的 最少 删除次数。
 * @Author: matreeix
 * @Date: 2020/11/14
 */

public class Solution2 {
    public int minimumDeletions(String s) {
        int cnt = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                cnt++;
            } else {
                if (cnt > 0) {
                    res++;
                    cnt--;
                }
            }

        }
        return res;
    }
}
