package _66;

import java.util.Arrays;

/**
 * @Description: 将数组表示的整数加一的值以数组形式返回
 * @Author: 67ng
 * @Date: 2019/7/30 10:38
 */
public class Solution {
    public static int[] plusOne(int[] digits) {
        int k = digits.length - 1;

        while (k > -1) {
            if (digits[k] == 9) {
                digits[k] = 0;
                k--;
            } else {
                digits[k] = digits[k] + 1;
                return digits;
            }
        }

        int[] new_digits = new int[digits.length + 1];
        new_digits[0] = 1;
        return new_digits;


    }



    public static void main(String[] args) {
        int[] digits1 = {4, 3, 2, 1};
        int[] digits2 = {4, 3, 2, 9};
        int[] digits3 = {8, 9, 9, 9};
        int[] digits4 = {9, 9, 9, 9};
        int[] digits5 = {0, 0, 0, 0};
        System.out.println(Arrays.toString(plusOne(digits1)));
        System.out.println(Arrays.toString(plusOne(digits2)));
        System.out.println(Arrays.toString(plusOne(digits3)));
        System.out.println(Arrays.toString(plusOne(digits4)));
        System.out.println(Arrays.toString(plusOne(digits5)));

    }
}
