package _189;

import java.util.Arrays;

/**
 * @Description:
 * @Author: 67ng
 * @Date: 2019/7/31 21:26
 */
public class Solution2 {
    public static void rotate(int[] nums, int k) {
        int len = nums.length;

        int index = 0;
        int tmp = 0;
        for (int i = 0; i < len; i++) {
            tmp = (index + k) % len;//保存覆盖下一位的索引
            nums[tmp] = nums[index];//赋值
            tmp = (tmp + k) % len;//维持索引递增


        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
//        int k = 0;
        int k = 1;
//        int k = 2;
//        int k = 3;
//        int k = 10;

        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
