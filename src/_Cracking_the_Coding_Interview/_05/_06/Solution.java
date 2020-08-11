package _Cracking_the_Coding_Interview._05._06;

/**
 * @Description: 面试题 05.06. 整数转换
 * 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
 * @Author: caffebaby
 * @Date: 2020/7/4
 */

public class Solution {
    public int convertInteger(int A, int B) {
        return Integer.bitCount(A ^ B);
    }
}
