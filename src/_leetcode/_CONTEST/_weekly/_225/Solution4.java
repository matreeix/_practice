package _leetcode._CONTEST._weekly._225;

/**
 * @Description: 1739. 放置盒子
 * 有一个立方体房间，其长度、宽度和高度都等于 n 个单位。请你在房间里放置 n 个盒子，每个盒子都是一个单位边长的立方体。放置规则如下：
 * 1.你可以把盒子放在地板上的任何地方。
 * 2.如果盒子 x 需要放置在盒子 y 的顶部，那么盒子 y 竖直的四个侧面都 必须 与另一个盒子或墙相邻。
 * 给你一个整数 n ，返回接触地面的盒子的 最少 可能数量。
 * @Date: 2021/1/26
 */

public class Solution4 {
    //数学法，O(1)
    public int minimumBoxes(int n) {
        if (n <= 3) return n;
        long i = (long) (Math.cbrt(n * 6l)) - 1;
        long floor = i * (i + 1) / 2l, sum = (i + 2) * (i + 1) * i / 6l;
        long diff = n - sum;
        //Quadratic formula
        double f = (-1 + Math.sqrt(1 + 4 * 2 * diff)) / 2;
        return (int) floor + (int) Math.ceil(f);
    }

    public int minimumBoxes2(int n) {
        int sum = 0, curLevelTotalBox = 0, nextOutBound = 0;
        while (sum < n) {
            nextOutBound++;
            curLevelTotalBox += nextOutBound;
            sum += curLevelTotalBox;
        }
        if (sum == n) return curLevelTotalBox;
        sum -= curLevelTotalBox;
        curLevelTotalBox -= nextOutBound;
        nextOutBound = 0;
        while(sum < n) {
            nextOutBound++;
            sum += nextOutBound;
        }
        return curLevelTotalBox + nextOutBound;
    }

}
