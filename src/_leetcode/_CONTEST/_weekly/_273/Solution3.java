package _leetcode._CONTEST._weekly._273;

import java.util.*;

/**
 * @Description: 5965. 相同元素的间隔之和
 * 给你一个下标从 0 开始、由 n 个整数组成的数组 arr 。
 * arr 中两个元素的 间隔 定义为它们下标之间的 绝对差 。更正式地，arr[i] 和 arr[j] 之间的间隔是 |i - j| 。
 * 返回一个长度为 n 的数组 intervals ，其中 intervals[i] 是 arr[i] 和 arr 中每个相同元素（与 arr[i] 的值相同）的 间隔之和 。
 * 注意：|x| 是 x 的绝对值。
 * 提示：
 * n == arr.length
 * 1 <= n <= 10^5
 * 1 <= arr[i] <= 10^5
 * @Date: 2021/12/26
 */

public class Solution3 {
    // O(n)
    public static long[] getDistances(int[] arr) {
        long[] res = new long[arr.length];
        Arrays.fill(res, -1);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        for (int key : map.keySet()) {
            if (map.get(key).size() == 1) {// 只有一个值时候
                res[map.get(key).get(0)] = 0;
            } else {
                List<Integer> vals = map.get(key);
                int n = vals.size();
                long[] pre = new long[n];
                pre[0] = vals.get(0);
                for (int i = 1; i < pre.length; i++) pre[i] = pre[i - 1] + vals.get(i);
                for (int i = 0; i < n; i++) {
                    int idx = vals.get(i);
                    if (i == 0) res[idx] = pre[n - 1] - n * pre[0];
                    else res[idx] = pre[n - 1] - 2 * pre[i - 1] + (2L * i - n) * idx;// 将求绝对值展开为求前缀和
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] arr = {2, 1, 3, 1, 2, 3, 3};
        int[] arr = {2, 1, 3, 1, 2, 3, 3};
//        int[] arr = {10, 5, 10, 10};//[5,0,3,4]
        System.out.println(Arrays.toString(getDistances(arr)));
    }
}
