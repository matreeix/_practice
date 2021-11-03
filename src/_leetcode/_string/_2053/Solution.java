package _leetcode._string._2053;


import java.util.*;

/**
 * @Description: 2053. 数组中第 K 个独一无二的字符串
 * 独一无二的字符串 指的是在一个数组中只出现过 一次 的字符串。
 * 给你一个字符串数组 arr 和一个整数 k ，请你返回 arr 中第 k 个 独一无二的字符串 。如果 少于 k 个独一无二的字符串，那么返回 空字符串 "" 。
 * 注意，按照字符串在原数组中的 顺序 找到第 k 个独一无二字符串。
 * 提示：1 <= k <= arr.length <= 1000
 * 1 <= arr[i].length <= 5
 * arr[i] 只包含小写英文字母。
 * @Date: 2021/11/2
 */

public class Solution {
    public static String kthDistinct(String[] arr, int k) {
        Set<String> setAll = new HashSet<>();
        Set<String> setOne = new LinkedHashSet<>();
        for (String s : arr) {
            setOne.remove(s);
            if (!setAll.contains(s)) {
                setOne.add(s);
                setAll.add(s);
            }
        }
        int idx = 0;
        for (String s : setOne) {
            if (++idx == k) {
                return s;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String[] ss = {"d", "b", "c", "b", "c", "a"};
        System.out.println(kthDistinct(ss, 2));
    }
}
