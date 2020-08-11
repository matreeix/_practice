package _array._986;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 区间相交
 * <p>
 * 给定两个闭合间隔列表，每个间隔列表成对且两两不相交，并按排序顺序排列。
 * 返回这两个间隔列表的交集。
 * （通常的，闭区间[a, b]（有a <= b）表示实数集x与a <= x <= b。两个封闭间隔的交叉点是一组为空，
 * 或者可以被表示为一个封闭的间隔的实数。例如，交叉点[ 1，3]和[2，4]是[2，3]。）
 * @Author: caffebaby
 * @Date: 2020/7/14
 */

public class Solution {
    //二分搜索+双指针
    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) return new int[0][0];
        List<int[]> list = new ArrayList<>();
        int n = B.length;
        int start = 0;
        for (int[] a : A) {
            int l = binarySearch(B, 1, a[0], start, n - 1);
            int r = binarySearch(B, 0, a[1], start, n - 1);

            if (Math.min(l, r) < 0)
                continue;//超过左边界
            if (Math.max(l, r) >= n)
                break;//超过右边界
            if (l < r) {//交集不同
                int Lmin = Math.max(a[0], B[l][0]);
                int Lmax = Math.min(a[1], B[l][1]);
                int Rmin = Math.max(a[0], B[r][0]);
                int Rmax = Math.min(a[1], B[r][1]);

                list.add(new int[]{Lmin, Lmax});
                for (int i = l + 1; i < r; i++)
                    list.add(B[i]);
                list.add(new int[]{Rmin, Rmax});
            } else if (l == r) {//交集一样
                int min = Math.max(a[0], B[l][0]);
                int max = Math.min(a[1], B[l][1]);

                list.add(new int[]{min, max});
            }
            start = r;//缩小左边界，增加二分搜索速率
        }

        return list.toArray(new int[list.size()][]);
    }

    //二分法查找边界
    private static int binarySearch(int[][] intervals, int mark, int target, int l, int r) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (intervals[mid][mark] > target) {
                r = mid - 1;
            } else if (intervals[mid][mark] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return mark == 0 ? r : l;
    }

    //大佬的解法,妙啊
    public static int[][] intervalIntersection2(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0, j = 0; i < A.length && j < B.length; ) {
            int start = Math.max(A[i][0], B[j][0]);
            int end = Math.min(A[i][1], B[j][1]);
            if (start <= end)
                list.add(new int[]{start, end});

            if (A[i][1] < B[j][1]) ++i;
            else ++j;

        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
//        int[][] A = {{0, 2}, {5, 10}, {13, 23}, {24, 25}}, B = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};

//        int[][] A = {{0, 5}, {12, 14}, {15, 18}}, B = {{11, 15}, {18, 19}};
        int[][] A = {{6, 7}, {8, 13}}, B = {{4, 5}, {11, 13}};

        System.out.println(Arrays.deepToString(intervalIntersection2(A, B)));
    }
}
