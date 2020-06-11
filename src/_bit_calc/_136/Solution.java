package _bit_calc._136;

/**
 * @Description: 只出现一次的数字
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * @Author: 67ng
 * @Date: 2020/6/11
 */
public class Solution {
    //a^b^b=a
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println((new Solution()).singleNumber(nums));
    }
}
