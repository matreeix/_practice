package _leetcode._string._763;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 分区标签
 * <p>
 * S给出一串小写英文字母。我们希望将此字符串分成尽可能多的部分，以使每个字母最多出现在一个部分，并返回代表这些部分大小的整数列表。
 * @Author: matreeix
 * @Date: 2020/7/13
 */

public class Solution {

    //利用合并区间的函数
    //1.计算各字母第一次和最后一次出现的位置
    //2.合并区间
    public static List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S.length() < 2) {
            res.add(S.length());
            return res;
        }
        int[][] intervals = new int[26][2];
        for (int[] interval : intervals)
            Arrays.fill(interval, -1);

        for (int i = 0; i < S.length(); i++) {
            int[] ints = intervals[S.charAt(i) - 'a'];
            if (ints[0] == -1) {
                ints[0] = i;
                ints[1] = i;
            } else {
                ints[1] = i;
            }
        }
        int[][] merged = merge(intervals);
        System.out.println(Arrays.deepToString(merged));
        for (int[] arr : merged)
            if (arr[0] != -1)
                res.add(arr[1] - arr[0] + 1);
        return res;
    }

    //合并重叠区间
    private static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);//左升序右降序
        int left = intervals[0][0], right = intervals[0][1];
        List<int[]> list = new LinkedList<>();
        for (int[] arr : intervals) {
            if (arr[1] > right && arr[0] <= right) {//拓宽右边界
                right = arr[1];
            } else if (arr[0] > right) {//无法拓宽，更新左右边界
                list.add(new int[]{left, right});
                left = arr[0];
                right = arr[1];
            }
        }
        list.add(new int[]{left, right});
        return list.toArray(new int[list.size()][]);
    }


    //1.遍历字符串，记录每个字符的最后一个索引。
    //2.使用指针记录当前子字符串的结尾。
    public static List<Integer> partitionLabels2(String S) {
        if (S == null || S.length() == 0) return null;

        List<Integer> list = new ArrayList<>();
        int[] map = new int[26];  //record the last index of the each char

        for (int i = 0; i < S.length(); i++)
            map[S.charAt(i) - 'a'] = i;

        //record the end index of the current substring
        int last = 0;
        int start = 0;
        for (int i = 0; i < S.length(); i++) {
            last = Math.max(last, map[S.charAt(i) - 'a']);//重合区间会合并，妙啊！
            if (last == i) {
                list.add(last - start + 1);
                start = last + 1;
            }
        }
        return list;
    }

    public static void main(String[] args) {
//        int[][] intervals = {{1, 2}, {3, 3}, {4, 5}, {5, 6}};
//        String S = "ababcbacadefegdehijhklij";
//        System.out.println(partitionLabels(S));
//        System.out.println(Arrays.deepToString(merge(intervals)));
        String s = "abbaccd";
        System.out.println(partitionLabels2(s));
    }
}
