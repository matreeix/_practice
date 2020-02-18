package _other._148;

/**
 * @Description: 对链表排序(归并排序)
 * @Author: 67ng
 * @Date: 2019/8/10 21:59
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;
        head = sortList(head);
        head2 = sortList(head2);
        return merge(head, head2);
    }

    private ListNode merge(ListNode a, ListNode b) {

        ListNode dummyHead = new ListNode(-1);
        ListNode p1 = a, p2 = b, p = dummyHead;
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


}
