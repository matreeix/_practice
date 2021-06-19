package _leetcode._hashtable._205;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 205. 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * @Date: 2021/3/22
 */

public class Solution {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map1.containsKey(s.charAt(i)))
                map1.put(s.charAt(i), t.charAt(i));
            else if (map1.get(s.charAt(i)) != t.charAt(i))
                return false;

            if (!map2.containsKey(t.charAt(i)))
                map2.put(t.charAt(i), s.charAt(i));
            else if (map2.get(t.charAt(i)) != s.charAt(i))
                return false;
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int[] pres = new int[256];
        int[] pret = new int[256];
        for (int i = 0; i < ss.length; i++) {
            if (pres[ss[i]] != pret[tt[i]])
                return false;
            pres[ss[i]] = i + 1;
            pret[tt[i]] = i + 1;
        }
        return true;
    }

}
