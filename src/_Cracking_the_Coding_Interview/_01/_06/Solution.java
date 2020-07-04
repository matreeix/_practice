package _Cracking_the_Coding_Interview._01._06;

/**
 * @Description: 字符串压缩
 * <p>
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，
 * 则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 * @Author: Pythagodzilla
 * @Date: 2020/7/4
 */

public class Solution {
    public String compressString(String S) {
        if (S.length() == 0) return S; // 空串处理
        String ans = "";
        int cnt = 1;
        char ch = S.charAt(0);
        for (int i = 1; i < (int) S.length(); ++i) {
            if (ch == S.charAt(i)) {
                cnt++;
            } else {
                ans += ch + "" + cnt; // 注意 cnt 要转为字符串
                ch = S.charAt(i);
                cnt = 1;
            }
        }
        ans += ch + "" + cnt;
        return ans.length() >= S.length() ? S : ans;
    }

    public String compressString2(String S) {
        if (S == null | S.length() <= 0) {
            return S;
        }

        StringBuilder sb = new StringBuilder();
        char[] arr = S.toCharArray();
        char curr = arr[0];
        int start = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] != curr) {
                sb.append(curr);
                sb.append(i - start);

                curr = arr[i];
                start = i;
            }
        }
        sb.append(curr);
        sb.append(len - start);

        if (sb.length() >= len) {
            return S;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "aabcccccaaa";
        String s2 = "abbccd";
        Solution solution = new Solution();
        System.out.println(solution.compressString(s1));
        System.out.println(solution.compressString(s2));
        System.out.println('A' + 0);
        System.out.println('Z' + 0);
        System.out.println('a' + 0);
        System.out.println('z' + 0);
    }
}
