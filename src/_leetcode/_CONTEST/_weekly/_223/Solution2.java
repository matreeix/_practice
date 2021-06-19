package _leetcode._CONTEST._weekly._223;

/**
 * @Description: 5652. 交换链表中的节点
 * 给你链表的头节点 head 和一个整数 k 。
 * 交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。
 * @Date: 2021/1/10
 */

public class Solution2 {
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

    public ListNode swapNodes(ListNode head, int k) {
        ListNode leftK = head, rightK = head, temp = null;
        while (k-- > 1) {
            leftK = leftK.next;
        }
        temp = leftK;
        while (temp.next != null) {
            rightK = rightK.next;
            temp = temp.next;
        }
        int val = leftK.val;
        leftK.val = rightK.val;
        rightK.val = val;
        return head;
    }


}
