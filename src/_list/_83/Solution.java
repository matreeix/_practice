package _list._83;

/**
 * @Description: 从有序链表里删除多余的重复节点
 * @Author: caffebaby
 * @Date: 2019/8/13 23:21
 */
public class Solution {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        ListNode cur = prev.next;//存储不重复的节点
        while (cur != null) {
            int num = 0;
            ListNode p = cur;
            prev = prev.next;//先存一下当前的节点
            while (p != null && p.val == cur.val) {
                num++;
                p = p.next;
            }

            if (num > 1)
                prev.next = p;
            else
                prev = cur;
            cur = p;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(6);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

        System.out.println(deleteDuplicates(listNode1));
        System.out.println(deleteDuplicates(listNode1).next);
        System.out.println(deleteDuplicates(listNode1).next.next);
        System.out.println(deleteDuplicates(listNode1).next.next.next);
        System.out.println(deleteDuplicates(listNode1).next.next.next.next);

    }


}
