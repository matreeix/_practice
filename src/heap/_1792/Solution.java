package heap._1792;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description: 1792. 最大平均通过率
 * 一所学校里有一些班级，每个班级里有一些学生，现在每个班都会进行一场期末考试。给你一个二维数组 classes ，其中 classes[i] = [passi, totali] ，表示你提前知道了第 i 个班级总共有 totali 个学生，其中只有 passi 个学生可以通过考试。
 * 给你一个整数 extraStudents ，表示额外有 extraStudents 个聪明的学生，他们 一定 能通过任何班级的期末考。你需要给这 extraStudents 个学生每人都安排一个班级，使得 所有 班级的 平均 通过率 最大 。
 * 一个班级的 通过率 等于这个班级通过考试的学生人数除以这个班级的总人数。平均通过率 是所有班级的通过率之和除以班级数目。
 * 请你返回在安排这 extraStudents 个学生去对应班级后的 最大 平均通过率。与标准答案误差范围在 10-5 以内的结果都会视为正确结果。
 * @Date: 2021/3/16
 */

public class Solution {

    //分析：1. (a + k)/(b + k) > a / b;
    //     2. 随着k的增大，分数的增加率越来越小，当 a == b ，分数不再增大
    //     3. 综上，每取出最小的分数来添加值直到超过第二小的分数
    static class Triple implements Comparable {
        double diff;
        int x, y;

        Triple(double diff, int x, int y) {
            this.diff = diff;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Object o) {
            Triple t = (Triple) o;
            // Java默认是小根堆， 换成大根堆
            return -1 * (t.diff == diff ? t.x == x ? t.y - y : t.x - x : diff > t.diff ? 1 : -1);
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Triple> priorityQueue = new PriorityQueue<>();
        double ans = 0;
        for (int[] c : classes) {
            int x = c[0], y = c[1];
            ans += (double) x / y;
            priorityQueue.add(new Triple(diff(x, y), x, y));
        }
        for (int i = 0; i < extraStudents; ++i) {
            Triple s = priorityQueue.poll();
            ans += s.diff;
            priorityQueue.add(new Triple(diff(s.x + 1, s.y + 1), s.x + 1, s.y + 1));
        }
        return ans / classes.length;
    }

    private double diff(int lhs, int rhs) {
        return (double) (lhs + 1) / (rhs + 1) - (double) lhs / rhs;
    }

    public static void main(String[] args) {
        int classes[][] = {{1, 2}, {3, 5}, {2, 2}}, extraStudents = 2;
    }

}
