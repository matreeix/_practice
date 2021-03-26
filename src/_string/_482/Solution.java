package _string._482;

/**
 * @Description: 482. 密钥格式化
 * 有一个密钥字符串 S ，只包含字母，数字以及 '-'（破折号）。其中， N 个 '-' 将字符串分成了 N+1 组。
 * 给你一个数字 K，请你重新格式化字符串，使每个分组恰好包含 K 个字符。特别地，第一个分组包含的字符个数必须小于等于 K，但至少要包含 1 个字符。两个分组之间需要用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。
 * 给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。
 * @Date: 2021/3/26
 */

public class Solution {

    public static String licenseKeyFormatting(String S, int K) {
        S = S.toUpperCase();
        StringBuilder sb = new StringBuilder();
        int mark = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == '-') continue;
            sb.append(S.charAt(i));
            if (++mark % K == 0)
                sb.append('-');
        }
        String res = sb.reverse().toString();
        if (res.length() > 0 && res.charAt(0) == '-') return res.substring(1);
        return res;
    }

    public String licenseKeyFormatting2(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            if (s.charAt(i) != '-')
                sb.append(sb.length() % (k + 1) == k ? '-' : "").append(s.charAt(i));
        return sb.reverse().toString().toUpperCase();
    }

    public static void main(String[] args) {
        String s1 = "5F3Z-2e-9-w";
        String s2 = "2-5g-3-J";
        String s3 = "--a-a-a-a--";
        String s4 = "---";
        System.out.println(licenseKeyFormatting(s1, 4));
        System.out.println(licenseKeyFormatting(s2, 2));
        System.out.println(licenseKeyFormatting(s3, 2));
        System.out.println(licenseKeyFormatting(s4, 3));
    }
}
