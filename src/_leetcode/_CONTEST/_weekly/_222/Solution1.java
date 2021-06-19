package _leetcode._CONTEST._weekly._222;

import java.util.Arrays;

/**
 * @Description: 5641. 卡车上的最大单元数
 * 请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ：
 * numberOfBoxesi 是类型 i 的箱子的数量。
 * numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
 * 整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。
 * <p>
 * 返回卡车可以装载 单元 的 最大 总数。
 * @Date: 2021/1/3
 */

public class Solution1 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> (o2[1] - o1[1]));
        int res = 0, idx = 0, n = boxTypes.length;

        while (truckSize > 0 && idx < n) {
            if (truckSize >= boxTypes[idx][0]) {
                res += boxTypes[idx][0] * boxTypes[idx][1];
                truckSize -= boxTypes[idx][0];
                idx++;
            } else {
                res += truckSize * boxTypes[idx][1];
                truckSize = 0;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] nums = {{2, 2}, {1, 3}, {3, 1}};
        Arrays.sort(nums, (o1, o2) -> (o2[1] - o1[1]));
        System.out.println(Arrays.deepToString(nums));
    }
}
