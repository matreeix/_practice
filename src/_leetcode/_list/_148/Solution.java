package _leetcode._list._148;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description: 对链表排序(归并排序)
 * @Author: matreeix
 * @Date: 2019/8/10 21:59
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //改变节点的引用
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

    //改变节点的值
    public static ListNode sortList2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        List<Integer> list = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            list.add(tmp.val);
            tmp = tmp.next;
        }
        Collections.sort(list);
        int index = 0;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        while (head != null) {
            head.val = list.get(index++);
            head = head.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode tmp = head;
        while (tmp != null) {
            System.out.print(tmp.val + "->");
            tmp = tmp.next;
        }

        ListNode tmp2 = sortList2(head);

        while (tmp2 != null) {
            System.out.print(tmp2.val + "->");
            tmp2 = tmp2.next;
        }


    }


}
