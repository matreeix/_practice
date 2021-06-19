package _leetcode._CONTEST._weekly._203;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @Description: 5497. 查找大小为 M 的最新分组
 * 给你一个数组 arr ，该数组表示一个从 1 到 n 的数字排列。有一个长度为 n 的二进制字符串，该字符串上的所有位最初都设置为 0 。
 * 在从 1 到 n 的每个步骤 i 中（假设二进制字符串和 arr 都是从 1 开始索引的情况下），位于位置 arr[i] 的位将会设为 1 。
 * 给你一个整数 m ，请你找出存在长度为 m 的一组 1 的最后步骤。一组 1 是一个连续的、由 1 组成的子串，且左右两边不再有可以延伸的 1 。
 * 返回存在长度 恰好 为 m 的 一组 1  的最后步骤。如果不存在这样的步骤，请返回 -1 。
 * <p>
 * 示例：
 * 输入：arr = [3,5,1,2,4], m = 1
 * 输出：4
 * 解释：
 * 步骤 1："00100"，由 1 构成的组：["1"]
 * 步骤 2："00101"，由 1 构成的组：["1", "1"]
 * 步骤 3："10101"，由 1 构成的组：["1", "1", "1"]
 * 步骤 4："11101"，由 1 构成的组：["111", "1"]
 * 步骤 5："11111"，由 1 构成的组：["11111"]
 * 存在长度为 1 的一组 1 的最后步骤是步骤 4 。
 * @Author: matreeix
 * @Date: 2020/8/23
 */

public class Solution3 {
    //LTE
    public static int findLatestStep(int[] arr, int m) {
        int len = arr.length;
        if (len == 1 || m == len) return len;
        Map<Integer, Integer> map = new HashMap<>();//<start,len>
        map.put(1, len);
        int cnt = 0;//统计操作次数
        for (int i = len - 1; i > 0; i--) {
            int start = -1;
            for (int idx : map.keySet())
                if (idx <= arr[i] && arr[i] < idx + map.get(idx)) {
                    start = idx;
                    break;
                }
            map.put(arr[i] + 1, start + map.get(start) - arr[i] - 1);
            map.put(start, arr[i] - start);
            cnt++;
            if (map.get(start) == m || map.get(arr[i] + 1) == m) return len - cnt;
        }
        return -1;
    }

    //大佬解法
    public static int findLatestStep2(int[] A, int m) {
        int res = -1, n = A.length;
        int[] length = new int[n + 2], count = new int[n + 1];//统计长度
        for (int i = 0; i < n; ++i) {
            int a = A[i], left = length[a - 1], right = length[a + 1];
            length[a] = length[a - left] = length[a + right] = left + right + 1;
            count[left]--;
            count[right]--;
            count[length[a]]++;
            if (count[m] > 0)
                res = i + 1;
        }
        return res;
    }

    //使用treeSet
    public int findLatestStep3(int[] arr, int m) {
        TreeSet<Integer> set = new TreeSet<>();
        //添加初始值，防止空指针
        set.add(0);
        set.add(arr.length + 1);
        if (arr.length == m) return arr.length;
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            int index = arr[i];
            int a = set.lower(index);//返回严格小于给定键的最大键
            int b = set.higher(index);
            if (index - a - 1 == m || b - index - 1 == m)
                return i;
            set.add(index);
        }
        return -1;
    }


    public static void main(String[] args) {
        int arr1[] = {3, 5, 1, 2, 4}, m1 = 1;
        int arr2[] = {3, 1, 5, 4, 2}, m2 = 2;

        System.out.println(findLatestStep2(arr1, m1));//4
        System.out.println(findLatestStep2(arr2, m2));//-1
    }
}
