package _leetcode._bit_calc._137;

/**
 * @Description: 只出现一次的数字II
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * @Author: matreeix
 * @Date: 2020/6/11
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int seenOnce = 0, seenTwice = 0;

        for (int num : nums) {
            // first appearence:
            // add num to seen_once
            // don't add to seen_twice because of presence in seen_once

            // second appearance:
            // remove num from seen_once
            // add num to seen_twice

            // third appearance:
            // don't add to seen_once because of presence in seen_twice
            // remove num from seen_twice

            //~0 & k = k;
            //~k & k = 0;
            //k & 0 = 0;
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }
        return seenOnce;
    }

    public static void main(String[] args) {
        System.out.println(~0 & 0);
        System.out.println(~0);
    }

}
