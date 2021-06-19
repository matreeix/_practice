package _leetcode._CONTEST._weekly._224;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 1726. 同积元组
 * 给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。其中 a、b、c 和 d 都是 nums 中的元素，且 a != b != c != d 。
 * 提示：
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 10^4
 * nums 中的所有元素 互不相同
 * @Date: 2021/1/17
 */

public class Solution2 {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();//<乘积，个数>
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                map.put(nums[i] * nums[j], map.getOrDefault(nums[i] * nums[j], 0) + 1);
        int res = 0;
        for (int i : map.values())
            if (i > 1)
                res += i * (i - 1) / 2;

        return 8 * res;
    }

    public static void main(String[] args) {

    }
}
