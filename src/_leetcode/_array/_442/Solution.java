package _leetcode._array._442;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 442. 数组中重复的数据
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 * 找到所有出现两次的元素。
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 * @Created by: matreeix
 * @Date: 2021/5/2
 */
public class Solution {
    //空间O（1），时间O（n）
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        if (n == 1) return res;
        for(int i = 0; i < n; i++){
            nums[(nums[i] - 1) % n] += n;//这个取余妙啊！
        }
        for(int i = 0; i < n; i++){
            if(nums[i] > 2 * n) res.add(i+1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 4, 7, 8};
        System.out.println((new Solution()).findDuplicates(nums));
    }

}
