package _leetcode._CONTEST._LCP._42;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description: LCP 42. 玩具套圈
 * 「力扣挑战赛」场地外，小力组织了一个套玩具的游戏。所有的玩具摆在平地上，toys[i] 以 [xi,yi,ri] 的形式记录了第 i 个玩具的坐标 (xi,yi) 和半径 ri。
 * 小扣试玩了一下，他扔了若干个半径均为 r 的圈，circles[j] 记录了第 j 个圈的坐标 (xj,yj)。套圈的规则如下：
 * 若一个玩具被某个圈完整覆盖了（即玩具的任意部分均在圈内或者圈上），则该玩具被套中。
 * 若一个玩具被多个圈同时套中，最终仅计算为套中一个玩具
 * 请帮助小扣计算，他成功套中了多少玩具。
 * <p>
 * 注意：输入数据保证任意两个玩具的圆心不会重合，但玩具之间可能存在重叠。
 * 提示：
 * <p>
 * 1 <= toys.length <= 10^4
 * 0 <= toys[i][0], toys[i][1] <= 10^9
 * 1 <= circles.length <= 10^4
 * 0 <= circles[i][0], circles[i][1] <= 10^9
 * 1 <= toys[i][2], r <= 10
 * @Date: 2021/9/11
 */

public class Solution2 {
    //暴力解法
    public int circleGame(int[][] toys, int[][] circles, int r) {
        int res = 0;
        boolean[] mark = new boolean[toys.length];
        for (int i = 0; i < toys.length; i++)
            if (toys[i][2] > r)
                mark[i] = true;
        for (int i = 0; i < toys.length; i++) {
            if (!mark[i]) {
                for (int j = 0; j < circles.length; j++) {
                    long l = (long) (toys[i][0] - circles[j][0]) * (toys[i][0] - circles[j][0])
                            + (long) (toys[i][1] - circles[j][1]) * (toys[i][1] - circles[j][1]);
                    if (l <= (long) (r - toys[i][2]) * (r - toys[i][2])) {
                        res++;
                        break;
                    }
                }
            }
        }
        return res;
    }

    public int circleGame2(int[][] toys, int[][] circles, int r) {
        int cnt = 0;
        Arrays.sort(circles, (o1, o2) -> o1[0] - o2[0] == 0 ? o1[1] - o2[1] : o1[0] - o2[0]);
        for (int[] toy : toys) {
            int x2 = toy[0];
            int y2 = toy[1];
            int r2 = toy[2];
            int left = 0;
            int right = circles.length - 1;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (circles[mid][0] < x2) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            boolean flag = false;
            int index = left - 1;
            while (index >= 0 && Math.abs(circles[index][0] - x2) <= r - r2) {
                if (isValid(circles[index][0], circles[index][1], r, x2, y2, r2)) {
                    flag = true;
                    break;
                }
                index--;
            }
            if (flag) {
                cnt++;
                continue;
            }
            index = left;
            while (index < circles.length && Math.abs(circles[index][0] - x2) <= r - r2) {
                if (isValid(circles[index][0], circles[index][1], r, x2, y2, r2)) {
                    flag = true;
                    break;
                }
                index++;
            }
            if (flag) {
                cnt++;
            }

        }
        return cnt;
    }

    public boolean isValid(long x1, long y1, long r1, long x2, long y2, long r2) {
        if (Math.abs(x1 - x2) > r1 - r2 || Math.abs(y1 - y2) > r1 - r2) {
            return false;
        }
        return Math.sqrt(helper(x1 - x2) + helper(y1 - y2)) <= r1 - r2;
    }

    public long helper(long a) {
        return a * a;
    }

}
