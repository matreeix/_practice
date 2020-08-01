package _Cracking_the_Coding_Interview._02._03;

/**
 * @Description: 面试题 02.03. 删除中间节点
 * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
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

    public void deleteNode(ListNode node) {
        node.val = node.next.val;//将后继结点的值赋给待删除结点
        node.next = node.next.next;
    }
}
