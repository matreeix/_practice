package _leetcode._string._1805;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 1805. 字符串中不同整数的数目
 * 给你一个字符串 word ，该字符串由数字和小写英文字母组成。
 * 请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123  34 8  34" 。注意，剩下的这些整数为（相邻彼此至少有一个空格隔开）："123"、"34"、"8" 和 "34" 。
 * 返回对 word 完成替换后形成的 不同 整数的数目。
 * 只有当两个整数的 不含前导零 的十进制表示不同， 才认为这两个整数也不同。
 * @Date: 2021/3/30
 */

public class Solution {

    public static int numDifferentIntegers(String word) {
        Set<BigInteger> set = new HashSet<>();
        int start = -1;
        for (int i = 0; i < word.length(); i++) {
            if ('0' <= word.charAt(i) && word.charAt(i) <= '9') {
                if (start == -1) start = i;
                if (i == word.length() - 1 && start != -1)
                    set.add(new BigInteger(word.substring(start, i + 1)));
            } else {
                if (start != -1) {
                    set.add(new BigInteger(word.substring(start, i)));
                    start = -1;
                }
            }
        }

//        System.out.println(set);
        return set.size();
    }

    //该解法是错误的，整数可能越界
    public static int numDifferentIntegers2(String word) {
        char[] a = word.toCharArray();
        ArrayList<Integer> ab = new ArrayList<>();
        int x = 0;
        for (int i = 0; i < a.length; ) {
            if (Character.isDigit(a[i])) {
                for (; i < a.length && Character.isDigit(a[i]); ) {
                    x = x * 10 + a[i] - 48;
                    i++;
                }
                if (!ab.contains(x)) {
                    ab.add(x);
                }
                x = 0;
            } else {
                i++;
            }
        }
        return ab.size();
    }

    public int numDifferentIntegers3(String w) {
        Set<String> s = new HashSet<String>(Arrays.asList(""));
        int i = 0;
        for (int j = 0; j < w.length(); ++j) {
            if (Character.isDigit(w.charAt(j)))
                i += i < j && w.charAt(i) == '0' ? 1 : 0;
            else {
                s.add(w.substring(i, j));
                i = j + 1;
            }
        }
        s.add(w.substring(i));
        return s.size() - 1;
    }

    //正则表达式
    public int numDifferentIntegers4(String word) {
        String[] arr = word.split("\\D");
        Set<String> s = new HashSet<>();
        for (String str : arr) {
            str = str.trim();
            if (!str.equals("")) {
                str = str.replaceAll("^0*", "");
                s.add(str);
            }
        }
        return s.size();
    }

    public static void main(String[] args) {
        System.out.println(numDifferentIntegers2("leet2147483647code6442450943"));
    }


}
