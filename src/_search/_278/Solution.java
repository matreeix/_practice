package _search._278;

/**
 * @Description: 第一个错误的版本
 * @Author: Pythagodzilla
 * @Date: 2020/6/22
 */

public class Solution {
    private boolean isBadVersion(int version) {
        if (version >= 5)//第十个版本开始是错误的
            return true;
        else
            return false;
    }

    public int firstBadVersion(int n) {
        return binarySearch(1, n);
    }

    private int binarySearch(int l, int r) {
        if (l > r)
            return -1;
        int mid = l + (r - l) / 2;
        if (isBadVersion(mid) == true && isBadVersion(mid - 1) == false)
            return mid;
        else if (isBadVersion(mid) == true && isBadVersion(mid - 1) == true)
            return binarySearch(l, mid - 1);
        else
            return binarySearch(mid + 1, r);
    }

    // 最优解法，迭代法，time: O(log n), space: O(1)
    public int firstBadVersion2(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.firstBadVersion(1234));
    }
}
