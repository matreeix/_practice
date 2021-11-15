package _leetcode._CONTEST._weekly._267;

import java.util.Stack;

/**
 * @Description: 5927. 反转偶数长度组的节点
 * 给你一个链表的头节点 head 。
 * 链表中的节点 按顺序 划分成若干 非空 组，这些非空组的长度构成一个自然数序列（1, 2, 3, 4, ...）。一个组的 长度 就是组中分配到的节点数目。换句话说：
 * 节点 1 分配给第一组
 * 节点 2 和 3 分配给第二组
 * 节点 4、5 和 6 分配给第三组，以此类推
 * 注意，最后一组的长度可能小于或者等于 1 + 倒数第二组的长度 。
 * 反转 每个 偶数 长度组中的节点，并返回修改后链表的头节点 head 。
 * 提示：
 * 链表中节点数目范围是 [1, 10^5]
 * 0 <= Node.val <= 10^5
 * @Date: 2021/11/14
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


    public static ListNode reverseEvenLengthGroups(ListNode head) {
        int step = 1;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode cur = pre.next;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            if (next == null) break;
            ListNode preTmp = pre;
            ListNode curTmp = cur;
            ListNode nextTmp = next;
            for (int i = 0; i < step; i++) {// 尝试前进step个节点
                preTmp = preTmp.next;
                curTmp = curTmp.next;
                nextTmp = nextTmp.next;
                if (nextTmp == null && i != step - 1) {
                    step = i + 2;
                    break;
                }
            }
            if (step % 2 != 0) {// 奇数组不翻转
                pre = preTmp;
                cur = curTmp;
                next = nextTmp;
                if (next == null) break;
            } else {// 偶数组翻转
                for (int i = 0; i < step - 1; i++) {
                    next = cur.next;
                    if (next == null) break;
                    cur.next = next.next;
                    next.next = pre.next;
                    pre.next = next;
                }
                pre = cur;
                cur = cur.next;
            }
            step += 1;
        }
        return dummyNode.next;
    }

    // 使用栈来翻转
    public ListNode reverseEvenLengthGroups2(ListNode head) {
        int groupRequired = 1;
        ListNode temp = head;
        while (temp != null) {
            int count = 0;
            ListNode start = temp;
            Stack<Integer> stack = new Stack<>();
            while (count != groupRequired && temp != null) {
                stack.push(temp.val);
                temp = temp.next;
                count++;
            }
            if (count % 2 == 0) {
                while (start != temp) {
                    start.val = stack.pop();
                    start = start.next;
                }
            }
            groupRequired++;
        }
        return head;
    }


    public static void main(String[] args) {
//        ListNode head = new ListNode(5);//5,2,6,3,9,1,7,3,8,4
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(6);
//        head.next.next.next = new ListNode(3);
//        head.next.next.next.next = new ListNode(9);
//        head.next.next.next.next.next = new ListNode(1);
//        head.next.next.next.next.next.next = new ListNode(7);
//        head.next.next.next.next.next.next.next = new ListNode(3);
//        head.next.next.next.next.next.next.next.next = new ListNode(8);
//        head.next.next.next.next.next.next.next.next.next = new ListNode(4);

//        ListNode head = new ListNode(1);//1,1,0,6
//        head.next = new ListNode(1);
//        head.next.next = new ListNode(0);
//        head.next.next.next = new ListNode(6);

//        ListNode head = new ListNode(2);//2,1
//        head.next = new ListNode(1);

//        ListNode head = new ListNode(8);//8


//        ListNode head = new ListNode(0);//[0,4,2,1,3]
//        head.next = new ListNode(4);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(1);
//        head.next.next.next.next = new ListNode(3);

        ListNode head = new ListNode(0);//[0,3,4,1,5,2]
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);


        ListNode tmp = reverseEvenLengthGroups(head);
        while (tmp != null) {
            System.out.print(tmp.val + ",");
            tmp = tmp.next;
        }
    }

}
