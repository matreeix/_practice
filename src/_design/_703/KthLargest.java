package _design._703;

import java.util.PriorityQueue;

/**
 * @Description: 703. 数据流中的第 K 大元素
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * <p>
 * 请实现 KthLargest 类：
 * <p>
 * 1.KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * 2.int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 * @Date: 2021/3/29
 */

public class KthLargest {
    private final PriorityQueue<Integer> q;
    private final int k;

    public KthLargest(int k, int[] a) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int n : a)
            add(n);
    }

    public int add(int n) {
        if (q.size() < k) {
            q.offer(n);
        } else if (q.peek() < n) {
            q.poll();
            q.offer(n);
        }
        return q.peek();
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 5, 8,};
        KthLargest k = new KthLargest(3, nums);
        System.out.println(k.add(3));// return 4
        System.out.println(k.add(5));// return 5
        System.out.println(k.add(10));// return 5
        System.out.println(k.add(9));// return 8
        System.out.println(k.add(4));// return 8
    }
}
