package _leetcode._CONTEST._weekly._208;

/**
 * @Description: 5526. 最多可达成的换楼请求数目
 * 我们有 n 栋楼，编号从 0 到 n - 1 。每栋楼有若干员工。由于现在是换楼的季节，部分员工想要换一栋楼居住。
 * 给你一个数组 requests ，其中 requests[i] = [fromi, toi] ，表示一个员工请求从编号为 fromi 的楼搬到编号为 toi 的楼。
 * <p>
 * 一开始 所有楼都是满的，所以从请求列表中选出的若干个请求是可行的需要满足 每栋楼员工净变化为 0 。
 * 意思是每栋楼 离开 的员工数目 等于 该楼 搬入 的员工数数目。比方说 n = 3 且两个员工要离开楼 0 ，一个员工要离开楼 1 ，一个员工要离开楼 2 ，
 * 如果该请求列表可行，应该要有两个员工搬入楼 0 ，一个员工搬入楼 1 ，一个员工搬入楼 2 。
 * <p>
 * 请你从原请求列表中选出若干个请求，使得它们是一个可行的请求列表，并返回所有可行列表中最大请求数目。
 * <p>
 * 提示:
 * 1.1 <= n <= 20
 * 2.1 <= requests.length <= 16
 * 3.requests[i].length == 2
 * 4.0 <= fromi, toi < n
 * @Author: matreeix
 * @Date: 2020/9/27
 */

public class Solution4 {
    //暴力回溯解法,时间复杂度O(N * 2 ^ R)
    int max = 0;

    public int maximumRequests(int n, int[][] requests) {
        helper(requests, 0, new int[n], 0);
        return max;
    }

    private void helper(int[][] requests, int index, int[] count, int num) {
        // Traverse all n buildings to see if they are all 0. (means balanced)
        if (index == requests.length) {
            for (int i : count)
                if (0 != i)
                    return;

            max = Math.max(max, num);
            return;
        }
        // Choose this request
        count[requests[index][0]]++;
        count[requests[index][1]]--;
        helper(requests, index + 1, count, num + 1);
        count[requests[index][0]]--;
        count[requests[index][1]]++;

        // Not Choose the request
        helper(requests, index + 1, count, num);
    }
}
