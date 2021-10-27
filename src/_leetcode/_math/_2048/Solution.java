package _leetcode._math._2048;

/**
 * @Description: 2048. 下一个更大的数值平衡数
 * 如果整数  x 满足：对于每个数位 d ，这个数位 恰好 在 x 中出现 d 次。那么整数 x 就是一个 数值平衡数 。
 * 给你一个整数 n ，请你返回 严格大于 n 的 最小数值平衡数 。
 * 提示：0 <= n <= 10^6
 * @Date: 2021/10/27
 */

// 打表法
public class Solution {
    public int nextBeautifulNumber(int n) {
        int[] cnt = {
                1,
                22,
                122, 212, 221, 333,
                1333, 3133, 3313, 3331, 4444,
                14444, 22333, 23233, 23323, 23332, 32233, 32323, 32332, 33223, 33232, 33322, 41444, 44144, 44414, 44441, 55555,
                122333, 123233, 123323, 123332, 132233, 132323, 132332, 133223, 133232, 133322, 155555,
                212333, 213233, 213323, 213332, 221333, 223133, 223313, 223331, 224444, 231233, 231323, 231332, 232133, 232313, 232331, 233123, 233132, 233213, 233231, 233312, 233321, 242444, 244244, 244424, 244442,
                312233, 312323, 312332, 313223, 313232, 313322, 321233, 321323, 321332, 322133, 322313, 322331, 323123, 323132, 323213, 323231, 323312, 323321, 331223, 331232, 331322, 332123, 332132, 332213, 332231, 332312, 332321, 333122, 333212, 333221,
                422444, 424244, 424424, 424442, 442244, 442424, 442442, 444224, 444242, 444422, 515555, 551555, 555155, 555515, 555551, 666666,
        };
        return binarySearch(n, cnt);
    }


    private int binarySearch(int n, int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] > n) {
                if (mid > 0 && arr[mid - 1] <= n) return arr[mid];
                r = mid;
            } else if (arr[mid] < n) {
                l = mid + 1;
            } else {
                return arr[mid + 1];
            }
        }
        return arr[l];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.nextBeautifulNumber(1));
        System.out.println(s.nextBeautifulNumber(1000));
        System.out.println(s.nextBeautifulNumber(3000));
        System.out.println(s.nextBeautifulNumber(212));
        System.out.println(s.nextBeautifulNumber(29160));
        System.out.println(s.nextBeautifulNumber(59866));
        System.out.println(s.nextBeautifulNumber(158682));
    }
}
