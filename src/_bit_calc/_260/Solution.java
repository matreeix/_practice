package _bit_calc._260;

/**
 * @Description: 只出现一次的数字III
 * <p>
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * @Author: 67ng
 * @Date: 2020/6/11
 */
public class Solution {
    /**
     * 思路：
     * 1.首先得到 bitmask = x^y,很容易想到；
     * 2.为了得到x或者y的值，需要找到bitmask的最右边的1-bit即 diff（其实任何一位都可以）
     * 3.由异或的定义，diff 必定来自于 x 或者 y ，且仅来自两者之一
     * 4.通过 (num & diff) != 0 筛选，其他数出现两次可以直接异或掉
     * 5.最后再得到另一位
     *
     * */
    public int[] singleNumber(int[] nums) {
        // difference between two numbers (x and y) which were seen only once
        int bitmask = 0;
        for (int num : nums)//得到x^y
            bitmask ^= num;

        // rightmost 1-bit diff between x and y
        int diff = bitmask & (-bitmask);

        int x = 0;
        // bitmask which will contain only x
        for (int num : nums)
            if ((num & diff) != 0)
                x ^= num;

        return new int[]{x, bitmask ^ x};
    }

    public static void main(String[] args) {

    }
}
