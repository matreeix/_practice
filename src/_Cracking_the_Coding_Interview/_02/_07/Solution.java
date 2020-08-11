package _Cracking_the_Coding_Interview._02._07;

/**
 * @Description: 面试题 02.07. 链表相交
 * 给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，
 * 而不是基于节点的值。换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交。
 * @Author: caffebaby
 * @Date: 2020/7/31
 */

public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //长短比较法
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode a = headA;
        ListNode b = headB;
        while (a != null || b != null) {
            if (a != null) {
                a = a.next;
                lenA++;
            }
            if (b != null) {
                b = b.next;
                lenB++;
            }
        }
        int more = lenA > lenB ? lenA - lenB : lenB - lenA;
        ListNode max = lenA > lenB ? headA : headB;
        ListNode min = lenA > lenB ? headB : headA;
        while (more != 0) {
            max = max.next;
            more--;
        }
        while (max != min) {
            max = max.next;
            min = min.next;
        }
        return max;
    }

    //双指针法
    /**
     * 设链表A的长度为a，链表B的长度为b，A到相交结点的距离为c,B到相交节点的距离为d，显然可以得到两者相交链表的长度：a - c = b - d， 变换一下式子得到:a + d = b + c
     * 我们用一个指针从链表A出发，到末尾后就从B出发，用另一个指针从B出发，到末尾后从A出发，由于上面的公式，当前一个指针走了a+d步数时，后一个指针走了b+c,两步数相等，即走到了相交节点。
     *
     * */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode t1 = headA;
        ListNode t2 = headB;
        while (t1 != t2) {
            t1 = t1 != null ? t1.next : headB;
            t2 = t2 != null ? t2.next : headA;
        }
        return t2;
    }

    public static void main(String[] args) {

    }

}
