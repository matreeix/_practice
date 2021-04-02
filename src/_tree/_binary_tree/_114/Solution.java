package _tree._binary_tree._114;

/**
 * @Description: 114. 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 1.展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 2.展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * <p>
 * 提示：
 * <p>
 * 树中结点数在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 * <p>
 * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 * @Date: 2021/4/2
 */

public class Solution {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    private TreeNode prev = null;

    /**
     * 展开链表顺序和先序遍历相同
     *     1
     *    / \
     *   2   5
     *  / \   \
     * 3  4    6
     */
    //后序(倒先序)遍历递归
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
//        System.out.println(root.val);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    /**
     * 展开链表顺序和中序遍历相同
     *     4
     *    / \
     *   2   5
     *  / \   \
     * 1  3    6
     */


    //递归
    public void flatten2(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;

        flatten2(left);
        flatten2(right);

        root.right = left;
        TreeNode cur = root;
        while (cur.right != null) cur = cur.right;
        cur.right = right;
    }

    //迭代法
    public void flatten3(TreeNode root) {
        while (root != null) {
            //左子树为 null，直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
            } else {
                // 找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }
    }

    private void printTree(TreeNode root) {
        while (root != null) {
            System.out.print(root.val + "->");
            root = root.right;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        Solution s = new Solution();
        s.flatten(root);
        s.printTree(root);
    }
}
