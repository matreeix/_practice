package _leetcode._array._888;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 888. 公平的糖果棒交换
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 * @Created by: matreeix
 * @Date: 2021/5/6
 */
public class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0, a = 0, b = 0;
        for (int i : A) sumA += i;
        for (int i : B) sumB += i;
        int diff = (sumA - sumB) / 2;
        Set<Integer> set = new HashSet<>();
        for (int i : A) set.add(i - diff);
        for (int i : B)
            if (set.contains(i)) {
                a = i + diff;
                b = i;
            }
        return new int[]{a, b};
    }
}
