package _leetcode._search._1011;

/**
 * @Description: 1011. 在 D 天内送达包裹的能力
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * 传送带上的第 i 个包裹的重量为 weights[i]。
 * 每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * @Author: matreeix
 * @Date: 2020/8/17
 */

public class Solution {

    //其实代码和410一模一样
    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for (int w : weights) {
            left = Math.max(left, w);//记录最大值
            right += w;//记录所有数之和
        }
        while (left < right) {
            int mid = (left + right) / 2, need = 1, cur = 0;
            for (int w : weights) {
                if (cur + w > mid) {
                    need += 1;
                    cur = 0;
                }
                cur += w;
            }
            if (need > D)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

}
