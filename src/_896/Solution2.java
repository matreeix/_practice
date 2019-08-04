package _896;

/**
 * @Description:
 * @Author: 67ng
 * @Date: 2019/7/27 22:12
 */
public class Solution2 {
    public boolean isMonotonic(int[] A) {
        boolean inc = false, dec = false;
        for (int i = 1; i < A.length; i++) {//用A[i]A[i-1]时从1开始递增
            if (A[i] - A[i - 1] > 0) inc = true;
            if (A[i] - A[i - 1] < 0) dec = true;
            if (inc && dec) return false;
        }
        return true;
    }
}
