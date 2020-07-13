package _sort._179;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description: 将数组中的所有数字组合成最大的数
 * @Author: LeetCode@ran3
 * @Date: 2019/8/29 22:31
 */
public class Solution {

    //排序+比较器
    public String largestNumber(int[] num) {
        if (num == null || num.length == 0)
            return "";

        //将所有数字转为字符串
        String[] s_num = new String[num.length];
        for (int i = 0; i < num.length; i++)
            s_num[i] = String.valueOf(num[i]);

        // Comparator to decide which string should come first in concatenation
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1); // reverse order here, so we can do append() later
            }
        };

        Arrays.sort(s_num, comp);
        // An extreme edge case by lc, say you have only a bunch of 0 in your int array
        if (s_num[0].charAt(0) == '0')
            return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : s_num)
            sb.append(s);

        return sb.toString();

    }

    //简写
    public String largestNumber2(int[] num) {
        String[] array = Arrays.stream(num).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(array, (String s1, String s2) -> (s2 + s1).compareTo(s1 + s2));
        return Arrays.stream(array).reduce((x, y) -> x.equals("0") ? y : x + y).get();
    }

    //自己实现排序
    private boolean cmp(int a, int b) {
        long A = a * 10l, B = b * 10l;
        int a_ = a, b_ = b;
        while ((a_ /= 10) > 0) B *= 10;
        while ((b_ /= 10) > 0) A *= 10;
        return (A + b) > (B + a);
    }

    private void sort(int[] nums, int l, int r) {
        if (l >= r - 1) return;
        int m = l + (r - l) / 2;
        sort(nums, l, m);
        sort(nums, m, r);
        int[] aux = new int[r - l];
        for (int i = l, j = m, k = 0; i < m || j < r; ) {
            if (i < m && (j == r || cmp(nums[i], nums[j]))) aux[k++] = nums[i++];
            else if (j < r)
                aux[k++] = nums[j++];
        }
        for (int i = 0; l < r; ++i)
            nums[l++] = aux[i];
    }

    public String largestNumber3(int[] nums) {
        sort(nums, 0, nums.length);
        if (nums[0] == 0) return "0";
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < nums.length; ++i)
            res.append(nums[i]);
        return res.toString();
    }


}
