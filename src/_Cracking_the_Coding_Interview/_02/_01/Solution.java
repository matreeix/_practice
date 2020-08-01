package _Cracking_the_Coding_Interview._02._01;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 面试题 02.01. 移除重复节点
 * 编写代码，移除 未排序 链表中的重复节点。保留最开始出现的节点。
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

    //O(n^2)
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode ob = head;
        while (ob != null) {
            ListNode oc = ob;
            while (oc.next != null) {
                if (oc.next.val == ob.val) oc.next = oc.next.next;
                else oc = oc.next;
            }
            ob = ob.next;
        }
        return head;
    }

    //hash表
    public ListNode removeDuplicateNodes2(ListNode head) {
        if (head == null) {
            return head;
        }
        Set<Integer> occurred = new HashSet<Integer>();
        occurred.add(head.val);
        ListNode pos = head;
        // 枚举前驱节点
        while (pos.next != null) {
            // 当前待删除节点
            ListNode cur = pos.next;
            if (occurred.add(cur.val)) {
                pos = pos.next;
            } else {
                pos.next = pos.next.next;
            }
        }
        pos.next = null;
        return head;
    }

    public static void main(String[] args) {

    }

}
