package _leetcode._CONTEST._weekly._266;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 5918. 统计字符串中的元音子字符串
 * 子字符串 是字符串中的一个连续（非空）的字符序列。
 * 元音子字符串 是 仅 由元音（'a'、'e'、'i'、'o' 和 'u'）组成的一个子字符串，且必须包含 全部五种 元音。
 * 给你一个字符串 word ，统计并返回 word 中 元音子字符串的数目 。
 * @Date: 2021/11/7
 */

public class Solution1 {
    public int countVowelSubstrings(String word) {
        int res = 0;
        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 5; j <= word.length(); j++) {
                String tmp = word.substring(i, j);
                if (check(tmp)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean check(String s) {
        boolean a = false;
        boolean e = false;
        boolean i = false;
        boolean o = false;
        boolean u = false;
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case 'a':
                    a = true;
                    break;
                case 'e':
                    e = true;
                    break;
                case 'i':
                    i = true;
                    break;
                case 'o':
                    o = true;
                    break;
                case 'u':
                    u = true;
                    break;
                default:
                    return false;
            }
        }
        return a && e && i && o && u;
    }

    public int countVowelSubstrings2(String word) {
        int j = 0;// j标记“全元音”子串的开始
        int k = 0;// [k-1, i]是包含所有5个元音的最小窗口
        int vow = 0;// 统计是否5个元音都有
        int cnt = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 0);
        map.put('i', 0);
        map.put('o', 0);
        map.put('u', 0);
        for (int i = 0; i < word.length(); ++i) {
            if (map.get(word.charAt(i)) != null) {// 元音
                map.put(word.charAt(i), map.get(word.charAt(i)) + 1);
                if (map.get(word.charAt(i)) == 1) {// 代表某个元音第一次出现
                    ++vow;
                }
                while (vow == 5) {// 保证所有元音都存在，k从j开始右移
                    map.put(word.charAt(k), map.get(word.charAt(k)) - 1);
                    if (map.get(word.charAt(k)) == 0) {
                        --vow;
                    }
                    k++;
                }
                cnt += (k - j);
            } else {// 辅音
                map.forEach((k1, v) -> {
                    map.put(k1, 0);
                });
                vow = 0;
                j = k = i + 1;
            }
        }
        return cnt;
    }
}
