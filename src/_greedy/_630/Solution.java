package _greedy._630;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description:课程表Ⅲ
 * @Author: 67ng
 * @Date: 2020/3/6
 */
public class Solution {
    public int scheduleCourse(int[][] courses) {
        //先按照截至日期排序
        Arrays.sort(courses,
                (int[] course1, int[] course2) -> course1[1] - course2[1]);
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);//大根堆
        int costTime = 0;//记录累计花费过的时间
        for (int[] course : courses) {
            costTime += course[0];
            pq.add(course[0]);
            if (costTime > course[1]) {
                costTime -= pq.poll();//弹出花费时间最多的课程
            }
        }
        return pq.size();
    }

    public static void main(String[] args) {
        int[][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        System.out.println((new Solution()).scheduleCourse(courses));
    }

}
