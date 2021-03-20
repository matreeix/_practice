package _math._906;

/**
 * @Description: 构造法
 * @Date: 2021/3/19
 */

public class Solution2 {

    //O(len ^ (1/4) * log len)
    public int superpalindromesInRange(String left, String right) {
        long L = Long.parseLong(left);
        long R = Long.parseLong(right);
        int MAGIC = 100000;//回文数的一半的最大值
        int ans = 0;

        //统计奇回文
        for (int k = 1; k < MAGIC; ++k) {
            StringBuilder sb = new StringBuilder(Integer.toString(k));
            for (int i = sb.length() - 2; i >= 0; --i)
                sb.append(sb.charAt(i));
            long v = Long.parseLong(sb.toString());
            v *= v;
            if (v > R) break;
            if (v >= L && isPalindrome(v)) ans++;
        }

        //统计偶回文
        for (int k = 1; k < MAGIC; ++k) {
            StringBuilder sb = new StringBuilder(Integer.toString(k));
            for (int i = sb.length() - 1; i >= 0; --i)
                sb.append(sb.charAt(i));
            long v = Long.parseLong(sb.toString());
            v *= v;
            if (v > R) break;
            if (v >= L && isPalindrome(v)) ans++;
        }
        return ans;
    }

    private boolean isPalindrome(long num) {
        long tmp = num;
        long reverse = 0;
        while (tmp > 0) {//翻转数字
            reverse = reverse * 10 + tmp % 10;
            tmp = tmp / 10;
        }
        return reverse == num;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.superpalindromesInRange("1","213"));
    }

}
