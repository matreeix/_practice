package _util;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description: 处理数组的工具类
 * @Date: 2021/11/28
 */

public class ArrayUtil {
    // 字符串格式：[12,3,4,4,55,5,5,5,5]
    public static int[] parse1DimIntArr(String s) {
        s = s.replace(" ", "");
        String[] strings = s.substring(1, s.length() - 1).split(",");
        int[] res = new int[strings.length];
        for (int i = 0; i < res.length; i++)
            res[i] = Integer.parseInt(strings[i]);
        return res;
    }

    public static long[] parse1DimLongArr(String s) {
        s = s.replace(" ", "");
        String[] strings = s.substring(1, s.length() - 1).split(",");
        long[] res = new long[strings.length];
        for (int i = 0; i < res.length; i++)
            res[i] = Long.parseLong(strings[i]);
        return res;
    }

    // 字符串格式：[[3770,1918,1741],[3477,2926,9348],[1990,5345,4364]]
    public static int[][] parse2DimIntArr(String s) {
        s = s.replace(" ", "");
        String[] strings = s.substring(2, s.length() - 2).split("],\\[");
        int len = strings[0].split(",").length;
        int[][] res = new int[strings.length][len];
        for (int i = 0; i < res.length; i++) {
            String[] string = strings[i].split(",");
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = Integer.parseInt(string[j]);
            }
        }
        return res;
    }

    public static long[][] parse2DimLongArr(String s) {
        s = s.replace(" ", "");
        String[] strings = s.substring(2, s.length() - 2).split("],\\[");
        int len = strings[0].split(",").length;
        long[][] res = new long[strings.length][len];
        for (int i = 0; i < res.length; i++) {
            String[] string = strings[i].split(",");
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = Long.parseLong(string[j]);
            }
        }
        return res;
    }

    /**
     * 获取俩数组里各自独有的元素及相同的元素
     */
    public static List<List<Integer>> getDiff(int[] arr1, int[] arr2) {
        Set<Integer> set1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(arr2).boxed().collect(Collectors.toSet());
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> common = new ArrayList<>();
        for (int i1 : set1)
            if (set2.contains(i1)) common.add(i1);
            else list1.add(i1);
        for (int i2 : set2)
            if (!set1.contains(i2)) list2.add(i2);
        Collections.sort(common);
        List<List<Integer>> res = new ArrayList<>();
        res.add(list1);
        res.add(list2);
        res.add(common);
        return res;
    }

    public static int[] list2Arr(List<Integer> list) {
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static List<Integer> arr2List(int[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[][] arrs = parse2DimIntArr(ReadWriteUtil.readFileByLines("C:\\Users\\123456\\Desktop\\LeetCodeDemo.txt"));
        for (int[] arr : arrs)
            System.out.println(Arrays.toString(arr));
    }

}
