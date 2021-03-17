package _greedy._870;


import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Description: 870. 优势洗牌
 * 给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
 * 返回 A 的任意排列，使其相对于 B 的优势最大化。
 * @Date: 2021/3/17
 */

public class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->b[0]-a[0]);
        for (int i=0; i<B.length; i++) pq.add(new int[]{B[i], i});
        int lo=0, hi=A.length-1, res[] = new int[A.length];
        while(!pq.isEmpty()) res[pq.peek()[1]]=pq.poll()[0]<A[hi]?A[hi--]:A[lo++];
        return res;
    }


}
