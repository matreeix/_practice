package _leetcode._CONTEST._biweekly._71;

/**
 * @Description: 2162. 设置时间的最少代价
 * 常见的微波炉可以设置加热时间，且加热时间满足以下条件：
 * 至少为 1 秒钟。
 * 至多为 99 分 99 秒。
 * 你可以 最多 输入 4 个数字 来设置加热时间。如果你输入的位数不足 4 位，微波炉会自动加 前缀 0 来补足 4 位。微波炉会将设置好的四位数中，前 两位当作分钟数，后 两位当作秒数。它们所表示的总时间就是加热时间。比方说：
 * <p>
 * 你输入 9 5 4 （三个数字），被自动补足为 0954 ，并表示 9 分 54 秒。
 * 你输入 0 0 0 8 （四个数字），表示 0 分 8 秒。
 * 你输入 8 0 9 0 ，表示 80 分 90 秒。
 * 你输入 8 1 3 0 ，表示 81 分 30 秒。
 * 给你整数 startAt ，moveCost ，pushCost 和 targetSeconds 。一开始，你的手指在数字 startAt 处。将手指移到 任何其他数字 ，需要花费 moveCost 的单位代价。每 输入你手指所在位置的数字一次，需要花费 pushCost 的单位代价。
 * 要设置 targetSeconds 秒的加热时间，可能会有多种设置方法。你想要知道这些方法中，总代价最小为多少。
 * 请你能返回设置 targetSeconds 秒钟加热时间需要花费的最少代价。
 * 请记住，虽然微波炉的秒数最多可以设置到 99 秒，但一分钟等于 60 秒。
 * 提示：
 * <p>
 * 0 <= startAt <= 9
 * 1 <= moveCost, pushCost <= 10^5
 * 1 <= targetSeconds <= 6039
 * @Date: 2022/2/7
 */

public class Solution3 {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int min1 = targetSeconds / 60, sec1 = targetSeconds % 60;
        int min2 = targetSeconds / 60 - 1, sec2 = targetSeconds % 60 + 60;
        if (min1 == 100) min1 = -1;
        if (sec2 > 99) sec2 = -1;
        int res1 = 0, res2 = 0;
        if (min1 >= 0 && sec1 >= 0) res1 = getCos(min1 * 100 + sec1, startAt, moveCost, pushCost);
        if (min2 >= 0 && sec2 >= 0) res2 = getCos(min2 * 100 + sec2, startAt, moveCost, pushCost);
        return res1 * res2 == 0 ? Math.max(res1, res2) : Math.min(res1, res2);
    }

    private int getCos(int num, int start, int moveCost, int pushCost) {
        int res = 0, cur = start;
        String s = Integer.toString(num);
        for (char ch : s.toCharArray()) {
            res += ch - '0' == cur ? pushCost : moveCost + pushCost;
            cur = ch - '0';
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println((new Solution3()).minCostSetTime(1, 2, 1, 600));//6
        System.out.println((new Solution3()).minCostSetTime(0, 1, 2, 76));//6
        System.out.println((new Solution3()).minCostSetTime(0, 1, 4, 9));//5
        System.out.println((new Solution3()).minCostSetTime(9, 100000, 1, 6039));//4
    }
}
