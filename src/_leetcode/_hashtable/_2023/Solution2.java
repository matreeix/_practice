package _leetcode._hashtable._2023;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 哈希表解法
 * @Date: 2021/11/11
 */

public class Solution2 {
    public int numOfPairs(String[] nums, String target) {
        int res = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        for (int i = 1; i < target.length(); i++) {
            String pre = target.substring(0, i);
            String suf = target.substring(i);
            if (map.containsKey(pre) && map.containsKey(suf)) {
                res += !pre.equals(suf) ? map.get(pre) * map.get(suf) : map.get(pre) * (map.get(suf) - 1);
            }
        }
        return res;
    }
}
