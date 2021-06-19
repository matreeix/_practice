package _leetcode._list._725;

/**
 * @Description: 分隔链表
 * <p>
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 * 返回一个符合上述规则的链表的列表。
 * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-linked-list-in-parts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: matreeix
 * @Date: 2020/6/18
 */

public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        if (k == 1)
            return new ListNode[]{root};

        ListNode[] res = new ListNode[k];
        int len = 0;
        ListNode count = root;
        while (count != null) {
            count = count.next;
            len++;
        }
        int segLen = len / k;//数组每个链表的最小长度
        int retain = len % k;//前retain长度要加一
        int i = 0;//数组的索引
        ListNode tmp = root;
        while (tmp != null) {
            if (retain != 0) {//长度多一的链表
                int segCount = 0;
                while (segCount != segLen ) {//先遍历利segLen的长度
                    tmp = tmp.next;
                    segCount++;
                }
                ListNode t = tmp.next;//暂存后续的节点
                tmp.next = null;//截断
                res[i++] = root;//放入数组对应位置
                //更新指针
                root = t;
                tmp = t;
                retain--;
            } else {
                int segCount = 0;
                while (segCount != segLen-1) {//先遍历利segLen-1的长度
                    tmp = tmp.next;
                    segCount++;
                }
                ListNode t = tmp.next;
                tmp.next = null;
                res[i++] = root;
                root = t;
                tmp = t;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);
        root.next.next.next.next.next.next = new ListNode(7);
        root.next.next.next.next.next.next.next = new ListNode(8);
        root.next.next.next.next.next.next.next.next = new ListNode(9);
        root.next.next.next.next.next.next.next.next.next = new ListNode(10);
        ListNode root2 = new ListNode(11);
        root2.next = new ListNode(22);
        Solution s = new Solution();
//        ListNode[] listNodes = s.splitListToParts(root, 3);
        ListNode[] listNodes = s.splitListToParts(root2, 5);
//        ListNode[] listNodes = {root, root2};
        for (ListNode listNode : listNodes) {
            while (listNode != null) {
                System.out.print(listNode.val + "->");
                listNode = listNode.next;
            }
            System.out.println("null");
        }
    }
}
