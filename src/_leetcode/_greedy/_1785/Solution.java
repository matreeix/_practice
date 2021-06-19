package _leetcode._greedy._1785;

/**
 * @Description: 1785. 构成特定和需要添加的最少元素
 * 给你一个整数数组 nums ，和两个整数 limit 与 goal 。数组 nums 有一条重要属性：abs(nums[i]) <= limit 。
 * 返回使数组元素总和等于 goal 所需要向数组中添加的 最少元素数量 ，添加元素 不应改变 数组中 abs(nums[i]) <= limit 这一属性。
 * 注意，如果 x >= 0 ，那么 abs(x) 等于 x ；否则，等于 -x 。
 * @Date: 2021/3/9
 */

public class Solution {

    public static int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        int res = 0;
        for (int num : nums)
            sum += num;
        long diff = Math.abs(goal - sum);
        res += diff / limit;
        return diff % limit == 0 ? res : res + 1;
    }

    public static void main(String[] args) {
        int nums[] = {1, -1, 1}, limit = 3, goal = -4;
        System.out.println(minElements(nums, limit, goal));
    }

}
