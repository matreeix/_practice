package _hashtable._575;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 575. 分糖果
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
 * @Date: 2021/3/27
 */

public class Solution {

    //map,13%
    public int distributeCandies(int[] candyType) {
        Set<Integer> map = new HashSet<>();
        int n = candyType.length;
        for (int i : candyType)
            map.add(i);
        if (map.size() >= n / 2)
            return n / 2;
        return map.size();
    }

    //排序,43.68%
    public int distributeCandies2(int[] candyType) {
        Arrays.sort(candyType);
        int cnt = 0;
        int n = candyType.length;
        for (int i = 1; i < candyType.length; i++)
            if (candyType[i] == candyType[i - 1]) continue;
            else cnt++;
        return Math.min(cnt + 1, n / 2);
    }

    //空间换时间
    public int distributeCandies3(int[] candyType) {
        boolean[] a = new boolean[200001];
        int halfLen = candyType.length / 2, count = 0, tmp;
        for (int c : candyType) {
            tmp = c + 100000;
            if (!a[tmp] ) {
                a[tmp] = true;
                count++;
                if (count >= halfLen) return halfLen;
            }
        }
        return count;
    }

}
