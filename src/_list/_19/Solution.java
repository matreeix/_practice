package _list._19;

/**
 * @Description: 删除链表的倒数第N个节点
 * @Author: Pythagodzilla
 * @Date: 2020/6/22
 */

public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //仅仅扫描一遍链表实现删除
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null)
            return null;

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode left = dummyHead;
        ListNode right = dummyHead;
        while (n > 0) {//两指针间隔为n
            right = right.next;
            n--;
        }

        while (right.next != null) {
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        Solution s = new Solution();
        ListNode res = s.removeNthFromEnd(head, 2);
        while (res != null) {
            System.out.print(res.val + "->");
            res = res.next;
        }
        System.out.println("null");
    }
}
