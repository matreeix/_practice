package _leetcode._list._445;

import java.util.Stack;

/**
 * @Description: 445. 两数相加 II
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * @Date: 2021/7/22
 */

public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        int l1 = getLen(node1);
        int l2 = getLen(node2);
        Stack<Integer> stack = new Stack<>();
        while (l1 > 0 && l2 > 0) {
            if (l1 > l2) {
                stack.add(node1.val);
                node1 = node1.next;
                l1--;
            } else if (l2 > l1) {
                stack.add(node2.val);
                node2 = node2.next;
                l2--;
            } else {
                int sum = node1.val + node2.val;
                if (sum >= 10) {
                    if (stack.isEmpty()) {
                        stack.add(1);
                    } else {
                        stack.add(stack.pop() + 1);
                    }
                }
                stack.add(sum % 10);
                node1 = node1.next;
                node2 = node2.next;
                l1--;
                l2--;
            }
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        while (!stack.isEmpty()) {
            ListNode tmp = new ListNode(stack.pop());
            dummyHead.next = tmp;
            tmp.next = pre;
            pre = tmp;
        }
        return dummyHead.next;
    }

    private int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(7);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(4);
        node1.next.next.next = new ListNode(3);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);
        Solution s = new Solution();
        System.out.println(s.addTwoNumbers(node1, node2));
    }
}
