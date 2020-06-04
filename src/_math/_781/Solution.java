package _math._781;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 森林中的兔子数量
 * <p>
 * 思路：
 * 1.相同数字（num）的元素可归为一类，且该类颜色的兔子数量为 1+num;
 * 2.根据1，若有相同数字的元素个数大于1+num,则要划分为两类或者更多类别;
 * 3.根据1，元素个数小于等于1，不足的元素个数要补足
 * @Author: 67ng
 * @Date: 2020/6/4
 */
public class Solution {
    public static int numRabbits(int[] answers) {
        if (answers == null || answers.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();//Map<颜色，统计次数>
        for (int i : answers) {
            if (map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else
                map.put(i, 1);
        }
        int res = 0;
        for (int key : map.keySet()) {
            if (map.get(key) <= key + 1) {
                res += key + 1;
            } else {//有多种颜色同数量
                if (map.get(key) % (key + 1) == 0) {
                    res += map.get(key);
                } else {
                    res += (key + 1) * (map.get(key) / (key + 1) + 1);
                }
            }
        }
        return res;
    }

    //妙啊！
    public int numRabbits2(int[] answers) {
        int[] record = new int[1000];//类似于map
        int res = 0;
        for (int ans : answers) {
            if (record[ans] == 0 || ans == 0) {
                res += ans + 1;
                record[ans] = ans;//颜色不同的兔子有相同的数量
            } else {
                record[ans]--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {10, 10, 10};
        int[] nums3 = {};
        int[] nums4 = {1, 0, 1, 0, 0};
        int[] nums5 = {0, 1, 0, 2, 0, 1, 0, 2, 1, 1};
        System.out.println(numRabbits(nums1));//5
        System.out.println(numRabbits(nums2));//11
        System.out.println(numRabbits(nums3));//0
        System.out.println(numRabbits(nums4));//5
        System.out.println(numRabbits(nums5));//11

    }
}
