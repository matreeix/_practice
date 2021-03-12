package _design._707;

/**
 * @Description: 使用节点类
 * @Date: 2021/3/12
 */

class MyLinkedList2 {
    private ListNode preHead;
    private ListNode postTail;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList2() {
        preHead = new ListNode(0);
        postTail = new ListNode(0);
        preHead.next = postTail;
        postTail.prev = preHead;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size)
            return -1;
        return getAtIndex(index).val;
    }

    private ListNode getAtIndex(int index) {
        ListNode cur;
        if (index < size / 2) {
            cur = preHead;
            for (int i = 0; i <= index; i++) cur = cur.next;
        } else {
            cur = postTail;
            for (int i = size - 1; i >= index; i--) cur = cur.prev;
        }
        return cur;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        ListNode cur = index == size ? postTail : getAtIndex(index);
        ListNode newNode = new ListNode(val);

        cur.prev.next = newNode;
        newNode.prev = cur.prev;
        cur.prev = newNode;
        newNode.next = cur;

        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        ListNode cur = getAtIndex(index);
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        size--;
    }

    public void traverse() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + ",");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        MyLinkedList2 linkedList = new MyLinkedList2();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.traverse();
        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3
        linkedList.traverse();
        int a = linkedList.get(1);            //返回2
        System.out.println("a:" + a);
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.traverse();
        int b = linkedList.get(1);            //返回3
        System.out.println("b:" + b);
    }
}


class ListNode {
    public int val;
    public ListNode prev;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
