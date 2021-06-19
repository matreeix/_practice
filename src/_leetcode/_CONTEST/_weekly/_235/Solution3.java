package _leetcode._CONTEST._weekly._235;

import java.util.Arrays;

/**
 * @Description: 5724. 绝对差值和
 * 给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
 * 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
 * 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
 * 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余 后返回。
 * |x| 定义为：
 * 如果 x >= 0 ，值为 x ，或者
 * 如果 x <= 0 ，值为 -x
 * <p>
 * 提示：
 * <p>
 * n == nums1.length
 * n == nums2.length
 * 1 <= n <= 10^5
 * 1 <= nums1[i], nums2[i] <= 10^5
 * @Date: 2021/4/4
 */

public class Solution3 {

    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int[] minDif = new int[nums1.length];//和nums2的最小差值
        int[] nums11 = Arrays.copyOf(nums1, nums1.length);
        Arrays.sort(nums11);
        for (int i = 0; i < minDif.length; i++) {
            minDif[i] = find(nums11, nums2[i]);
        }

        long sum = 0, maxdif = 0;
        for (int i = 0; i < nums1.length; i++) {
            int dif = Math.abs(nums1[i] - nums2[i]);
            maxdif = Math.max(maxdif, dif - minDif[i]);
            sum += dif;
        }
        return (int) ((sum - maxdif) % 1000000007);
    }

    //寻找与a最接近的数
    private static int find(int[] nums, int a) {
        int n = nums.length;
        if (a <= nums[0]) return nums[0] - a;
        if (a >= nums[n - 1]) return a - nums[n - 1];
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > a) r = mid - 1;
            else if (nums[mid] < a) l = mid + 1;
            else return 0;
        }
        return Math.min(Math.abs(nums[l] - a), Math.abs(nums[r] - a));
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 7, 10};
        System.out.println(find(arr, 0));
        System.out.println(find(arr, 9));//4
        System.out.println(find(arr, 2));//0
        System.out.println(find(arr, 5));//2
        System.out.println(find(arr, 6));//2
    }

}
