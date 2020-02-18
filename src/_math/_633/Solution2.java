package _math._633;

import java.util.HashSet;

/**
 * @description ：
 * @date ： 2020-02-18
 */
public class Solution2 {
    public boolean judgeSquareSum(int c) {
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i <= Math.sqrt(c); i++) {
            set.add(i * i);
            if (set.contains(c - i * i)) {
                return true;
            }
        }
        return false;
    }
}
