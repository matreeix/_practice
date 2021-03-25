package _string._459;

/**
 * @Description: 459. 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * @Date: 2021/3/25
 */

public class Solution {
    //掐头去尾拼接法
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).substring(1, s.length() * 2 - 1).contains(s);
    }

    public boolean repeatedSubstringPattern2(String s) {
        int len = s.length(), parts = 2, cur = len;//子串的长度
        while (cur > 1) {
            if (cur % parts == 0) {
                int k = len / parts;
                if (s.substring(0, len - k).equals(s.substring(k))) return true;
                while ((cur /= parts) % parts == 0) ;
            }
            parts++;//段数
        }
        return false;
    }

}
