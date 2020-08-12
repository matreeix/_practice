package _greedy._135;

import java.util.Arrays;

/**
 * @Description: 分发糖果
 * @Author: matreeix
 * @Date: 2020/6/6
 */
public class Solution {
    //时间复杂度和空间复杂度都是O(n)
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; i++) {//从左往右扫
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        int sum = candies[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {//从右往左扫
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);//扫过一次了，可能不需要更新
            }
            sum += candies[i];
        }
        return sum;
    }
}
