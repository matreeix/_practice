package _leetcode._math._906;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 906. 超级回文数
 * 如果一个正整数自身是回文数，而且它也是一个回文数的平方，那么我们称这个数为超级回文数。
 * 现在，给定两个正整数 L 和 R （以字符串形式表示），返回包含在范围 [L, R] 中的超级回文数的数目。
 * @Date: 2021/3/19
 */

public class Solution {

    //暴力解法，TLE
    public int superpalindromesInRange(String left, String right) {
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);
        long min = getSquare(l);
        List<Long> cnt = new ArrayList<>();
        for (; min * min <= r; min++)//直接加一数据量太大，会TLE
            if (isPalindrome(min))
                cnt.add(min * min);

        int res = 0;
        for (long num : cnt)
            if (isPalindrome(num)) {
                System.out.println(num);
                res++;
            }
        return res;
    }

    private long getSquare(long min) {
        long a = (long) Math.sqrt(min);
        return a * a == min ? a : a + 1;
    }

    private boolean isPalindrome(long num) {
        long tmp = num;
        long reverse = 0;
        while (tmp > 0) {//翻转数字
            reverse = reverse * 10 + tmp % 10;
            tmp = tmp / 10;
        }
        return reverse == num;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.superpalindromesInRange("4", "1000"));
    }

}
