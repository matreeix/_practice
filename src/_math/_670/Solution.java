package _math._670;

import java.util.Arrays;

/**
 * @Description: 670. 最大交换
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * @Created by: matreeix
 * @Date: 2021/6/10
 */
public class Solution {
    public static int maximumSwap(int num) {
        char[] str = String.valueOf(num).toCharArray();
        int n = str.length;
        char[] sort = Arrays.copyOf(str, n);
        Arrays.sort(sort);
        for (int i = 0; i < n; i++) {
            if (str[i] != sort[n - 1 - i]) {
                char tmp = str[i];
                str[i] = sort[n - 1 - i];
                for (int j = n - 1; j > i; j--) {
                    if (str[j] == str[i]) {
                        str[j] = tmp;
                        return Integer.parseInt(new String(str));
                    }
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(maximumSwap(1234321));
        System.out.println(maximumSwap(0));
        System.out.println(maximumSwap(9973));
        System.out.println(maximumSwap(1234));
        System.out.println(maximumSwap(98368));
    }
}
