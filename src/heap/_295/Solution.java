package heap._295;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description: 寻找中位数
 * @Author: 67ng
 * @Date: 2019/12/31 20:57
 */
public class Solution {
    private Queue<Long> small = new PriorityQueue<>();
    private Queue<Long> large = new PriorityQueue<>();

    public void addNum(int num) {
        large.add((long) num);
        small.add(-large.poll());
        if (large.size() < small.size())
            large.add(-small.poll());
    }

    public double findMedian() {
        return large.size() > small.size() ?
                large.peek()
                : (large.peek() - small.peek()) / 2.0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMedian());
    }

}









