package _CONTEST._weekly._245;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 5786. 可移除字符的最大数目
 * 给你两个字符串 s 和 p ，其中 p 是 s 的一个 子序列 。同时，给你一个元素 互不相同 且下标 从 0 开始 计数的整数数组 removable ，该数组是 s 中下标的一个子集（s 的下标也 从 0 开始 计数）。
 * 请你找出一个整数 k（0 <= k <= removable.length），选出 removable 中的 前 k 个下标，然后从 s 中移除这些下标对应的 k 个字符。整数 k 需满足：在执行完上述步骤后， p 仍然是 s 的一个 子序列 。更正式的解释是，对于每个 0 <= i < k ，先标记出位于 s[removable[i]] 的字符，接着移除所有标记过的字符，然后检查 p 是否仍然是 s 的一个子序列。
 * 返回你可以找出的 最大 k ，满足在移除字符后 p 仍然是 s 的一个子序列。
 * 字符串的一个 子序列 是一个由原字符串生成的新字符串，生成过程中可能会移除原字符串中的一些字符（也可能不移除）但不改变剩余字符之间的相对顺序。
 * @Created by: matreeix
 * @Date: 2021/6/13
 */
public class Solution {

    public int maximumRemovals(String s, String p, int[] removable) {
        int l = 0, r = removable.length;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (check(s, p, removable, mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    private boolean check(String s, String p, int[] removable, int index) {
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();
        int i = 0, j = 0;
        Set<Integer> set = new HashSet<>();
        for (int k = 0; k < index; k++) {
            set.add(removable[k]);
        }
        while (i < cs.length && j < cp.length) {
            if (!set.contains(i) && cs[i] == cp[j]) {
                j++;
            }
            i++;
        }
        return j == cp.length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maximumRemovals("abcacb", "ab", new int[]{3, 1, 0}));
        System.out.println(s.maximumRemovals("abcbddddd", "abcd", new int[]{3, 2, 1, 4, 5, 6}));
        System.out.println(s.maximumRemovals("abcab", "abc", new int[]{0, 1, 2, 3, 4}));
    }
}
