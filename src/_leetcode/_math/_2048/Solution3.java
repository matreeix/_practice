package _leetcode._math._2048;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * @Description: 回溯法, 数据范围扩大到[1, 10^18]
 * @Date: 2021/10/28
 */

public class Solution3 {
    private final String[] s = {"1", "22", "333", "4444", "55555", "666666", "7777777", "88888888", "999999999"};
    private final long[] max = {1, 22, 333, 4444, 55555, 666666, 7777777, 88888888, 999999999, 9999999991L, 99999999922L,
            999999999333L, 9999999994444L, 99999999955555L, 999999999666666L, 9999999997777777L, 99999999988888888L, 999999999888888881L};
    private final long[] min = {1, 22, 122, 1333, 14444, 122333, 1224444, 12255555, 122666666, 1223334444L, 12233355555L,
            122333666666L, 1223337777777L, 12233388888888L, 122333444455555L, 1223334444666666L, 12233344447777777L, 122333444488888888L};

    public long nextBeautifulNumber(long n) {
        List<Long> list = new ArrayList<>();
        int len = Long.toString(n).length();
        // 特殊处理边界
        if (n < min[len - 1]) return min[len - 1];
        if (n >= max[len - 1]) return min[len];
        List<String> comb = getCombination(len);
        for (String c : comb) {
            List<String> permute = getPermute(c);
            for (String p : permute) {
                list.add(Long.parseLong(p));
            }
        }
        long res = Long.MAX_VALUE;
        for (long l : list)
            if (l > n)
                res = Math.min(res, l);
        return res;
    }

    // 得到s的所有不重复全排列
    private List<String> getPermute(String s) {
        List<String> list = new ArrayList<>();
        backtrackPermute(list, new StringBuilder(), s, new boolean[s.length()]);
        return list;
    }

    // 全排列回溯
    private void backtrackPermute(List<String> list, StringBuilder sb, String s, boolean[] used) {
        if (sb.length() == s.length()) {
            list.add(sb.toString());
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (used[i]) continue;//已经使用过的元素
                if (i > 0 && s.charAt(i) == s.charAt(i - 1) && !used[i - 1]) continue;//相同元素未使用过，但在同一层也跳过
                used[i] = true;
                sb.append(s.charAt(i));
                backtrackPermute(list, sb, s, used);
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    // 得到长度的所有基础组合
    private List<String> res;

    public List<String> getCombination(int target) {
        res = new ArrayList<>();
        backtrackLen(new StringBuilder(), 0, 0, target);
        System.out.println(res.size());
        return res;
    }

    // 组合回溯
    private void backtrackLen(StringBuilder tmp, int cur, int index, int target) {
        if (cur > target) return;
        if (cur == target) {
            res.add(tmp.toString());
            return;
        }
        for (int i = index; i < s.length; i++) {
            if (i > index && s[i].length() == s[i - 1].length()) continue;
            tmp.append(s[i]);
            backtrackLen(tmp, cur + s[i].length(), i + 1, target);
            tmp.delete(tmp.length() - s[i].length(), tmp.length());
        }
    }

    // 精简回溯解法
    private int[] cnt = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public long dfs(long n, long val, int sz) {
        if (sz == 0) {
            for (int i = 1; i <= 9; ++i)
                if (cnt[i] != i && cnt[i] != 0)
                    return 0;
            return val > n ? val : 0;
        }
        long res = 0;
        for (int i = 1; res == 0 && i <= 9; ++i)
            if (cnt[i] > 0 && cnt[i] <= sz) {
                --cnt[i];
                res = dfs(n, val * 10 + i, sz - 1);
                ++cnt[i];
            }
        return res;
    }

    public long nextBeautifulNumber2(long n) {
        int sz = Long.toString(n).length();
        return dfs(n, 0, sz) != 0 ? dfs(n, 0, sz) : dfs(0, 0, sz + 1);
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
//        System.out.println(s.nextBeautifulNumber(36_132_341_234_223L));// len = 14
//        System.out.println(s.getCombination(7));
//        System.out.println(s.getCombination(8));
//        System.out.println(s.getCombination(9));
//        System.out.println(s.getCombination(10));
//        System.out.println(s.getCombination(11));
//        System.out.println(s.getCombination(12));
//        System.out.println(s.getCombination(13));
//        System.out.println(s.getCombination(14));
//        System.out.println(s.getCombination(15));
//        System.out.println(s.getCombination(16));
//        System.out.println(s.getCombination(17));

        System.out.println(s.getCombination(5));
        System.out.println(s.getCombination(6));
        System.out.println(s.getCombination(7));
        System.out.println(s.getCombination(8));
        System.out.println(s.getCombination(9));
    }


}
