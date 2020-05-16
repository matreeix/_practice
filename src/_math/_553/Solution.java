package _math._553;

/**
 * @Description: 最优除法
 * @Author: 67ng
 * @Date: 2020/5/16
 */
public class Solution {
    public String optimalDivision(int[] nums) {
        if (nums.length == 1)
            return nums[0] + "";
        if (nums.length == 2)
            return nums[0] + "/" + nums[1];
        StringBuilder res = new StringBuilder(nums[0] + "/(" + nums[1]);
        for (int i = 2; i < nums.length; i++) {
            res.append("/" + nums[i]);
        }
        res.append(")");
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1000, 100, 10, 2};
        System.out.println((new Solution()).optimalDivision(nums));
    }

}
