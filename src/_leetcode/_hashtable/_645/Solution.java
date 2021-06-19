package _leetcode._hashtable._645;

/**
 * @Description: 645. 错误的集合
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回
 * @Date: 2021/3/28
 */

public class Solution {

    public int[] findErrorNums(int[] nums) {
        boolean[] tmp = new boolean[nums.length + 1];
        int repeat = 0, lose = 0;
        for (int num : nums)
            if (!tmp[num]) tmp[num] = true;
            else repeat = num;

        for (int i = 1; i < tmp.length; i++)
            if (!tmp[i])
                lose = i;
        return new int[]{repeat, lose};
    }

}
