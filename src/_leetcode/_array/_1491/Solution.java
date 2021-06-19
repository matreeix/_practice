package _leetcode._array._1491;

/**
 * @Description: 去掉极值后的平均值
 * <p>
 * 给你一个整数数组 salary ，数组里每个数都是 唯一 的，其中 salary[i] 是第 i 个员工的工资。
 * 请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
 * @Author: matreeix
 * @Date: 2020/7/6
 */

public class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : salary) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        double ave = (sum - min - max - 0.0) / (salary.length - 2);
        return ave;
    }

    public static void main(String[] args) {
        int[] salary = {8000, 9000, 2000, 3127, 6000, 1000};
        System.out.println((new Solution()).average(salary));
    }
}
