package _DP._303;

/**
 * @Description:
 * @Author: matreeix
 * @Date: 2020/3/17
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(arr);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));

    }

    static class NumArray {

        int[] nums;

        public NumArray(int[] nums) {
            for(int i = 1; i < nums.length; i++)
                nums[i] += nums[i - 1];

            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            if(i == 0)
                return nums[j];

            return nums[j] - nums[i - 1];
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
}


