package _sort._324;

import java.util.Arrays;

/**
 * @Description: 摆动排序II
 * <p>
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * @Author: matreeix
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

    int n = -1;

    //快速选择+荷兰国旗，时间复杂度O(n)
    public void wiggleSort2(int[] nums) {
        //找到中位数索引
        int midIndex = this.quickSelect(nums, 0, nums.length - 1);
        //找到中位数
        int mid = nums[midIndex];
        n = nums.length;
        //三分法
        for (int i = 0, j = 0, k = nums.length - 1; j <= k; ) {
            if (nums[V(j)] > mid) {
                swap(nums, V(j++), V(i++));
            } else if (nums[V(j)] < mid) {
                swap(nums, V(j), V(k--));
            } else {
                j++;
            }
        }
    }

    public int V(int i) {
        return (1 + 2 * (i)) % (n | 1);
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    //类似于快排去找到中位数
    public int quickSelect(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left;
        int r = right;
        while (l < r) {
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            if (l < r) {
                nums[l++] = nums[r];
            }
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            if (l < r) {
                nums[r--] = nums[l];
            }
        }
        nums[l] = pivot;
        if (l == nums.length / 2) {
            return l;
        } else if (l > nums.length / 2) {
            return this.quickSelect(nums, left, l - 1);
        } else {
            return this.quickSelect(nums, l + 1, right);
        }
    }

    //最优解法
    public void wiggleSort3(int[] nums) {
        int[] array = new int[5000];
        for (int num : nums) {
            array[num]++;
        }
        int index = 4999;
        for (int i = 1; i < nums.length; i += 2) {
            while (index > 0) {
                if (array[index] > 0) {
                    break;
                } else {
                    index--;
                }
            }
            if (array[index] > 0) {
                nums[i] = index;
                array[index]--;
            }
        }
        for (int i = 0; i < nums.length; i += 2) {
            while (index > 0) {
                if (array[index] > 0) {
                    break;
                } else {
                    index--;
                }
            }
            if (array[index] > 0) {
                nums[i] = index;
                array[index]--;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 5, 1, 1, 6, 4};
        Solution s = new Solution();
        s.wiggleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
