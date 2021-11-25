package _leetcode._CONTEST._weekly._268;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Description: 5186. 区间内查询数字的频率
 * 请你设计一个数据结构，它能求出给定子数组内一个给定值的 频率 。
 * 子数组中一个值的 频率 指的是这个子数组中这个值的出现次数。
 * 请你实现 RangeFreqQuery 类：
 * RangeFreqQuery(int[] arr) 用下标从 0 开始的整数数组 arr 构造一个类的实例。
 * int query(int left, int right, int value) 返回子数组 arr[left...right] 中 value 的 频率 。
 * 一个 子数组 指的是数组中一段连续的元素。arr[left...right] 指的是 nums 中包含下标 left 和 right 在内 的中间一段连续元素。
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i], value <= 10^4
 * 0 <= left <= right < arr.length
 * 调用 query 不超过 10^5 次。
 * @Date: 2021/11/21
 */

public class RangeFreqQuery {
    Map<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();
    public RangeFreqQuery(int[] arr) {
        for(int i = 0; i < arr.length;i++){
            map.putIfAbsent(arr[i], new TreeMap<>());
            map.get(arr[i]).put(i, map.get(arr[i]).size());// 频率前缀和
        }
    }

    public int query(int left, int right, int value) {
        if(!map.containsKey(value)) return 0;
        TreeMap<Integer, Integer> nums = map.get(value);
        Integer a = nums.ceilingKey(left), b = nums.floorKey(right);
        if(a == null || b == null) return 0;
        return nums.get(b) - nums.get(a) +1;
    }
}
