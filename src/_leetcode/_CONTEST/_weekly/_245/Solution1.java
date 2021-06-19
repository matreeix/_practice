package _leetcode._CONTEST._weekly._245;

/**
 * @Description: 5784. 重新分配字符使所有字符串都相等
 * 给你一个字符串数组 words（下标 从 0 开始 计数）。
 * 在一步操作中，需先选出两个 不同 下标 i 和 j，其中 words[i] 是一个非空字符串，接着将 words[i] 中的 任一 字符移动到 words[j] 中的 任一 位置上。
 * 如果执行任意步操作可以使 words 中的每个字符串都相等，返回 true ；否则，返回 false 。
 * @Created by: matreeix
 * @Date: 2021/6/13
 */
public class Solution1 {

    public boolean makeEqual(String[] words) {
        int[] cnt = new int[26];
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                cnt[ch - 'a']++;
            }
        }
        int n = words.length;
        for (int i : cnt)
            if (i % n != 0)
                return false;
        return true;

    }
}
