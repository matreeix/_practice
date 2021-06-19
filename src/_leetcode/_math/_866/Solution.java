package _leetcode._math._866;

/**
 * @Description:
 * @Author: matreeix
 * @Date: 2020/3/11
 */
public class Solution {
    public int primePalindrome(int N) {
        if (N < 2) return 2;
        int num = getPalindrome(N);
        while (!isPrime(num)) {
            num = getNext(num);
        }
        return num;
    }

    //通过回文数得到下一个回文数
    private int getNext(int palindrome) {
        String intStr = Integer.toString(palindrome);
        for (int i = 0; i < intStr.length(); i++) {//针对99,999特殊情况
            if (intStr.charAt(i) != '9') break;
            if (i == intStr.length() - 1)
                return Integer.parseInt(intStr) + 2;
        }
        String s = intStr.substring(0, intStr.length() % 2 == 0 ? intStr.length() / 2 : intStr.length() / 2 + 1);
        int subInt = Integer.parseInt(s) + 1;
        String res = subInt +
                new StringBuilder(Integer.toString(subInt))
                        .reverse().toString().substring(intStr.length() % 2 == 0 ? 0 : 1);
        return Integer.parseInt(res);
    }

    //判断是否是素数
    private boolean isPrime(int n) {
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    //得到不小于当前数的最小回文数
    private int getPalindrome(int N) {
        String s = Integer.toString(N);
        String subStr = s.substring(0, s.length() % 2 == 0 ? s.length() / 2 : s.length() / 2 + 1);
        String res = subStr + new StringBuilder(subStr)
                .reverse().toString().substring(s.length() % 2 == 0 ? 0 : 1);
        int minP = Integer.parseInt(res);
        if (N <= minP)
            return minP;
        return getNext(minP);
    }


    public static void main(String[] args) {//8,11;13,101
//        System.out.println(isPrime(21));
//        System.out.println(getNext(123454321));
//        System.out.println(getPalindrome(12345));
//        System.out.println(getPalindrome(1221));
        System.out.println((new Solution()).primePalindrome(6));
        System.out.println((new Solution()).primePalindrome(13));
        System.out.println((new Solution()).primePalindrome(8));
    }
}
