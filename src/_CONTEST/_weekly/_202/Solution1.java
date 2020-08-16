package _CONTEST._weekly._202;

/**
 * @Description: 5185. 存在连续三个奇数的数组
 * 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。
 * @Author: matreeix
 * @Date: 2020/8/15
 */

public class Solution1 {

    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;
        int cnt = 0;
        for (int ele : arr) {
            if (ele % 2 == 1) {
                cnt++;
                if (cnt == 3) return true;
            } else {
                cnt = 0;
            }
        }
        return false;
    }

}
