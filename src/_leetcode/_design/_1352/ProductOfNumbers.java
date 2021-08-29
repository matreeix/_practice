package _leetcode._design._1352;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 1352. 最后 K 个数的乘积
 * 请你实现一个「数字乘积类」ProductOfNumbers，要求支持下述两种方法：
 * <p>
 * 1. add(int num)
 * <p>
 * 将数字 num 添加到当前数字列表的最后面。
 * 2. getProduct(int k)
 * <p>
 * 返回当前数字列表中，最后 k 个数字的乘积。
 * 你可以假设当前列表中始终 至少 包含 k 个数字。
 * 题目数据保证：任何时候，任一连续数字序列的乘积都在 32-bit 整数范围内，不会溢出。
 * @Date: 2021/8/28
 */

public class ProductOfNumbers {

    List<Integer> list;

    public ProductOfNumbers() {
        list = new ArrayList<>();
    }

    public void add(int num) {
        if (num == 0) {
            list.clear();
            return;
        }
        if (list.isEmpty()) {
            list.add(1);
        }
        list.add(list.get(list.size() - 1) * num);
    }

    public int getProduct(int k) {
        if (k >= list.size()) {
            return 0;
        }
        return list.get(list.size() - 1) / list.get(list.size() - 1 - k);
    }
}
