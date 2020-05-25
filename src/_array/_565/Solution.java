package _array._565;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 数组的嵌套
 * <p>
 * 索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，
 * 其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
 * 假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
 * @Author: 67ng
 * @Date: 2020/5/25
 */
public class Solution {

    //思路：遍历数组每个元素找到一个循环为止，且将循环内的元素循环节大小都一样做好标记，可以跳过标记的元素
//    时间复杂度：O(n). nums 数组的每个元素最多只考虑一次。
//    空间复杂度：O(n). 使用的 visited 是大小为 n 的数组。
    public static int arrayNesting(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int max = 0;
        boolean[] mark = new boolean[len];//标记是否已循环过的元素
        for (int i = 0; i < len; i++) {
            if (mark[i]) {
                continue;
            } else {
                Set<Integer> store = new HashSet<>();//存储每个循环的值
                int tmp = i;
                while (!store.contains(nums[tmp])) {
                    mark[tmp] = true;
                    store.add(nums[tmp]);
                    tmp = nums[tmp];
                }
                max = Math.max(max, store.size());
                if (max == len) return max;
            }
        }
        return max;
    }
//
//    时间复杂度：O(n)。nums 数组的每个元素最多只考虑一次。
//    空间复杂度：O(1)。使用了常数级的额外空间
    public int arrayNesting2(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MAX_VALUE) {
                int start = nums[i], count = 0;
                while (nums[start] != Integer.MAX_VALUE) {
                    int temp = start;
                    start = nums[start];
                    count++;
                    nums[temp] = Integer.MAX_VALUE;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 0, 3, 1, 6, 2};
        System.out.println(arrayNesting(arr));
    }
}
