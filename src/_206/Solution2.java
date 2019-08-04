package _206;

import  _206.*;

/**
 * @Description: 递归的方式
 * @Author: 67ng
 * @Date: 2019/8/4 18:39
 */
public class Solution2 {
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

    public static ListNode reverseList(ListNode head) {


        // 递归终止条件
        if (head == null || head.next == null)
            return head;

        ListNode rhead = reverseList(head.next);

        // head->next此刻指向head后面的链表的尾节点
        // head->next->next = head把head节点放在了尾部
        head.next.next = head;
        head.next = null;

        return rhead;
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
        ListNode listNode = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;


        listToString(listNode);
        System.out.println("~~~~~~~~~~~~~~~~~~");
        listToString(reverseList(listNode));
    }


}
