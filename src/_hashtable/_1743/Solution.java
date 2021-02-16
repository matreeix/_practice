package _hashtable._1743;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 1743. 从相邻元素对还原数组
 * 存在一个由 n 个不同元素组成的整数数组 nums ，但你已经记不清具体内容。好在你还记得 nums 中的每一对相邻元素。
 * 给你一个二维整数数组 adjacentPairs ，大小为 n - 1 ，其中每个 adjacentPairs[i] = [ui, vi] 表示元素 ui 和 vi 在 nums 中相邻。
 * 题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，存在形式可能是 [nums[i], nums[i+1]] ，也可能是 [nums[i+1], nums[i]] 。这些相邻元素对可以 按任意顺序 出现。
 * 返回 原始数组 nums 。如果存在多种解答，返回 其中任意一个 即可。
 * @Date: 2021/2/16
 */

public class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] a : adjacentPairs) {          //数据入表
            map.computeIfAbsent(a[0], k -> new ArrayList<>()).add(a[1]);
            map.computeIfAbsent(a[1], k -> new ArrayList<>()).add(a[0]);
        }
        int[] res = new int[adjacentPairs.length + 1];
        map.forEach((key, value) -> {//遍历找头
            if (value.size() == 1 && res[0] == res[1]) {//找到了并防止找到另一头
                res[0] = key;//前两个特殊值手动添加
                res[1] = value.get(0);
                for (int i = 2; i < res.length; i++) {//跟随指向持续Hash
                    int nextKey = map.get(res[i - 1]).get(0);//预设nextKey
                    res[i] = nextKey != res[i - 2] ? nextKey : map.get(res[i - 1]).get(1);//纠正反向nextKey
                }
            }
        });
        return res;
    }

    //妙啊！
    public int[] restoreArray2(int[][] p) {
        int n = p.length + 1, first = -1;
        int[] index = new int[200001];//记录相邻数字之和
        boolean[] exist = new boolean[200001];//记录是否是头/尾
        int[] res = new int[n];
        for (int i = 0; i < n - 1; i++) {
            index[p[i][0] + 100000] += p[i][1];
            index[p[i][1] + 100000] += p[i][0];
            //非头尾的数字都会出现两次，bool值遍历后不会改变
            exist[p[i][0] + 100000] = !exist[p[i][0] + 100000];
            exist[p[i][1] + 100000] = !exist[p[i][1] + 100000];
        }
        for (int i = 0; i <= 200000; i++)
            if (exist[i]) {
                first = i - 100000;
                break;
            }

        int i = 0, pre = 0;
        while (i < n) {
            res[i] = first;
            int next = index[first + 100000] - pre;
            pre = first;
            first = next;
            i++;
        }
        return res;
    }
}
