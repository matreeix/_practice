package _leetcode._tree._binary_tree._105;

/**
 * @Description:已知前中序遍历，求二叉树
 *
 * 基本思想是：
 * 假设我们有2个数组，PRE和IN。
 * 前序遍历意味着PRE[0]是根节点。
 * 然后我们可以在IN中找到这个PRE[0]，说它是IN[5]。
 * 现在我们知道IN[5]是根，所以我们知道IN[0]-IN[4]在左侧，后面的IN[6-]在右侧。
 * 在子数组上递归执行此操作，我们可以在其中构建一棵树:)
 *
 * @Author: matreeix
 * @Date: 2020/2/15
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    /**
     * preStart：当前根节点在preorder的索引
     * inStart：在inorder中，查找当前根节点的开始位置索引
     * inEnd：在inorder中，查找当前根节点的终止位置索引
     * 注：在前序遍历中，当前节点node的索引为preStart，则
     * node.left的索引为 preStart+1；
     * node.right的索引为 preStart+1+(inIndex - inStart)；
     *
     * */
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }

        //找到当前根节点在中序遍历对应的节点
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }

        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }

    public static void main(String[] args) {

    }

}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

