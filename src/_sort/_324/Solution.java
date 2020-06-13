package _sort._324;

import java.util.Arrays;

/**
 * @Description: 摆动排序II
 * <p>
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * @Author: 67ng
 * @Date: 2020/6/13
 */
public class Solution {

    //排序，时间复杂度O(nlogn),空间复杂度O（n）
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        Arrays.sort(nums);
        int[] B = new int[nums.length / 2];//储存较大元素
        int[] A = new int[nums.length - B.length];//储存较小元素
        for (int i = 0; i < A.length; i++) {
            A[i] = nums[i];
        }

        for (int i = A.length; i < nums.length; i++) {
            B[i - A.length] = nums[i];
        }

        //主要是防止有一个元素的个数刚好为总个数的一半，超过的话就无解了
        reverse(B);
        reverse(A);
        for (int i = 0; i < nums.length; i++) {//交叉赋值
            nums[i] = i % 2 == 0 ? A[i / 2] : B[i / 2];
        }
    }

    private void reverse(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int i = 0;
        while (i < arr.length / 2) {
            int tmp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = tmp;
            i++;
        }
    }

    public void wiggleSort2(int[] nums) {
//        int len = nums.length;
//
//        // Find a median.
//        auto midptr = nums.begin() + len / 2;
//        nth_element(nums.begin(), midptr, nums.end());
//        int mid = *midptr;
//
//        // Index-rewiring.
//        int A (i) = nums[(1 + 2 * (i)) % (len | 1)];
//
//        // 3-way-partition-to-wiggly in O(n) time with O(1) space.
//        int i = 0, j = 0, k = len - 1;
//        while (j <= k) {
//            if (A(j) > mid)
//                swap(A(i++), A(j++));
//            else if (A(j) < mid)
//                swap(A(j), A(k--));
//            else
//                j++;
//        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 5, 1, 1, 6, 4};
        Solution s = new Solution();
        s.wiggleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
