package _Cracking_the_Coding_Interview._01._05;

/**
 * @Description: 一次编辑
 * <p>
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * @Author: caffebaby
 * @Date: 2020/6/30
 */

public class Solution {
    //双指针扫描法
    public boolean oneEditAway(String first, String second) {
        if (first.equals(second))
            return true;
        int len1 = first.length();
        int len2 = second.length();
        if (Math.abs(len1 - len2) > 1)
            return false;
        int i = 0, j = len1 - 1, k = len2 - 1;
        while (i < len1 && i < len2 && first.charAt(i) == second.charAt(i)) { // i从左至右扫描
            ++i;
        }
        while (j >= 0 && k >= 0 && first.charAt(j) == second.charAt(k)) { // j、k从右至左扫描
            --j;
            --k;
        }
        return j - i < 1 && k - i < 1;
    }
}
