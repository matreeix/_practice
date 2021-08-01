package _leetcode._CONTEST._weekly._252;

/**
 * @Description: 5187. 收集足够苹果的最小花园周长
 * 给你一个用无限二维网格表示的花园，每一个 整数坐标处都有一棵苹果树。整数坐标 (i, j) 处的苹果树有 |i| + |j| 个苹果。
 * 你将会买下正中心坐标是 (0, 0) 的一块 正方形土地 ，且每条边都与两条坐标轴之一平行。
 * 给你一个整数 neededApples ，请你返回土地的 最小周长 ，使得 至少 有 neededApples 个苹果在土地 里面或者边缘上。
 * |x| 的值定义为：
 * 如果 x >= 0 ，那么值为 x
 * 如果 x < 0 ，那么值为 -x
 * <p>
 * 提示：
 * 1 <= neededApples <= 10^15
 * @Date: 2021/8/1
 */

public class Solution3 {
    public long minimumPerimeter(long neededApples) {
        long l = 0, r = 1000000;
        while (l < r) {
            long mid = (l + r) / 2;
            if (getApples(mid) >= neededApples) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l * 4L;
    }

    private long getApples(long len) {
        long x = len / 2;
        return 2 * x * (x + 1) * (2 * x + 1);
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(s.minimumPerimeter(1));
        System.out.println(s.minimumPerimeter(13));
        System.out.println(s.minimumPerimeter(1000000000));
        System.out.println(s.minimumPerimeter(100000000000000L));
//        4840904862144
//        100000000000000
    }
}
