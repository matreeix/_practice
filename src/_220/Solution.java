package _220;

import java.util.TreeSet;

/**
 * @Description: 寻找是否存在满足索引和元素值限制的重复数
 * @Author: 67ng
 * @Date: 2019/8/10 10:13
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 这个问题的测试数据在使用int进行加减运算时会溢出
        // 所以使用long long
        TreeSet<Long> record = new TreeSet<Long>();
        for (int i = 0; i < nums.length; i++) {

            if (record.ceiling((long) nums[i] - (long) t) != null &&
                    record.ceiling((long) nums[i] - (long) t) <= (long) nums[i] + (long) t)
                return true;

            record.add((long) nums[i]);

            if (record.size() == k + 1)
                record.remove((long) nums[i - k]);
        }

        return false;
    }

}
