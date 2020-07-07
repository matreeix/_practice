package _string._830;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 较大分组的位置
 * <p>
 * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
 * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
 * 最终结果按照字典顺序输出。
 * @Author: Pythagodzilla
 * @Date: 2020/7/7
 */

public class Solution {
    //滑动窗口
    public static List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0, j = 0; i < S.length(); i = j) {
            while (j < S.length() && S.charAt(j) == S.charAt(i))
                j++;
            if (j - i >= 3)
                res.add(Arrays.asList(i, j - 1));
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "abcdddeeeeaabbbcdddddd";
        String s2 = "abc";
        String s3 = "aaa";

        System.out.println(largeGroupPositions(s1));
        System.out.println(largeGroupPositions(s2));
        System.out.println(largeGroupPositions(s3));
    }
}
