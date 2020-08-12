package _Cracking_the_Coding_Interview._01._01;

import java.util.Arrays;

/**
 * @Description: 判定字符是否唯一
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * @Author: matreeix
 * @Date: 2020/6/29
 */

public class Solution {
    //排序法，简单
    public boolean isUnique(String astr) {
        char[] chars = astr.toCharArray();
        Arrays.sort(chars);
        for (int i = 1; i < chars.length; i++)
            if (chars[i] == chars[i - 1])
                return false;

        return true;
    }

    //位运算,思路如下:
    //由于ASCII码字符个数为128个，而且题目说了如果你不使用额外的数据结构，会很加分。
    // 因此可以使用两个64位的long变量来存储是否出现某个字符，二进制位1表示出现过， 0表示未出现过。
    public boolean isUnique2(String astr) {
        long low64 = 0;
        long high64 = 0;

        for (char c : astr.toCharArray()) {
            if (c >= 64) {//ASCII码大于等于64
                long bitIndex = 1L << c - 64;
                if ((high64 & bitIndex) != 0)
                    return false;
                high64 |= bitIndex;
            } else {//ASCII码小于64
                long bitIndex = 1L << c;
                if ((low64 & bitIndex) != 0)
                    return false;
                low64 |= bitIndex;
            }
        }
        return true;
    }

}
