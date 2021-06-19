package _leetcode._string._187;

import java.util.*;

/**
 * @Description: 187. 重复的DNA序列
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 * @Date: 2021/4/8
 */

public class Solution {
    //O(n ^ 2),TLE
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10) return new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i + 10 < s.length(); i++) {
            String tmp = s.substring(i, i + 10);
            if (!set.contains(tmp) && s.substring(i + 1).contains(tmp)) {
                set.add(tmp);
            }
        }
        return new ArrayList<>(set);
    }

    //位操作：使用掩码实现常数时间窗口切片
    public List<String> findRepeatedDnaSequences2(String s) {
        int L = 10, n = s.length();
        if (n <= L) return new ArrayList();

        // rolling hash parameters: base a
        int a = 4, aL = (int) Math.pow(a, L);

        // convert string to array of integers
        Map<Character, Integer> toInt = new
                HashMap() {{
                    put('A', 0);
                    put('C', 1);
                    put('G', 2);
                    put('T', 3);
                }};
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) nums[i] = toInt.get(s.charAt(i));

        int bitmask = 0;
        Set<Integer> seen = new HashSet();
        Set<String> output = new HashSet();
        // iterate over all sequences of length L
        for (int start = 0; start < n - L + 1; ++start) {
            // compute bitmask of the current sequence in O(1) time
            if (start != 0) {
                // left shift to free the last 2 bit
                bitmask <<= 2;
                // add a new 2-bits number in the last two bits
                bitmask |= nums[start + L - 1];
                // unset first two bits: 2L-bit and (2L + 1)-bit
                bitmask &= ~(3 << 2 * L);
            }
            // compute hash of the first sequence in O(L) time
            else {
                for (int i = 0; i < L; ++i) {
                    bitmask <<= 2;
                    bitmask |= nums[i];
                }
            }
            // update output and hashset of seen sequences
            if (seen.contains(bitmask)) output.add(s.substring(start, start + L));
            seen.add(bitmask);
        }
        return new ArrayList<String>(output);
    }

}
