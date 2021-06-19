package _leetcode._array._414;

/**
 * @Description: 414. 第三大的数
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * 注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * @Date: 2021/3/24
 */

public class Solution {
    //使用包装类
    public static int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }

    //使用long类型
    public int thirdMax2(int[] nums) {
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
        for (int num : nums) {
            // 过滤重复和小于第三大的数
            if (third >= num || second == num || first == num) continue;
            if (first < num) {
                third = second;
                second = first;
                first = num;
            } else if (second < num) {
                third = second;
                second = num;
            } else {
                third = num;
            }
        }
        return (int) (third == Long.MIN_VALUE ? first : third);
    }



    public static void main(String[] args) {
        int[] arr1 = {2, 2, 3, 1};
        int[] arr2 = {2, 3, 1};
        int[] arr3 = {2, 1};
        int[] arr4 = {-2147483648, 1, 2};
        System.out.println(thirdMax(arr1));
        System.out.println(thirdMax(arr2));
        System.out.println(thirdMax(arr3));
        System.out.println(thirdMax(arr4));
    }
}
