package _CONTEST._weekly._200;

/**
 * @Description: 5478. 最大得分
 * 你有两个 有序 且数组内元素互 不相同 的数组 nums1 和 nums2 。
 * 一条 合法路径 定义如下：
 * 选择数组 nums1 或者 nums2 开始遍历（从下标 0 处开始）。
 * 从左到右遍历当前数组。
 * 如果你遇到了 nums1 和 nums2 中都存在的值，那么你可以切换路径到另一个数组对应数字处继续遍历（但在合法路径中重复数字只会被统计一次）。
 * 得分定义为合法路径中不同数字的和。
 * <p>
 * 请你返回所有可能合法路径中的最大得分。
 * <p>
 * 由于答案可能很大，请你将它对 10^9 + 7 取余后返回。
 * @Author: matreeix
 * @Date: 2020/8/2
 */

public class Solution4 {

    /**
     * 原理：在两数组中，相邻的相同元素组划分为一个区间，比较两区间的值谁更大就走大的那条路径即可
     */
    public static int maxSum(int[] nums1, int[] nums2) {
        long mod = 1000_000_007;
        int idx1 = 0, idx2 = 0;
        long res1 = 0, res2 = 0;
        long res = 0;
        while (idx1 < nums1.length || idx2 < nums2.length) {
            while (idx1 < nums1.length && idx2 < nums2.length && nums1[idx1] != nums2[idx2]) {
                if (nums1[idx1] < nums2[idx2]) {
                    res1 += nums1[idx1++];
                } else if (nums1[idx1] > nums2[idx2]) {
                    res2 += nums2[idx2++];
                }

                if (idx1 == nums1.length || idx2 == nums2.length) break;
            }

            if (idx1 == nums1.length) {
                while (idx2 < nums2.length)
                    res2 += nums2[idx2++];
            } else if (idx2 == nums2.length) {
                while (idx1 < nums1.length)
                    res1 += nums1[idx1++];
            } else if (nums1[idx1] == nums2[idx2]) {
                res += nums1[idx1];
            }

            //结算一段
            res += Math.max(res1, res2);
            res1 = 0L;
            res2 = 0L;
            idx1++;
            idx2++;
        }
        return (int) (res % mod);
    }

    //简写
    public int maxSum2(int[] A, int[] B) {
        int i = 0, j = 0, n = A.length, m = B.length;
        long resA = 0, resB = 0, res = 0, mod = (long) 1e9 + 7;
        while (i < n || j < m) {
            if (i < n && (j == m || A[i] < B[j])) {
                resA += A[i++];
            } else if (j < m && (i == n || A[i] > B[j])) {
                resB += B[j++];
            } else {//结算
                res += Math.max(resA, resB) + A[i];
                i++;
                j++;
                resA = 0;
                resB = 0;
            }
        }
        return (int) ((res + Math.max(resA, resB)) % mod);
    }

    public static void main(String[] args) {
        int[] nums11 = {2, 4, 5, 8, 10}, nums12 = {4, 6, 8, 9};//30
        int[] nums21 = {1, 3, 5, 7, 9}, nums22 = {3, 5, 100};//109
        int[] nums31 = {1, 2, 3, 4, 5}, nums32 = {6, 7, 8, 9, 10};//40
        int[] nums41 = {1, 4, 5, 8, 9, 11, 19}, nums42 = {2, 3, 4, 11, 12};//61
        int[] nums51 = {5, 9, 11, 15, 17, 25, 29}, nums52 = {6, 12, 15};//111

        System.out.println(maxSum(nums11, nums12));
        System.out.println(maxSum(nums21, nums22));
        System.out.println(maxSum(nums31, nums32));
        System.out.println(maxSum(nums41, nums42));
        System.out.println(maxSum(nums51, nums52));

    }
}
