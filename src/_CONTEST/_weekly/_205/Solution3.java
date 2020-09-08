package _CONTEST._weekly._205;

/**
 * @Description: 5509. 避免重复字母的最小删除成本
 * 给你一个字符串 s 和一个整数数组 cost ，其中 cost[i] 是从 s 中删除字符 i 的代价。
 * 返回使字符串任意相邻两个字母不相同的最小删除成本。
 * <p>
 * 请注意，删除一个字符后，删除其他字符的成本不会改变。
 * @Author: matreeix
 * @Date: 2020/9/6
 */

public class Solution3 {
    public static int minCost(String s, int[] cost) {
        int res = 0, max_cost = 0, n = s.length();
        for (int i = 0; i < n; ++i) {
            if (i > 0 && s.charAt(i) != s.charAt(i - 1))
                max_cost = 0;
            res += Math.min(max_cost, cost[i]);
            max_cost = Math.max(max_cost, cost[i]);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] cost = {1, 2, 3, 4, 5};
//        String s = "abaac";
        String s = "aaabbbabbbb";
        int[] cost = {3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1};
        System.out.println(minCost(s, cost));
    }
}
