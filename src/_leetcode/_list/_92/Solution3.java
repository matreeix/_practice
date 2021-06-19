package _leetcode._list._92;

/**
 * @Description: 使用迭代
 * @Author: matreeix
 * @Date: 2019/8/5 0:04
 */
public class Solution3 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 递归终止条件
        if (head == null || head.next == null)
            return head;

        ListNode rhead = reverseBetween(head.next, m, n);

        // head->next此刻指向head后面的链表的尾节点
        // head->next->next = head把head节点放在了尾部
        head.next.next = head;
        head.next = null;

        return rhead;
    }
}
