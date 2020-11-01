package _Cracking_the_Coding_Interview._16._07;

/**
 * @Description: 面试题 16.07. 最大数值
 * 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
 * @Author: matreeix
 * @Date: 2020/10/30
 */

public class Solution {
    public int maximum(int a, int b) {
        long k = (((long) a - (long) b) >> 63) & 1;
        return (int) (b * k + a * (k ^ 1));//a-b>0,则k=0
    }
}
