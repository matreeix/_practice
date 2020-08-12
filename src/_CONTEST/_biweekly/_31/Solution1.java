package _CONTEST._biweekly._31;

/**
 * @Description: 1523. 在区间范围内统计奇数数目
 * 给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。
 * @Author: matreeix
 * @Date: 2020/7/27
 */

public class Solution1 {
    public static int countOdds(int low, int high) {
        if (low % 2 == 0 && high % 2 == 0)
            return (high - low) / 2;
        else
            return (high - low) / 2 + 1;
    }

    public static void main(String[] args) {
        System.out.println(countOdds(3, 7));
    }

}
