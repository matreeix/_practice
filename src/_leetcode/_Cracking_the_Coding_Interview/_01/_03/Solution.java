package _leetcode._Cracking_the_Coding_Interview._01._03;

/**
 * @Description: URL化
 * <p>
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，
 * 并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 * @Author: matreeix
 * @Date: 2020/6/29
 */

public class Solution {
    //调用JDK内置函数
    public String replaceSpaces(String S, int length) {
        return S.substring(0, length).replace(" ", "%20");
    }

    //遍历法
    public String replaceSpaces2(String S, int length) {
        char[] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < length) {
            if (chars[i] == ' ')
                sb.append("%20");
            else
                sb.append(chars[i]);
            i++;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "Mr John Smith    ";
        System.out.println(s.replaceSpaces2(str, 13));
    }

}
