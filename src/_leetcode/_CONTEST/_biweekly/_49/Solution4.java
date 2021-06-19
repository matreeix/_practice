package _leetcode._CONTEST._biweekly._49;

/**
 * @Description: 5707. 得到新鲜甜甜圈的最多组数
 * 有一个甜甜圈商店，每批次都烤 batchSize 个甜甜圈。这个店铺有个规则，就是在烤一批新的甜甜圈时，之前 所有 甜甜圈都必须已经全部销售完毕。给你一个整数 batchSize 和一个整数数组 groups ，数组中的每个整数都代表一批前来购买甜甜圈的顾客，其中 groups[i] 表示这一批顾客的人数。每一位顾客都恰好只要一个甜甜圈。
 * 当有一批顾客来到商店时，他们所有人都必须在下一批顾客来之前购买完甜甜圈。如果一批顾客中第一位顾客得到的甜甜圈不是上一组剩下的，那么这一组人都会很开心。
 * 你可以随意安排每批顾客到来的顺序。请你返回在此前提下，最多 有多少组人会感到开心。
 * 提示：
 * <p>
 * 1 <= batchSize <= 9
 * 1 <= groups.length <= 30
 * 1 <= groups[i] <= 109
 * @Date: 2021/4/3
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 可以直接使用 1 << 30 表示状态，进行状态压缩的计算
 * 2. 超时
 * 3. 可以将状态转移到batchsize中进行考虑，可以优化部分时间复杂度
 * 4. 可以使用剪枝[使用cache来实现]，记录当前的cnt的状态对应的数组+preRemainder[如果cnt确定，preRemainder就确定了] and 当前的最大happy值
 * 5. 实现
 */
public class Solution4 {
    int b;

    public int maxHappyGroups(int _b, int[] groups) {
        b = _b;
        int[] cnt = new int[b];
        int ret = 0;
        int eleCnt = 0;
        for (int val : groups) {
            if (val % b == 0) {
                ret++;
            } else {
                cnt[val % b]++;
                eleCnt++;
            }
        }
        return ret + dfs(cnt, 0, eleCnt);
    }

    Map<String, Integer> cache = new HashMap<>();

    public int dfs(int[] cnt, int preRemainder, int eleCnt) {
        String val = Arrays.toString(cnt);
        if (cache.containsKey(val)) return cache.get(val);
        if (eleCnt == 0) return 0;
        int max = 0;
        for (int i = 1; i < b; i++) {
            if (cnt[i] == 0) continue;
            cnt[i]--;
            int happy = preRemainder == 0 ? 1 : 0;
            max = Math.max(max, dfs(cnt, (preRemainder + i) % b, eleCnt - 1) + happy);
            cnt[i]++;
        }
        cache.put(val, max);
        return max;
    }
}
