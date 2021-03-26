package _math._507;

/**
 * @Description: 507. 完美数
 * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 * 给定一个 整数 n， 如果是完美数，返回 true，否则返回 false
 * @Date: 2021/3/26
 */

public class Solution {

    //枚举法
    public boolean checkPerfectNumber(int num) {
        switch (num) {
            case 6:
            case 28:
            case 496:
            case 8128:
            case 33550336:
                return true;
        }
        return false;
    }

    public boolean checkPerfectNumber2(int num) {
        if (num == 1) return false;
        int sum = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                if (i != num / i)
                    sum += num / i;
            }
        }
        sum++;//加一
        return sum == num;
    }
}
