package _leetcode._CONTEST._weekly._280;

import java.util.Arrays;

/**
 * @Description: 2171. 拿出最少数目的魔法豆
 * 给你一个 正 整数数组 beans ，其中每个整数表示一个袋子里装的魔法豆的数目。
 * 请你从每个袋子中 拿出 一些豆子（也可以 不拿出），使得剩下的 非空 袋子中（即 至少 还有 一颗 魔法豆的袋子）魔法豆的数目 相等 。一旦魔法豆从袋子中取出，你不能将它放到任何其他的袋子中。
 * 请你返回你需要拿出魔法豆的 最少数目。
 * 提示：
 * 1 <= beans.length <= 10^5
 * 1 <= beans[i] <= 10^5
 * @Date: 2022/2/15
 */

public class Solution3 {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long sum = 0;
        long mx = 0;//最多保留的豆子数
        for (int i = 0; i < beans.length; i++) {
            sum += beans[i];
            mx = Math.max(mx, (long) (beans.length - i) * beans[i]);
        }
        return sum - mx;
    }

}
