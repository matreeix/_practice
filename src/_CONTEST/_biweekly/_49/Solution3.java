package _CONTEST._biweekly._49;

import java.util.*;

/**
 * @Description: 5708. 统计一个数组中好对子的数目
 * 给你一个数组 nums ，数组中只包含非负整数。定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。比方说 rev(123) = 321 ， rev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ：
 * 0 <= i < j < nums.length
 * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 * 请你返回好下标对的数目。由于结果可能会很大，请将结果对 109 + 7 取余 后返回。
 * @Date: 2021/4/3
 */

public class Solution3 {

    public static int countNicePairs(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        Map<Long, List<Integer>> map = new HashMap<>();
        for (int num : nums) {
            long tmp = reverseInt(num) - num;
            if (map.containsKey(tmp)) map.get(tmp).add(num);
            else map.put(tmp, new ArrayList<Integer>() {{
                add(num);
            }});
        }
        long res = 0, mod = 1000000007;
        for (List<Integer> list : map.values()) {
            long size = list.size();
            res += size * (size - 1) / 2;
        }
        return (int) (res % mod);
    }

    private static long reverseInt(int num) {
        return Long.parseLong(new StringBuilder(num + "").reverse().toString());
    }

    public static void main(String[] args) {
        int[] nums = {13, 10, 35, 24, 76};
        System.out.println(countNicePairs(nums));
//        System.out.println(reverseInt(Integer.MAX_VALUE));
    }
}
