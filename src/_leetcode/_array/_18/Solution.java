package _leetcode._array._18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 四数之和
 * @Author: matreeix
 * @Date: 5/14/2020
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return result;

        Arrays.sort(nums);//由于要用指针所以要先排序
        int length = nums.length;

        /*定义4个指针k，i，j，h  k从0开始遍历，i从k+1开始遍历，留下j和h，j指向i+1，h指向数组最大值*/
        for (int k = 0; k < length - 3; k++) {//第一个指针

            if (k > 0 && nums[k] == nums[k - 1]) continue; //跳过相同值
            int min1 = nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3];//整个数组四数和的最小值
            if (min1 > target) break;
            int max1 = nums[k] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (max1 < target) continue;

            for (int i = k + 1; i < length - 2; i++) {//第二个指针
                if (i > k + 1 && nums[i] == nums[i - 1]) continue;//跳过相同值

                int j = i + 1;//第三个指针
                int h = length - 1;//第四个指针

                int min = nums[k] + nums[i] + nums[j] + nums[j + 1];
                if (min > target) continue;
                int max = nums[k] + nums[i] + nums[h] + nums[h - 1];
                if (max < target) continue;

                /*开始j指针和h指针的表演，计算当前和，如果等于目标值，j++并去重，h--并去重，当当前和大于目标值时h--，当当前和小于目标值时j++*/
                while (j < h) {
                    int curr = nums[k] + nums[i] + nums[j] + nums[h];
                    if (curr == target) {
                        result.add(Arrays.asList(nums[k], nums[i], nums[j], nums[h]));
                        j++;
                        while (j < h && nums[j] == nums[j - 1]) j++;
                        h--;
                        while (j < h && i < h && nums[h] == nums[h + 1]) h--;
                    } else if (curr > target) {
                        h--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return result;
    }
}
