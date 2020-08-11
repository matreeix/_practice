package _Cracking_the_Coding_Interview._02._02;

/**
 * @Description: 面试题 02.02. 返回倒数第 k 个节点
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * @Author: caffebaby
 * @Date: 2020/7/31
 */

public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int kthToLast(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while (k>0){
            fast =fast.next;
            k-=1;
        }

        while (fast!=null){
            fast =fast.next;
            slow = slow.next;
        }
        return slow.val;
    }
}
