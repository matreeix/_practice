package _string._551;

/**
 * @Description: 学生出勤记录I
 * @Author: matreeix
 * @Date: 5/11/2020
 */
public class Solution {
    public boolean checkRecord(String s) {
        int absent = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A')
                absent++;
            if (absent > 1)
                return false;

            if (i <= s.length() - 3
                    && s.charAt(i) == 'L'
                    && s.charAt(i + 1) == 'L'
                    && s.charAt(i + 2) == 'L')
                return false;
        }
        return true;
    }
}
