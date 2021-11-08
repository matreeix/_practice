package _leetcode._CONTEST._weekly._265;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 2058. 找出临界点之间的最小和最大距离
 * 链表中的 临界点 定义为一个 局部极大值点 或 局部极小值点 。
 * 如果当前节点的值 严格大于 前一个节点和后一个节点，那么这个节点就是一个  局部极大值点 。
 * 如果当前节点的值 严格小于 前一个节点和后一个节点，那么这个节点就是一个  局部极小值点 。
 * 注意：节点只有在同时存在前一个节点和后一个节点的情况下，才能成为一个 局部极大值点 / 极小值点 。
 * 给你一个链表 head ，返回一个长度为 2 的数组 [minDistance, maxDistance] ，其中 minDistance 是任意两个不同临界点之间的最小距离，
 * maxDistance 是任意两个不同临界点之间的最大距离。如果临界点少于两个，则返回 [-1，-1] 。
 * @Date: 2021/11/8
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

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> dis = new ArrayList<>();
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next = head.next.next;
        if (next == null) return new int[]{-1, -1};
        int idx = 1;
        while (next != null) {
            if (pre.val > cur.val && next.val > cur.val) {
                dis.add(idx);
            } else if (pre.val < cur.val && next.val < cur.val) {
                dis.add(idx);
            }
            idx++;
            pre = cur;
            cur = next;
            next = next.next;

        }
        if (dis.size() < 2) return new int[]{-1, -1};
        int max = dis.get(dis.size() - 1) - dis.get(0);
        int min = 100000;
        for (int i = 1; i < dis.size(); i++) {
            min = Math.min(min, dis.get(i) - dis.get(i - 1));
        }
        return new int[]{min, max};
    }
}
