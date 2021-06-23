package _leetcode._CONTEST._weekly._246;

/**
 * @Description: 1906. 查询差绝对值的最小值
 * 一个数组 a 的 差绝对值的最小值 定义为：0 <= i < j < a.length 且 a[i] != a[j] 的 |a[i] - a[j]| 的 最小值。如果 a 中所有元素都 相同 ，那么差绝对值的最小值为 -1 。
 * 比方说，数组 [5,2,3,7,2] 差绝对值的最小值是 |2 - 3| = 1 。注意答案不为 0 ，因为 a[i] 和 a[j] 必须不相等。
 * 给你一个整数数组 nums 和查询数组 queries ，其中 queries[i] = [li, ri] 。对于每个查询 i ，计算 子数组 nums[li...ri] 中 差绝对值的最小值 ，
 * 子数组 nums[li...ri] 包含 nums 数组（下标从 0 开始）中下标在 li 和 ri 之间的所有元素（包含 li 和 ri 在内）。
 * 请你返回 ans 数组，其中 ans[i] 是第 i 个查询的答案。
 * 子数组 是一个数组中连续的一段元素。
 * |x| 的值定义为：
 * 如果 x >= 0 ，那么值为 x 。
 * 如果 x < 0 ，那么值为 -x 。
 * 提示：
 * 2 <= nums.length <= 10^5
 * 1 <= nums[i] <= 100
 * 1 <= queries.length <= 2 * 10^4
 * 0 <= li < ri < nums.length
 * @Created by: matreeix
 * @Date: 2021/6/21
 */
public class Solution4 {
    public int[] minDifference(int[] nums, int[][] queries) {
        int len = nums.length;
        int[][] count = new int[len + 1][101];//count[i][c] 表示数组 nums 的前缀 idx[0..i−1] 中包含元素 c 的个数
        for (int i = 1; i <= len; i++) {
            /**
             * for(int j = 0; j < 100; ++j)
             *   count[i][j] = count[i-1][j];
             * */
            System.arraycopy(count[i - 1], 0, count[i], 0, 101);
            count[i][nums[i - 1]]++;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int last = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= 100; j++) {
                /**
                 * 对于任意的数组 a，如果 a 已经有序，那么我们只需要对 a 进行一次遍历，得到 a 中相邻两元素的差值中的最小值（不能为 0），
                 * 即为「差绝对值的最小值」。如果 a 中所有元素均相等，那么「差绝对值的最小值」为 −1。
                 * */
                if (count[end + 1][j] - count[start][j] > 0) {//num[start,end]包含元素j
                    if (last >= 0) min = Math.min(min, j - last);
                    last = j;
                }
            }
            ans[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return ans;
    }
}
