package _list._237;

/**
 * @Description: 删除链表中的节点
 * <p>
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
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

    public void deleteNode(ListNode node) {
        node.val = node.next.val;//将要删除的节点的值改为和后继节点一样
        node.next = node.next.next;//删除后继节点即可
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Solution s = new Solution();
        s.deleteNode(head.next.next);

        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");


    }
}
