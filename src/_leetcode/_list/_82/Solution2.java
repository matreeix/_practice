package _leetcode._list._82;

/**
 * @Description: 递归求解
 * @Author: matreeix
 * @Date: 2019/8/14 20:35
 */
public class Solution2 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }


}
