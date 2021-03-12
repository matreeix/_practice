package _design._707;

import java.util.Arrays;

/**
 * @Description: 707. 设计链表
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。
 * 如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * 在链表类中实现这些功能：
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 * @Date: 2021/3/12
 */

public class MyLinkedList {
    int[] vals;
    int l;//闭左边界
    int r;//开右边界

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        vals = new int[2001];
        l = 1001;
        r = 1001;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= r - l)
            return -1;
        return vals[index + l];
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        vals[--l] = val;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        vals[r++] = val;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        int len = r - l;
        if (index > len) return;
        else if (index == len) addAtTail(val);
        else if (index < 0) addAtHead(val);
        else {
            if (index <= len / 2) {
                int idx = --l;
                while (idx < index + l) {
                    vals[idx] = vals[idx + 1];
                    idx++;
                }
                vals[idx] = val;
            } else {
                int idx = r++;
                while (idx > index + l) {
                    vals[idx] = vals[idx - 1];
                    idx--;
                }
                vals[idx] = val;
            }
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        int len = r - l;
        if (index < 0 || index >= len) return;
        int idx = index + l;
        if (index <= len / 2) {
            while (idx >= l) {
                vals[idx] = vals[idx - 1];
                idx--;
            }
            l++;
        } else {
            while (idx <= r) {
                vals[idx] = vals[idx + 1];
                idx++;
            }
            r--;
        }
    }

    public void getVals() {
        System.out.print("[");
        for (int i = l; i < r; i++) {
            System.out.print(vals[i] + ",");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(4);

        linkedList.getVals();

        linkedList.addAtTail(3);

        linkedList.getVals();

        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3

        linkedList.getVals();

        int a = linkedList.get(1);            //返回2
        System.out.println(a);
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.getVals();

        int b = linkedList.get(1);            //返回3
        System.out.println(b);
        linkedList.getVals();
    }

}
