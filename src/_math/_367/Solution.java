package _math._367;

/**
 * @description ：判断平方数
 * 注意：小心整型溢出，可以直接用long来存储mid
 * @date ： 2020-02-18
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        return search(1, num, num);
    }
    public boolean search(int left, int right, int num) {
        if (left > right)
            return false;
        int mid = (right - left) / 2 + left;

        if (num > mid * mid  && mid < 46341) {//46340是不大于最大整型的最大平方根数
            return search(mid + 1, right, num);
        } else if (mid >= 46341 || num < mid * mid) {
            return search(left, mid - 1, num);
        } else {
            return true;
        }
    }

}
