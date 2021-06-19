package _leetcode._CONTEST._biweekly._42;

/**
 * @Description: 1701. 平均等待时间
 * 有一个餐厅，只有一位厨师。你有一个顾客数组 customers ，其中 customers[i] = [arrivali, timei] ：
 * 1.arrivali 是第 i 位顾客到达的时间，到达时间按 非递减 顺序排列。
 * 2.timei 是给第 i 位顾客做菜需要的时间。
 * 当一位顾客到达时，他将他的订单给厨师，厨师一旦空闲的时候就开始做这位顾客的菜。每位顾客会一直等待到厨师完成他的订单。厨师同时只能做一个人的订单。厨师会严格按照 订单给他的顺序 做菜。
 * <p>
 * 请你返回所有顾客需要等待的 平均 时间。与标准答案误差在 10-5 范围以内，都视为正确结果。
 * @Date: 2020/12/30
 */

public class Solution2 {
    public static double averageWaitingTime(int[][] customers) {
        long cnt = 0;
        int time = customers[0][0];
        for (int[] customer : customers) {
            if (time < customer[0])//顾客到达时厨师空闲
                time = customer[0];
            time += customer[1];
            cnt += time - customer[0];
        }
        return cnt * 1.0 / customers.length;
    }

    public static void main(String[] args) {
//        int[][] customers = {{5, 2}, {5, 4}, {10, 3}, {20, 1}};
        int[][] customers = {{1, 2}, {2, 5}, {4, 3}};
        System.out.println(averageWaitingTime(customers));
    }
}
