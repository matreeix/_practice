package _268;

/**
 * @Description: 求含0, 1, 2, 3....n的数组(length =n)中缺失的数
 * @Author: 67ng
 * @Date: 2019/7/28 22:28
 */
//思路：对数组进行排序后，则nums[i] = i或者nums[i]= i-1,想法在O(n)时间复杂度内进行这样的操作
public class Solution {
    //a^b^b =a
    public static int missingNumber(int[] nums) {
        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }

    //1,2,3...n的总和减去nums的元素和就是缺的元素
    public static int missingNumber2(int[] nums) {
        int sum = nums.length;
        for (int i = 0; i < nums.length; i++)
            sum += i - nums[i];
        return sum;
    }


    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber(nums));
    }
}
