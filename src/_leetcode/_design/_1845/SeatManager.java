package _leetcode._design._1845;

import java.util.PriorityQueue;

/**
 * @Description: 1845. 座位预约管理系统
 * 请你设计一个管理 n 个座位预约的系统，座位编号从 1 到 n 。
 * <p>
 * 请你实现 SeatManager 类：
 * <p>
 * SeatManager(int n) 初始化一个 SeatManager 对象，它管理从 1 到 n 编号的 n 个座位。所有座位初始都是可预约的。
 * int reserve() 返回可以预约座位的 最小编号 ，此座位变为不可预约。
 * void unreserve(int seatNumber) 将给定编号 seatNumber 对应的座位变成可以预约。
 * @Date: 2021/8/27
 */

public class SeatManager {
    private PriorityQueue<Integer> p;

    public SeatManager(int n) {
        this.p = new PriorityQueue<>(n);
        for (int i = 1; i <= n; i++) {
            p.add(i);
        }
    }

    public int reserve() {
        return p.poll();
    }

    public void unreserve(int seatNumber) {
        p.add(seatNumber);
    }
}
