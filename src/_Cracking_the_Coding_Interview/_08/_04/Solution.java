package _Cracking_the_Coding_Interview._08._04;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 面试题 08.04. 幂集
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 * <p>
 * 说明：解集不能包含重复的子集。
 * @Author: matreeix
 * @Date: 2020/8/5
 */

public class Solution {
    /**
     * 原理：例如 [1, 2, 3] 有三位可以从 0 遍历到 7 也就是 2 ^ 3 - 1 用二进制表示就是 000, 001, 010, 011, 100, 101, 110, 111 正好代表了全部子集。
     */
    //位运算,妙啊！
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        int bmp = 1 << nums.length;
        for (int i = 0; i < bmp; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < nums.length; j++)
                if ((i >> j & 1) == 1)//判断每一位是否为1
                    subset.add(nums[j]);
            subsets.add(subset);
        }
        return subsets;
    }

    //回溯法
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        Solution s = new Solution();
        System.out.println(s.subsets2(arr));
    }
}
