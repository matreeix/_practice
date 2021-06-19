package _leetcode._list._817;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 817. 链表组件
 * 给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。
 * 同时给定列表 G，该列表是上述链表中整型值的一个子集。
 * 返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。
 * @Date: 2021/3/11
 */

public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int i : G)
            set.add(i);
        int res = 0;
        ListNode tmp = null;
        while (head != null) {
            if (set.contains(head.val)) {
                tmp = tmp == null ? head : tmp;
            } else {
                res = tmp == null ? res : res + 1;
                tmp = null;
            }
            head = head.next;
        }
        res = tmp == null ? res : res + 1;
        return res;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(0);
        l.next = new ListNode(1);
        l.next.next = new ListNode(2);
        l.next.next.next = new ListNode(3);
        int[] arr = {0, 1, 3};

        System.out.println(numComponents(l, arr));
    }

}
