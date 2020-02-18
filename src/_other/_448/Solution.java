package _other._448;

import java.util.ArrayList;
import java.util.List;

/*
 * @Description: 1<=nums[i]<=n,且元素最多重复一次，找出[1,n]中未出现的整数
 * @Author: 67ng
 * @Date: 2019/7/29 22:29
 */
public class Solution {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) nums[(nums[i] - 1) % n] += n;
        for (int i = 0; i < nums.length; i++) if (nums[i] <= n) res.add(i + 1);
        return res;
    }

    /**
     * 基本思想是我们遍历输入数组并将元素标记为否定使用
     * nums[nums[i] -1] = -nums[nums[i]-1]。通过这
     * 种方式，我们看到的所有数字都将标记为负数。在第二次
     * 迭代中，如果某个值未标记为负数，则表示我们之前从未
     * 见过该索引，因此只需将其添加到返回列表中即可。
     */
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> ret = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;//val的值是[0,n-1]的索引数组
            if (nums[val] > 0) {//索引为val的元素都标为负数，没标记的就是未出现过的索引
                nums[val] = -nums[val];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

    //将元素放到正确的位置
    public static List<Integer> findDisappearedNumbers3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //停止条件是某个元素被放在了正确的位置（nums[7]=8）或者nums[i] == nums[nums[i] - 1]无限相等交换
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];//将索引为i和nums[i]-1的元素交换
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers3(nums));
    }
}
