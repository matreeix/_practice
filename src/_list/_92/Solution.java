package _list._92;

/**
 * @Description: 在[m, n]区间翻转链表
 *    不使用虚拟头结点，十分复杂，运行有问题
 * @Author: matreeix
 * @Date: 2019/8/4 16:05
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "" + val;
        }
    }


    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode tmp = head;
        for (int i = 1; i < m - 1; i++) {//递推m-1次
            tmp = tmp.next;
        }
        ListNode pre_node = tmp;


        ListNode pre = pre_node;
        if (pre.next == null) return pre;
        ListNode cur = pre_node.next;//开始反转的节点
        if (cur.next == null) {
            cur.next = pre;
            pre.next = null;
            return cur;
        }
        ListNode next = cur.next;
        for (int i = 0; i < n - m; i++) {//递推n-m次，反转链表
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = cur.next;
        }
        return head;
    }

    //显示链表[遍历]
    public static void listToString(ListNode head) {
        //判断链表是否为空
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        ListNode temp = head;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移， 一定小心
            temp = temp.next;
        }
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);

        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(7);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        listNode5.next = listNode6;


        listToString(listNode5);
        System.out.println("~~~~~~~~~~~~~~~~~~");
        listToString(reverseBetween(listNode, 1, 5));
//        listToString(reverseBetween(listNode5, 1, 2));
//        listToString(reverseBetween(listNode5, 1, 2));
    }

}
