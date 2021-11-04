package _leetcode._search._2055;

/**
 * @Description: 2055. 蜡烛之间的盘子
 * 给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0 开始的字符串 s ，它只包含字符 '*' 和 '|' ，其中 '*' 表示一个 盘子 ，'|' 表示一支 蜡烛 。
 * 同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] 表示 子字符串 s[lefti...righti] （包含左右端点的字符）。
 * 对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 。如果一个盘子在 子字符串中 左边和右边 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。
 * 比方说，s = "||**||**|*" ，查询 [3, 8] ，表示的是子字符串 "*||**|" 。子字符串中在两支蜡烛之间的盘子数目为 2 ，子字符串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。
 * 请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。
 * @Date: 2021/11/3
 */

public class Solution {

    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] chars = s.toCharArray();
        int[] pre = new int[s.length()];
        pre[0] = chars[0] == '*' ? 1 : 0;
        for (int i = 1; i < pre.length; i++) {
            pre[i] = chars[i] == '*' ? pre[i - 1] + 1 : pre[i - 1];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            int[] tmp = binarySearch(queries[i][0], queries[i][1], chars, pre);
            if (tmp[0] < tmp[1]) {
                res[i] = pre[tmp[1]] - pre[tmp[0]];
            }
        }
        return res;
    }

    private int[] binarySearch(int L, int R, char[] chs, int[] pre) {
        int l = L, r = R;
        while (l < r && chs[l] != '|') {
            int mid = (l + r) / 2;
            if (pre[mid] - pre[l] == mid - l) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int a = l;
        l = L;
        r = R;
        while (l < r && chs[r] != '|') {
            int mid = (l + r) / 2;
            if (pre[r] - pre[mid] == r - mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        int b = r;
        return new int[]{a, b};
    }
}
