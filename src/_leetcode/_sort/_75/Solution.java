package _leetcode._sort._75;

import java.util.Arrays;

/**
 * @Description: 颜色分类(荷兰国旗问题)
 * <p>
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * @Author: matreeix
 * @Date: 2020/6/12
 */
public class Solution {
    //荷兰三色旗问题解
    public void sortColors(int[] nums) {

        int L = 0;//记录0的右边界
        int curr = 0;//从左到右扫描指针
        int R = nums.length - 1;//记录2的左边界
        int tmp;
        while (curr <= R) {
            if (nums[curr] == 0) {
                // 交换第 L个和第curr个元素
                // i++，j++
                tmp = nums[L];
                nums[L++] = nums[curr];
                nums[curr++] = tmp;
            } else if (nums[curr] == 2) {
                // 交换第R个和第curr个元素
                // R--
                tmp = nums[curr];
                nums[curr] = nums[R];
                nums[R--] = tmp;
            } else {
                curr++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        (new Solution()).sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}
