package _bit_calc._169;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 找出数组中个数超过一半的元素
 * @Author: matreeix
 * @Date: 2019/7/27 22:18
 */
public class Solution {
    // Bit manipulation位操作??
    public static int majorityElement(int[] nums) {
        int[] bit = new int[32];
        for (int num : nums)
            for (int i = 0; i < 32; i++)
                if ((num >> (31 - i) & 1) == 1)
                    bit[i]++;
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            bit[i] = bit[i] > nums.length / 2 ? 1 : 0;
            ret += bit[i] * (1 << (31 - i));
        }
        return ret;
    }

    // Sorting
    public static int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // Hashtable
    public static int majorityElement2(int[] nums) {
        Map<Integer, Integer> myMap = new HashMap<>();
        //Hashtable<Integer, Integer> myMap = new Hashtable<Integer, Integer>();
        int ret = 0;
        for (int num : nums) {
            if (!myMap.containsKey(num))
                myMap.put(num, 1);
            else
                myMap.put(num, myMap.get(num) + 1);
            if (myMap.get(num) > nums.length / 2) {
                ret = num;
                break;
            }
        }
        return ret;
    }

    // Moore voting algorithm摩尔投票算法

    /**
     * Boyer-Moore majority vote algorithm(摩尔投票算法)是一
     * 种在线性时间O(n)和空间复杂度的情况下，在一个元素序列中
     * 查找包含最多的元素。它是以Robert S.Boyer和
     * J Strother Moore命名的，1981年发明的，是一种典型
     * 的流算法(streaming algorithm)。
     */

    public static int majorityElement3(int[] nums) {
        int count = 0, ret = 0;
        for (int num : nums) {
            if (count == 0)
            ret = num;
            if (num != ret)
                count--;
            else
                count++;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }
}
