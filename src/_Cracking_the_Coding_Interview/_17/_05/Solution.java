package _Cracking_the_Coding_Interview._17._05;

import java.util.Arrays;

/**
 * @Description: 面试题 17.05.  字母与数字
 * 给定一个放有字符和数字的数组，找到最长的子数组，且包含的字符和数字的个数相同。
 * 返回该子数组，若存在多个最长子数组，返回左端点最小的。若不存在这样的数组，返回一个空数组。
 * @Author: matreeix
 * @Date: 2020/12/8
 */

public class Solution {
    public String[] findLongestSubarray(String[] array) {
        int len = array.length;
        int[] memo = new int[(len << 1) + 1];
        Arrays.fill(memo, -2);
        memo[len] = -1;
        int res = 0, count = 0, begin = 0, end = 0;
        for (int i = 0; i < len; ++i) {
            boolean is_num = true;
            char c = array[i].toCharArray()[0];
            if (c < '0' || c > '9')
                is_num = false;

            count += is_num ? -1 : 1;
            //未曾见过该前缀和(即memo数组中没有记录)
            if (memo[count + len] <= -2)
                memo[count + len] = i;  //记录该前缀和的下标
                //曾见过该前缀和(即memo数组中已有记录)
            else if (i - memo[count + len] > res) {
                begin = memo[count + len] + 1;
                end = i + 1;
                res = i - memo[count + len];
            }
        }
        return Arrays.copyOfRange(array, begin, end);
    }
}
