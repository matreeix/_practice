package _leetcode._greedy._605;

/**
 * @Description: 605. 种花问题
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
 * @Date: 2021/3/27
 */

public class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        int len = flowerbed.length;
        int cnt = 1;//统计连续0的个数，初始左边加个0
        int count = 0;
        for (int f : flowerbed) {
            if (f == 0) {
                cnt++;
            } else {
                count += cnt >= 3 ? (cnt - 1) / 2 : 0;
                cnt = 0;
            }
        }
        cnt++;//最右边也加一个0
        count += cnt >= 3 ? (cnt - 1) / 2 : 0;
        return count >= n;
    }

    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        // 每次跳两格,因为如果遇到1,那么下一格子一定是0
        for (int i = 0; i < flowerbed.length; i += 2) {
            // 如果当前为空地
            if (flowerbed[i] == 0) {
                // 如果是最后一格或者下一格为空
                if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                    n--;
                } else {//flowerbed[i + 1] == 1
                    i++;//跳到下个1
                }
            }
        }
        return n <= 0;
    }

}
