package _leetcode._CONTEST._biweekly._67;

import java.util.Arrays;

/**
 * @Description: 5934. 找到和最大的长度为 K 的子序列
 * 给你一个整数数组 nums 和一个整数 k 。你需要找到 nums 中长度为 k 的 子序列 ，且这个子序列的 和最大 。
 * 请你返回 任意 一个长度为 k 的整数子序列。
 * 子序列 定义为从一个数组里删除一些元素后，不改变剩下元素的顺序得到的数组。
 * 提示：
 * 1 <= nums.length <= 1000
 * -10^5 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 * @Date: 2021/12/11
 */

public class Solution1 {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        if (k == n) return nums;
        int[] res = new int[k];
        int[] idx = new int[k];
        int[] tmp = new int[n];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = (nums[i] + 100001) * 1001 + i;
        }
        Arrays.sort(tmp);
        for (int i = 0; i < k; i++) {
            idx[i] = tmp[n - k + i] % 1001;
        }
        Arrays.sort(idx);
        for (int i = 0; i < k; i++) {
            res[i] = nums[idx[i]];
        }
        return res;
    }

    public int[] maxSubsequence2(int[] nums, int k) {
        int n = nums.length;
        int[] index = new int[n];
        for (int i = 0; i < n; ++i) {
            index[i] = i;
        }

        // Use Quick Select to put the indexes of the
        // max k items to the left of index array.
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int idx = quickSelect(nums, index, lo, hi);
            if (idx < k) {
                lo = idx + 1;
            } else {
                hi = idx;
            }
        }

        // Count the occurrencs of the kth largest items
        // within the k largest ones.
        int kthVal = nums[index[k - 1]], freqOfkthVal = 0;
        for (int i : Arrays.copyOf(index, k)) {
            freqOfkthVal += nums[i] == kthVal ? 1 : 0;
        }

        // Greedily copy the subsequence into output array seq.
        int[] seq = new int[k];
        int i = 0;
        for (int num : nums) {
            if (num > kthVal || num == kthVal && freqOfkthVal-- > 0) {
                seq[i++] = num;
            }
        }
        return seq;
    }

    // Divide index[lo...hi] into two parts: larger and less than
    // the pivot; Then return the position of the pivot;
    private int quickSelect(int[] nums, int[] index, int lo, int hi) {
        int pivot = index[lo];
        while (lo < hi) {
            while (lo < hi && nums[index[hi]] <= nums[pivot]) {
                --hi;
            }
            index[lo] = index[hi];
            while (lo < hi && nums[index[lo]] >= nums[pivot]) {
                ++lo;
            }
            index[hi] = index[lo];
        }
        index[lo] = pivot;
        return lo;
    }
}
