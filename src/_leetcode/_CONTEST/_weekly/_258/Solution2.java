package _leetcode._CONTEST._weekly._258;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 5868. 可互换矩形的组数
 * 用一个下标从 0 开始的二维整数数组 rectangles 来表示 n 个矩形，其中 rectangles[i] = [widthi, heighti] 表示第 i 个矩形的宽度和高度。
 * 如果两个矩形 i 和 j（i < j）的宽高比相同，则认为这两个矩形 可互换 。更规范的说法是，两个矩形满足 widthi/heighti == widthj/heightj（使用实数除法而非整数除法），则认为这两个矩形 可互换 。
 * 计算并返回 rectangles 中有多少对 可互换 矩形。
 * 提示：
 * <p>
 * n == rectangles.length
 * 1 <= n <= 10^5
 * rectangles[i].length == 2
 * 1 <= widthi, heighti <= 10^5
 * @Date: 2021/9/12
 */

public class Solution2 {
    public long interchangeableRectangles(int[][] rectangles) {
        long res = 0;
        Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
        for (int[] rec : rectangles) {
            int gcd = gcd(rec[0], rec[1]);
            Pair<Integer, Integer> key = new Pair<>(rec[0] / gcd, rec[1] / gcd);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        for (int val : map.values())
            res += mul((long) val);

        return res;

    }

    private long mul(long n) {
        return n * (n - 1) / 2;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[][] arr = {{4, 8}, {3, 6}, {10, 20}, {15, 30}};
        System.out.println(s.interchangeableRectangles(arr));
    }
}
