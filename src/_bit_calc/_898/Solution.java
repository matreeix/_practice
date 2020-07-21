package _bit_calc._898;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 898. 子数组按位或操作
 * 我们有一个非负整数数组 A。
 * 对于每个（连续的）子数组 B = [A[i], A[i+1], ..., A[j]] （ i <= j），
 * 我们对 B 中的每个元素进行按位或操作，获得结果 A[i] | A[i+1] | ... | A[j]。
 * 返回可能结果的数量。 （多次出现的结果在最终答案中仅计算一次。）
 * @Author: Pythagodzilla
 * @Date: 2020/7/21
 */

public class Solution {
    public static int subarrayBitwiseORs(int[] A) {
        Set<Integer> res = new HashSet<>(), set = new HashSet<>(), tmp;
        for (Integer i : A) {
            tmp = new HashSet<>();
            tmp.add(i);
            for (Integer j : set)
                tmp.add(i | j);
            set = tmp;
            res.addAll(tmp);
        }
        return res.size();
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2};
        int[] arr2 = {1, 2, 4};
        int[] arr3 = {0};
//
        System.out.println(subarrayBitwiseORs(arr1));//3
        System.out.println(subarrayBitwiseORs(arr2));//6
        System.out.println(subarrayBitwiseORs(arr3));//1

        Set<Integer> res = new HashSet<>(), set = new HashSet<>(), tmp = new HashSet<>();
        set.add(1);
        set.add(2);

        tmp.add(2);
        tmp.add(3);
        tmp.add(4);

        res.addAll(set=tmp);
        System.out.println(res);



    }
}
