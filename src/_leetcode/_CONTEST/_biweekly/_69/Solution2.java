package _leetcode._CONTEST._biweekly._69;

import java.util.Stack;

/**
 * @Description: 5961. 链表最大孪生和
 * 在一个大小为 n 且 n 为 偶数 的链表中，对于 0 <= i <= (n / 2) - 1 的 i ，第 i 个节点（下标从 0 开始）的孪生节点为第 (n-1-i) 个节点 。
 * 比方说，n = 4 那么节点 0 是节点 3 的孪生节点，节点 1 是节点 2 的孪生节点。这是长度为 n = 4 的链表中所有的孪生节点。
 * 孪生和 定义为一个节点和它孪生节点两者值之和。
 * 给你一个长度为偶数的链表的头节点 head ，请你返回链表的 最大孪生和 。
 * 提示：
 * 链表的节点数目是 [2, 10^5] 中的 偶数 。
 * 1 <= Node.val <= 10^5
 * @Date: 2022/1/8
 */

public class Solution2 {
    class ListNode {
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

    public int pairSum(ListNode head) {
        int[] tmp = new int[100001];
        int idx = 0;
        while (head != null) {
            tmp[idx++] = head.val;
            head = head.next;
        }
        int res = 0;
        for (int i = 0; i < idx / 2; i++) {
            res = Math.max(res, tmp[i] + tmp[idx - 1 - i]);
        }
        return res;
    }

    public int pairSum2(ListNode head) {
        Stack<ListNode> st = new Stack();
        ListNode temp = head;
        while (temp != null) {
            st.push(temp);
            temp = temp.next;
        }
        temp = head;
        int max = Integer.MIN_VALUE;
        int size = st.size();
        while (st.size() > size / 2) {
            int last = st.pop().val;
            int first = temp.val;
            max = Math.max(max, (first + last));
            temp = temp.next;
        }
        return max;
    }

}
