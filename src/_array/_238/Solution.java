package _array._238;

/**
 * @Description: 数组除自身外的乘积
 * @Author: 67ng
 * @Date: 2020/2/21
 */
public class Solution {
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];//res[i]为nums[0]~nums[i-1]的乘积
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];//right为nums[i]~nums[length-1]的乘积
        }
        return res;
    }


}
