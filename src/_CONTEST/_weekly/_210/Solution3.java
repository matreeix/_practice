package _CONTEST._weekly._210;

/**
 * @Description: 1616. 分割两个字符串得到回文串
 * 给你两个字符串 a 和 b ，它们长度相同。请你选择一个下标，将两个字符串都在 相同的下标 分割开。由 a 可以得到两个字符串： aprefix 和 asuffix ，满足 a = aprefix + asuffix ，
 * 同理，由 b 可以得到两个字符串 bprefix 和 bsuffix ，满足 b = bprefix + bsuffix 。请你判断 aprefix + bsuffix 或者 bprefix + asuffix 能否构成回文串。
 * 当你将一个字符串 s 分割成 sprefix 和 ssuffix 时， ssuffix 或者 sprefix 可以为空。比方说， s = "abc" 那么 "" + "abc" ， "a" + "bc" ， "ab" + "c" 和 "abc" + "" 都是合法分割。
 * 如果 能构成回文字符串 ，那么请返回 true，否则返回 false 。
 * <p>
 * 请注意， x + y 表示连接字符串 x 和 y 。
 * @Author: matreeix
 * @Date: 2020/10/11
 */

public class Solution3 {
    public static boolean checkPalindromeFormation(String a, String b) {
        if (!checkOne(a, b) && !checkOne(b, a)) {
            a = new StringBuilder(a).reverse().toString();
            b = new StringBuilder(b).reverse().toString();
            return checkOne(a, b) || checkOne(b, a);
        }
        return true;
    }

    private static boolean checkOne(String a, String b) {//回文中心在字符串a上
        int n = a.length();
        if (n == 1) return true;
        boolean mark = false;
        for (int i = 0; i < n / 2; i++) {
            if ((a.charAt(i) == b.charAt(n - 1 - i) && !mark)) {
                continue;
            } else if (b.charAt(i) == b.charAt(n - 1 - i)) {
                mark = true;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPalindromeFormation("ulacfd", "jizalu"));
        System.out.println(checkPalindromeFormation("ucacfd", "jizalu"));
        System.out.println(checkPalindromeFormation("abccba", "jizalu"));
        System.out.println(checkPalindromeFormation("jizalu", "abccba"));
        System.out.println(checkPalindromeFormation("x", "y"));
        String a = "aejbaalflrmkswrydwdkdwdyrwskmrlfqizjezd";
        String b = "uvebspqckawkhbrtlqwblfwzfptanhiglaabjea";
        System.out.println(checkPalindromeFormation(a, b));
    }


}
