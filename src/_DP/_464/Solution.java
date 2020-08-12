package _DP._464;

/**
 * @Description:
 * @Author: matreeix
 * @Date: 2020/4/19
 */
public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true;
        int sum = maxChoosableInteger + 1;
        int res = desiredTotal / sum;


        return false;
    }

    public static void main(String[] args) {

    }
}
