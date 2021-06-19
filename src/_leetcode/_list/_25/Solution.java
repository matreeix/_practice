package _leetcode._list._25;

/**
 * @Description: k个一组翻转链表
 * <p>
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: matreeix
 * @Date: 2020/6/15
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null)
            return head;
        return iterateHelper(head, k - 1);
    }

    public ListNode iterateHelper(ListNode head, int k) {
        ListNode start = head, res = null;
        ListNode pre = null;
        while (true) {
            int index;
            ListNode end = start;
            for (index = 0; index < k; ++index) {
                if (end == null)
                    break;
                end = end.next;
            }
            if (index != k || end == null)
                break;
            ListNode node = end == null ? null : end.next;
            end.next = null;
            reverse(start);
            if (pre != null) {
                pre.next = end;
            } else {
                res = end;
            }
            pre = start;
            start = node;
        }
        if (pre != null)
            pre.next = start;
        return res;
    }

    //翻转链表
    public ListNode reverse(ListNode head) {
        ListNode pre = head, next = pre.next;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = pre;
            pre = next;
            next = tmp;
        }
        return head;
    }

    public static void main(String[] args) {

    }


}
