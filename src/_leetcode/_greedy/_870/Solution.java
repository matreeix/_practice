package _leetcode._greedy._870;


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @Description: 870. 优势洗牌
 * 给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
 * 返回 A 的任意排列，使其相对于 B 的优势最大化。
 * @Date: 2021/3/17
 */

public class Solution {
    /**
     * 典型的贪心，每次在A中寻找大于B[i]的最小值，若没有，则返回A中的最小值。
     */

    //使用堆
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);//B降序
        for (int i = 0; i < B.length; i++)
            pq.add(new int[]{B[i], i});
        int lo = 0, hi = A.length - 1, res[] = new int[A.length];
        while (!pq.isEmpty())
            res[pq.peek()[1]] = pq.poll()[0] < A[hi] ? A[hi--] : A[lo++];
        return res;
    }

    //使用treemap
    public int[] advantageCount2(int[] A, int[] B) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int i : A) m.put(i, m.getOrDefault(i, 0) + 1);
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; ++i) {
            Integer x = m.higherKey(B[i]);
            if (x == null) x = m.firstKey();
            m.put(x, m.get(x) - 1);
            if (m.get(x) == 0) m.remove(x);
            res[i] = x;
        }
        return res;
    }

    //散列表，妙啊！！
    public int[] advantageCount3(int[] A, int[] B) {
        Arrays.sort(A);
        int len = A.length;
        int maxLen = 10000;
        long[] aux = new long[len];
        for (int i = 0; i < len; i++) {
            aux[i] = (long) B[i] * maxLen + i;//散列B的元素
        }
        Arrays.sort(aux);//将B从小到大排序，相同元素索引小的排前面
        int left = 0;
        int right = len - 1;
        for (int a : A) {
            if (a > aux[left] / maxLen) {//得到A中所有大于B某个元素的最小值
                B[(int) (aux[left++] % maxLen)] = a;
            } else {
                B[(int) (aux[right--] % maxLen)] = a;
            }
        }
        return B;
    }


}
