package _CONTEST._weekly._197;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: Number of Good Pairs
 * <p>
 * Given an array of integers nums.
 * A pair (i,j) is called good if nums[i] == nums[j] and i < j.
 * Return the number of good pairs.
 * @Author: matreeix
 * @Date: 2020/7/12
 */

public class Solution1 {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums)
            if (map.containsKey(n))
                map.put(n, map.get(n) + 1);
            else
                map.put(n, 1);
        int res = 0;
        for (int good : map.values()) {
            res += good * (good - 1) / 2;
        }
        return res;
    }


    public static void main(String[] args) {

    }
}
