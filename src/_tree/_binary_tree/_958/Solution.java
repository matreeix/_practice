package _tree._binary_tree._958;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 判断一棵树是否是完全二叉树(按层遍历时 : 1.有右子树无左子树返回false ; 2.有左子树或无子树时 ， 遍历其后面的所有
 *节点都是叶子结点返回true ， 否则返回false)
 * @Author: 67ng
 * @Date: 2020/5/8
 */
public class Solution {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        boolean leaf = false;
        TreeNode l;
        TreeNode r;
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            l = root.left;
            r = root.right;
            if ((leaf && (l != null || r != null))
                    || (l == null && r != null))//有右子树无左子树返回false
                return false;

            if (l != null)
                queue.offer(l);

            if (r != null)//某个节点没有右子树时，考察后面遍历的所有的节点必须都是叶子节点
                queue.offer(r);
            else
                leaf = true;
        }
        return true;
    }
}
