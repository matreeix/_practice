package _189;

import java.util.Arrays;

/**
 * @Description: 我有一种思路：把1换到4的位置，把4换到7.....，每次以k的间隔跳跃交换，
 * 总共交换nums.length次，即得到答案，不过我没写出具体代码，不知道能否实现？是否正确？
 * @Author: 67ng
 * @Date: 2019/7/31 21:26
 */
public class Solution2 {
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);//[7,6,5,4,3,2,1]
        reverse(nums, 0, k - 1);//[5,6,7,4,3,2,1]
        reverse(nums, k, nums.length - 1);//[5,6,7,1,2,3,4]
    }

    //翻转数组
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
//        int k = 0;
//        int k = 1;
//        int k = 2;
        int k = 3;
//        int k = 10;

        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
