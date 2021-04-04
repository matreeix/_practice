package _CONTEST._weekly._235;

/**
 * @Description: 5725. 序列中不同最大公约数的数目
 * 给你一个由正整数组成的数组 nums 。
 * 数字序列的 最大公约数 定义为序列中所有整数的共有约数中的最大整数。
 * 例如，序列 [4,6,16] 的最大公约数是 2 。
 * 数组的一个 子序列 本质是一个序列，可以通过删除数组中的某些元素（或者不删除）得到。
 * 例如，[2,5,10] 是 [1,2,1,2,4,1,5,10] 的一个子序列。
 * 计算并返回 nums 的所有 非空 子序列中 不同 最大公约数的 数目 。
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 2 * 10^5
 * @Date: 2021/4/4
 */

public class Solution4 {
    //时间复杂度O(M * logM)
    public int countDifferentSubsequenceGCDs(int[] nums) {
        boolean[] mark = new boolean[200005];
        for (int x : nums) mark[x] = true;
        int ans = 0;
        for (int i = 1; i <= 200000; ++i) {//遍历所有可能的GCD
            int tmp = 0;
            for (int j = i; j <= 200000; j += i)//遍历所有可能的数组元素，其必然是i的倍数
                if (mark[j])
                    tmp = gcd(tmp, j);//子序列的GCD必然是两两GCD的约数
            if (tmp == i) ++ans;//存在子序列的最大公约数为i
        }
        return ans;
    }

    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }


}
