package _CONTEST._biweekly._31;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 1525. 字符串的好分割数目
 * 给你一个字符串 s ，一个分割被称为 「好分割」 当它满足：将 s 分割成 2 个字符串 p 和 q ，它们连接起来等于 s 且 p 和 q 中不同字符的数目相同。
 * 请你返回 s 中好分割的数目。
 * @Author: Pythagodzilla
 * @Date: 2020/7/27
 */

public class Solution3 {
    //双指针
    public static int numSplits(String s) {
        int l = 0, r = s.length() - 1;
        Set<Character> L = new HashSet<>();
        Set<Character> R = new HashSet<>();
        int start = -1, end = -1;
        while (l < r) {
            while (l < s.length() - 1 && L.contains(s.charAt(l))) l++;
            L.add(s.charAt(l));
            while (r > 0 && R.contains(s.charAt(r))) r--;
            R.add(s.charAt(r));
            if (l > r) {//l和r的值不能超过上一次的[start,end]区间
                start = Math.max(start, r);
                end = Math.min(end, l);
                break;
            }
            start = l;
            end = r;
        }
        return end - start;
    }

    public static void main(String[] args) {
        System.out.println(numSplits("aacaba"));//2
        System.out.println(numSplits("abcd"));//1
        System.out.println(numSplits("aaaaa"));//4
        System.out.println(numSplits("acbadbaada"));//2
    }
}




