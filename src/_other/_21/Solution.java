package _other._21;

/**
 * @Description: 归并两个有序链表
 * @Author: 67ng
 * @Date: 2019/8/10 21:55
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "[" + val + "]" ;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p1 = l1, p2 = l2, p = dummyHead;
        while (p1 != null && p2 != null)
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
                p = p.next;
                p.next = null;
            } else {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
                p.next = null;
            }
        if (p1 != null) p.next = p1;
        if (p2 != null) p.next = p2;

        ListNode ret = dummyHead.next;
        return ret;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(5);
        ListNode listNode7 = new ListNode(6);

        listNode1.next = listNode3;
        listNode3.next = listNode5;

        listNode2.next = listNode4;
        listNode4.next = listNode6;
        listNode6.next = listNode7;

        System.out.println(mergeTwoLists(listNode1, listNode2));
    }


}
