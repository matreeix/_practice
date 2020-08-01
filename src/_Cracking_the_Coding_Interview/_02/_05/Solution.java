package _Cracking_the_Coding_Interview._02._05;

/**
 * @Description: 面试题 02.05. 链表求和
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * 这些数位是 反向 存放的，也就是个位排在链表首部。
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 * @Author: Pythagodzilla
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        int carry = 0, res = 0;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            res = (a + b + carry) % 10;
            carry = (a + b + carry) / 10;
            cur.next = new ListNode(res);
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            cur = cur.next;
        }
        if (carry == 1)
            cur.next = new ListNode(1);
        return dummyHead.next;
    }

    public static void main(String[] args) {

    }

}
