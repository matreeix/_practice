package _list._86;

/**
 * @Description: 分隔链表
 * <p>
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。(稳定性)
 * @Author: matreeix
 * @Date: 2020/6/25
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
        if (head == null || head.next == null)
            return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        while (len > 0) {
            if (head.val >= x) {
                tail = swap(head, tail);//java是值传递
            } else {
                head = head.next;
            }
            len--;
        }
        return dummyHead.next;
    }

    //将当前节点放到尾节点，并返回尾节点
    private ListNode swap(ListNode node, ListNode tail) {
        tail.next = new ListNode(node.val);
        node.val = node.next.val;//将要删除的节点的值改为和后继节点一样
        node.next = node.next.next;//删除后继节点即可
        return tail.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        Solution s = new Solution();
        ListNode res = s.partition(head, 3);//1->2->2->4->3->5->null
        while (res != null) {
            System.out.print(res.val + "->");
            res = res.next;
        }
        System.out.println("null");
    }
}
