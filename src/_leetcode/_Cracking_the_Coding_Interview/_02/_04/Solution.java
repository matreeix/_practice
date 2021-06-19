package _leetcode._Cracking_the_Coding_Interview._02._04;

/**
 * @Description: 面试题 02.04. 分割链表
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。
 * 如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
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

    public ListNode partition(ListNode head, int x) {
        ListNode minHead = new ListNode(Integer.MIN_VALUE);
        ListNode min = minHead;
        ListNode maxHead = new ListNode(Integer.MAX_VALUE);
        ListNode max = maxHead;
        while (head != null) {
            if (head.val < x) {
                min.next = new ListNode(head.val);
                min = min.next;
            } else {
                max.next = new ListNode(head.val);
                max = max.next;
            }
            head = head.next;
        }
        min.next = maxHead.next;
        return minHead.next;
    }

    public static void main(String[] args) {

    }

}
