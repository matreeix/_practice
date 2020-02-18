package _other._160;

/**
 * @Description: 两个单向链表的交点(答案下面的可视化解读很清晰了)
 * 1.两个链表长度不等，只需遍历一遍；
 * 2.两个链表长度不等，需遍历两遍；
 *
 *
 * @Author: leetcode@myfavcat123
 * @Date: 2019/8/24 22:14
 */
public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }

   /* 1，获取两个列表的长度。

      2，将它们对齐到相同的起点。

      3，将它们一起移动直到找到交叉点，或者结束为空*/

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int lenA = length(headA), lenB = length(headB);
        // move headA and headB to the same start point
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        // find the intersection until end
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int length(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }
}
