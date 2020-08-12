package _string._97;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @Description: 交错字符串
 *
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 *
 * @Author: matreeix
 * @Date: 2020/3/12
 */
public class Solution {
    /*public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if (l1 + l2 != l3) return false;
        return dfs(s1, s2, s3, 0, 0, 0);
    }

    private boolean dfs(String s1, String s2, String s3,
                        int p1, int p2, int p3) {
        if (p1 == s1.length()
                && p2 == s2.length()
                && p3 == s3.length())
            return true;
        if (p1 != s1.length() && s1.charAt(p1) == s3.charAt(p3))
            if (dfs(s1, s2, s3, ++p1, p2, ++p3))
                return true;
        if (p2 != s2.length() && s2.charAt(p2) == s3.charAt(p3))
            if (dfs(s1, s2, s3, p1, ++p2, ++p3))
                return true;
        return false;
    }*/

    //BFS,1ms
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(),
                len2 = s2.length(),
                len3 = s3.length();
        if (len1 + len2 != len3) return false;
        Deque<Integer> queue = new LinkedList<>();
        int matched = 0;
        queue.offer(0);
        Set<Integer> set = new HashSet<>();
        while (queue.size() > 0 && matched < len3) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int p1 = queue.peek() / len3,
                        p2 = queue.peek() % len3;
                queue.poll();
                if (p1 < len1 && s1.charAt(p1) == s3.charAt(matched)) {
                    int key = (p1 + 1) * len3 + p2;
                    if (!set.contains(key)) {
                        set.add(key);
                        queue.offer(key);
                    }
                }
                if (p2 < len2 && s2.charAt(p2) == s3.charAt(matched)) {
                    int key = p1 * len3 + (p2 + 1);
                    if (!set.contains(key)) {
                        set.add(key);
                        queue.offer(key);
                    }
                }
            }
            matched++;
        }
        return queue.size() > 0 && matched == len3;
    }

    //DP,3ms
    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length())
            return false;

        boolean[][] table = new boolean[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < s1.length() + 1; i++)
            for (int j = 0; j < s2.length() + 1; j++) {
                if (i == 0 && j == 0)
                    table[i][j] = true;
                else if (i == 0)
                    table[i][j] = (table[i][j - 1]
                            && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                else if (j == 0)
                    table[i][j] = (table[i - 1][j]
                            && s1.charAt(i - 1) == s3.charAt(i + j - 1));
                else
                    table[i][j] = (table[i - 1][j]
                            && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                            || (table[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }

        return table[s1.length()][s2.length()];
    }

    //DFS,0ms
    public boolean isInterleave3(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        HashSet<Integer> cache = new HashSet<Integer>();
        return isInterleave0(s1, s2, s3, 0, 0, cache);
    }

    private boolean isInterleave0(String s1, String s2, String s3,
                                  int p1, int p2, HashSet<Integer> cache) {
        if (p1 + p2 == s3.length())
            return true;
        if (cache.contains(p1 * s3.length() + p2))
            return false;
        // no need to store actual result.
        // if we found the path, we have already terminated.
        cache.add(p1 * s3.length() + p2);
        boolean match1 = p1 < s1.length() && s3.charAt(p1 + p2) == s1.charAt(p1);
        boolean match2 = p2 < s2.length() && s3.charAt(p1 + p2) == s2.charAt(p2);
        if (match1 && match2)
            return isInterleave0(s1, s2, s3, p1 + 1, p2, cache) ||
                    isInterleave0(s1, s2, s3, p1, p2 + 1, cache);
        else if (match1)
            return isInterleave0(s1, s2, s3, p1 + 1, p2, cache);
        else if (match2)
            return isInterleave0(s1, s2, s3, p1, p2 + 1, cache);
        else
            return false;
    }


    public static void main(String[] args) {
//        System.out.println((new Solution()).isInterleave("aabbcc", "ddee", "aabbccddee"));
//        System.out.println((new Solution()).isInterleave("aabbcc", "ddee", "aaddee"));
        System.out.println(
                (new Solution())
                        .isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
