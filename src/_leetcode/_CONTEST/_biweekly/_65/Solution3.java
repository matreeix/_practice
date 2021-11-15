package _leetcode._CONTEST._biweekly._65;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * @Description: 5912. 每一个查询的最大美丽值
 * 给你一个二维整数数组 items ，其中 items[i] = [pricei, beautyi] 分别表示每一个物品的 价格 和 美丽值 。
 * 同时给你一个下标从 0 开始的整数数组 queries 。对于每个查询 queries[j] ，你想求出价格小于等于 queries[j] 的物品中，最大的美丽值 是多少。如果不存在符合条件的物品，那么查询的结果为 0 。
 * 请你返回一个长度与 queries 相同的数组 answer，其中 answer[j]是第 j 个查询的答案。
 * 提示：
 * <p>
 * 1 <= items.length, queries.length <= 10^5
 * items[i].length == 2
 * 1 <= pricei, beautyi, queries[j] <= 10^9
 * @Date: 2021/11/13
 */

public class Solution3 {
    public static int[] maximumBeauty(int[][] items, int[] queries) {
        int[] ans = new int[queries.length];
        Arrays.sort(items, (item1, item2) -> item1[0] == item2[0] ? item2[1] - item1[1] : item1[0] - item2[0]);
        int[] max = new int[items.length];
        max[0] = items[0][1];
        for (int i = 1; i < max.length; i++) {
            max[i] = Math.max(max[i - 1], items[i][1]);
        }
        System.out.println(Arrays.toString(max));
        for (int i = 0; i < ans.length; i++) {
            int l = 0, r = items.length - 1;
            if (queries[i] < items[l][0]) {
                ans[i] = 0;
            } else if (queries[i] >= items[r][0]) {
                ans[i] = max[max.length - 1];
            } else {
                while (l < r - 1) {
                    int mid = (l + r) / 2;
                    if (items[mid][0] <= queries[i]) {
                        l = mid;
                    } else {
                        r = mid;
                    }
                }
                ans[i] = max[l];
            }
        }
        return ans;
    }

    public int[] maximumBeauty2(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] - b[0]); // Sort items by price in ascending order
        int maxBeauty = 0;
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int[] item : items) {
            maxBeauty = Math.max(maxBeauty, item[1]); // rolling max of beauty seen
            tm.put(item[0], maxBeauty);
        }
        int result[] = new int[queries.length];
        int index = 0;
        for (int query : queries) {
            Integer key = tm.floorKey(query); // if entry for a price exists, value should have max beauty seen else pick floor price entry
            result[index++] = (key == null) ? 0 : tm.get(key);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] items = {{1, 2}, {2, 4}, {3, 2}, {3, 5}, {5, 6}};// [2, 4, 4, 5, 6]
        int[] q = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(maximumBeauty(items, q)));// [2,4,5,5,6,6]
    }

}
