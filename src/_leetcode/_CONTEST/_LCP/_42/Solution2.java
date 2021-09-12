package _leetcode._CONTEST._LCP._42;

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
}
