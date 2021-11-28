package _leetcode._CONTEST._biweekly._66;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description: 5922. 统计出现过一次的公共字符串
 * 给你两个字符串数组 words1 和 words2 ，请你返回在两个字符串数组中 都恰好出现一次 的字符串的数目。
 * 提示：
 * 1 <= words1.length, words2.length <= 1000
 * 1 <= words1[i].length, words2[j].length <= 30
 * words1[i] 和 words2[j] 都只包含小写英文字母。
 * @Date: 2021/11/28
 */

public class Solution1 {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (String word : words1) map1.put(word, map1.getOrDefault(word, 0) + 1);
        for (String word : words2) map2.put(word, map2.getOrDefault(word, 0) + 1);

        int res = 0;
        for (String word : map1.keySet()) {
            if (map1.get(word) == 1 && map2.containsKey(word) && map2.get(word) == 1) {
                res++;
            }
        }
        return res;
    }
}
