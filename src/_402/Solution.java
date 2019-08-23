package _402;

/**
 * @Description:
 * @Author: 67ng
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
