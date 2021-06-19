package _leetcode._greedy._402;

/**
 * @Description: 402. 移掉K位数字
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * 注意:
 * 1.num 的长度小于 10002 且 ≥ k。
 * 2.num 不会包含任何前导零。
 * @Author: matreeix
 * @Date: 2019/8/21 21:27
 */
public class Solution {

    public static String removeKdigits(String num, int k) {
        int count = 0;
        for (char ch : num.toCharArray()) {
            if (ch == '0') count++;
        }
        if (k >= num.length() - count) return "0";

        while (k > 0) {
            num = deleteOne(num);
            k--;
        }
        return num;
    }

    public static String deleteOne(String num) {
        int i = 1;
        int tmp = -1;
        while (i < num.length()) {
            if (num.charAt(i - 1) > num.charAt(i)) {
                tmp = i - 1;
                break;
            }
            i++;
        }
        tmp = tmp == -1 ? num.length() - 1 : tmp;
        String str1 = num.substring(0, tmp);
        String str2 = num.substring(tmp + 1);
        String res = str1 + str2;
        int index = 0;
        while (index < res.length()) {
            if (res.charAt(index) != '0') {
                break;
            }
            index++;
        }
        return res.substring(index);
    }


}
