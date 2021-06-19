package _leetcode._Cracking_the_Coding_Interview._02._06;

/**
 * @Description: 面试题 02.06. 回文链表
 * 编写一个函数，检查输入的链表是否是回文的。
 * @Author: matreeix
 * @Date: 2020/7/31
 */

public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        // 快慢指针找中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 反转后半部分
        ListNode pre = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        // 前后两段比较是否一致
        ListNode node = head;
        while (pre != null) {
            if (pre.val != node.val) {
                return false;
            }
            pre = pre.next;
            node = node.next;
        }
        return true;
    }

    private void reverseList(ListNode head, ListNode tail) {

    }

    public static void main(String[] args) {

    }

}
