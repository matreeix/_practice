package _CONTEST._weekly._222;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 5642. 大餐计数
 * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 * 你可以搭配 任意 两道餐品做一顿大餐。
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i​​​​​​​​​​​​​​ 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 109 + 7 取余。
 * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 * @Date: 2021/1/3
 */

public class Solution2 {
    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        for (int i = 0; i < deliciousness.length; ++i) {
            for (int j = 0; j < 22; ++j) {
                int target = (int) Math.pow(2, j);
                if (target - deliciousness[i] < 0) continue;
                if (map.containsKey(target - deliciousness[i])) {
                    ans += map.get(target - deliciousness[i]);
                }
            }
            map.put(deliciousness[i], map.getOrDefault(deliciousness[i], 0) + 1);
        }
        ans %= (1e9 + 7);
        return (int) ans;
    }
}







