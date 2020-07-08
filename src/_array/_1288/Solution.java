package _array._1288;

import java.util.Arrays;

/**
 * @Description: 删除被覆盖区间
 * <p>
 * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
 * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
 * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
 * @Author: Pythagodzilla
 * @Date: 2020/7/8
 */

public class Solution {
    /**
     * 1、2、3的时间负复杂度都是O(nlogn)
     * 4的时间复杂度是O(n)
     */
    //滑动窗口
    public static int removeCoveredIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 1) return intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);//以第一个元素排序
        int count = intervals.length;
        int l = intervals[0][0];
        int r = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            while (intervals[i][1] <= r) {//右边界小于当前值的直接去掉
                count--;
                if (i == intervals.length - 1)
                    return count;
                else
                    i++;
            }
            if (intervals[i][0] == l)//左边界重合的特殊情况
                count--;
            else
                l = intervals[i][0];
            r = intervals[i][1];//跟新右边界
        }
        return count;
    }

    //仅仅左排序
    public int removeCoveredIntervals2(int[][] A) {
        int res = 0, left = -1, right = -1;
        Arrays.sort(A, (a, b) -> a[0] - b[0]);
        for (int[] v : A) {
            if (v[0] > left && v[1] > right) {
                left = v[0];
                ++res;
            }
            right = Math.max(right, v[1]);
        }
        return res;
    }

    //按左升序和右降序排序
    public int removeCoveredIntervals3(int[][] A) {
        int res = 0, right = 0;
        Arrays.sort(A, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        for (int[] v : A) {
            if (v[1] > right) {
                ++res;
                right = v[1];
            }
        }
        return res;
    }


    //时间性能较好
    public int removeCoveredIntervals4(int[][] intervals) {
        int len = intervals.length;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (intervals[i][0] != -1) {
                for (int j = i + 1; j < len; j++) {
                    if (intervals[j][0] != -1) {
                        if (intervals[i][0] <= intervals[j][0] && intervals[i][1] >= intervals[j][1]) {
                            cnt++;
                            intervals[j][0] = -1;
                        } else if (intervals[j][0] <= intervals[i][0] && intervals[j][1] >= intervals[i][1]) {
                            cnt++;
                            intervals[i][0] = -1;
                            break;
                        }
                    }
                }
            }
        }
        return len - cnt;
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1, 4}, {3, 6}, {2, 8}};
        int[][] intervals2 = {{1, 2}, {1, 4}, {3, 4}};
        System.out.println(removeCoveredIntervals(intervals1));
        System.out.println(removeCoveredIntervals(intervals2));
    }
}
