package _list._61;

import netscape.security.UserTarget;

/**
 * @Description: 旋转链表
 * <p>
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * @Author: caffebaby
 * @Date: 2020/6/23
 */

public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;
        int len = 1;
        ListNode tmp = head;
        while (tmp.next != null) {//tmp还可以保存尾节点
            tmp = tmp.next;
            len++;
        }
        if (k % len == 0)
            return head;
        k %= len;
        int step = len - k;
        ListNode index = head;
        while (step > 1) {//得到新头节点的前一个节点的指针
            index = index.next;
            step--;
        }
        ListNode newHead = index.next;
        index.next = null;
        tmp.next = head;
        return newHead;
    }

    //
    public ListNode rotateRight2(ListNode head, int k) {
        // base cases
        if (head == null) return null;
        if (head.next == null) return head;

        // close the linked list into the ring
        ListNode old_tail = head;
        int n;
        for (n = 1; old_tail.next != null; n++)
            old_tail = old_tail.next;
        old_tail.next = head;

        // find new tail : (n - k % n - 1)th node
        // and new head : (n - k % n)th node
        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++)
            new_tail = new_tail.next;
        ListNode new_head = new_tail.next;

        // break the ring
        new_tail.next = null;

        return new_head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Solution s = new Solution();
        ListNode res = s.rotateRight(head, 2);
        while (res != null) {
            System.out.print(res.val + "->");
            res = res.next;
        }
        System.out.println("null");
    }

}
