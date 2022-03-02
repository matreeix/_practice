package _leetcode._CONTEST._weekly._280;

/**
 * @Description: 2170. 使数组变成交替数组的最少操作数
 * 给你一个下标从 0 开始的数组 nums ，该数组由 n 个正整数组成。
 * 如果满足下述条件，则数组 nums 是一个 交替数组 ：
 * nums[i - 2] == nums[i] ，其中 2 <= i <= n - 1 。
 * nums[i - 1] != nums[i] ，其中 1 <= i <= n - 1 。
 * 在一步 操作 中，你可以选择下标 i 并将 nums[i] 更改 为 任一 正整数。
 * 返回使数组变成交替数组的 最少操作数 。
 * 提示：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 * @Date: 2022/2/15
 */

public class Solution2 {
    public int minimumOperations(int[] nums) {
        int[][] a = getFS(nums, 1);
        int[][] b = getFS(nums, 2);
        if (a[0][0] != b[0][0]) {
            return nums.length - a[0][1] - b[0][1];
        } else {
            return Math.min(nums.length - a[0][1] - b[1][1], nums.length - a[1][1] - b[0][1]);
        }
    }

    private int[][] getFS(int[] nums, int mark) {
        int idx = mark == 1 ? 0 : 1;
        int[] cnt = new int[100001];
        for (; idx < nums.length; idx += 2) cnt[nums[idx]]++;
        int F = 0, S = 0, cntF = 0, cntS = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > cntF) {
                S = F;
                cntS = cntF;
                F = i;
                cntF = cnt[i];
            } else if (cnt[i] > cntS) {
                S = i;
                cntS = cnt[i];
            }
        }
        return new int[][]{{F, cntF}, {S, cntS}};
    }
}
