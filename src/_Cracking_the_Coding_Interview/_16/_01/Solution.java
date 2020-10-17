package _Cracking_the_Coding_Interview._16._01;

/**
 * @Description: 面试题 16.01. 交换数字
 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
 * 注：numbers.length == 2
 * @Author: matreeix
 * @Date: 2020/10/17
 */

public class Solution {
    public int[] swapNumbers1(int[] numbers) {
        numbers[0] = numbers[0] - numbers[1];
        numbers[1] = numbers[1] + numbers[0];
        numbers[0] = numbers[1] - numbers[0];
        //numbers[0] = numbers[0] + numbers[1] - (numbers[1] = numbers[0]);
        return numbers;
    }

    public int[] swapNumbers2(int[] numbers) {
        numbers[0] ^= numbers[1];
        numbers[1] ^= numbers[0];
        numbers[0] ^= numbers[1];
        return numbers;
    }
}
