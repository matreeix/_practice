package backtracking._39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 挑选数组的元素相加得到目标数，不限次数
 * @Author: caffebaby
 * @Date: 2020/1/10
 */
public class Solution {
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
//        Arrays.sort(nums);没必要排序
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list,//存储结果
                           List<Integer> tempList,
                           int[] nums,
                           int remain,
                           int start) {
        if (remain < 0)//小于0直接返回
            return;
        else if (remain == 0)//可以得到0就添加进结果集
            list.add(new ArrayList<>(tempList));
        else {//大于0继续递归
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); //可以重用元素所以不是从i+1开始
                tempList.remove(tempList.size() - 1);//很重要，删除了才能回溯
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(nums,target));
    }


}
