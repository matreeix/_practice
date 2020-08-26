package _list._82;

/**
 * @Description: 从有序链表里删除重复的节点
 * @Author: matreeix
 * @Date: 2019/8/14 20:17
 */
public class Solution {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        ListNode cur = prev.next;//存储不重复的节点
        while (cur != null) {
            int num = 0;
            ListNode p = cur;
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
}



