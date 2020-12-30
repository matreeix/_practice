package _CONTEST._biweekly._42;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 1703. 得到连续 K 个 1 的最少相邻交换次数
 * 给你一个整数数组 nums 和一个整数 k 。 nums 仅包含 0 和 1 。每一次移动，你可以选择 相邻 两个数字并将它们交换。
 * 请你返回使 nums 中包含 k 个 连续 1 的 最少 交换次数。
 * @Date: 2020/12/30
 */

public class Solution4 {
    public int minMoves1(int[] nums, int k) {
        if(k == 1)
            return 0;
        List<Integer> ones_indices = new ArrayList<>();
        for(int i = 0; i < nums.length; i++)
            if(nums[i] == 1)
                ones_indices.add(i);
        int totalOnes = ones_indices.size();
        List<Integer> pre_sum = new ArrayList<>(totalOnes);
        pre_sum.add(ones_indices.get(0));

        for(int i = 1; i < totalOnes; i++)
            pre_sum.add(ones_indices.get(i) + pre_sum.get(i-1));

        int ans = Integer.MAX_VALUE;

        for(int mid = (k-1)/2 ; mid < totalOnes - k/2; mid++) {
            int radius = (k-1)/2;
            int right = k%2 == 0 ? pre_sum.get(mid+radius+1) - pre_sum.get(mid) - ones_indices.get(mid) :       // even case
                    pre_sum.get(mid+radius) - pre_sum.get(mid);                                  // odd case
            int left =  (mid == 0 ? 0 : pre_sum.get(mid-1)) - (mid-radius == 0 ? 0 : pre_sum.get(mid-radius-1));
            int save = (radius+1)*radius + (k%2 == 0 ? radius+1 : 0);
            ans = Math.min(ans, right - left - save);
        }
        return ans;
    }

    public int minMoves(int[] nums, int k) {
        ArrayList<Long> A = new ArrayList<Long>(), B = new ArrayList<Long>();
        for (int i = 0; i < nums.length; ++i)
            if (nums[i] == 1)
                A.add((long)i);
        long res = Long.MAX_VALUE;
        B.add(0L);
        for (int i = 0; i < A.size(); ++i)
            B.add(B.get(i) + A.get(i));
        for (int i = 0; i <  A.size() - k + 1; ++i)
            res = Math.min(res, B.get(i + k) - B.get(k / 2 + i) - B.get((k + 1) / 2 + i) + B.get(i));
        res -= (k / 2) * ((k + 1) / 2);
        return (int)res;
    }
}
