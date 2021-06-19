package _leetcode._tree._binary_tree._106;

/**
 * @Description:已知中后序遍历，求二叉树
 * @Author: matreeix
 * @Date: 2020/2/15
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }

    /**
     * postStart：当前根节点在postorder的索引
     * inStart：在inorder中，查找当前根节点的开始位置索引
     * inEnd：在inorder中，查找当前根节点的终止位置索引
     * 注：在前序遍历中，当前节点node的索引为 postStart，则
     * node.left的索引为 postStart - 1 - (inEnd - inIndex)；
     * node.right的索引为 postStart - 1；
     */
    public TreeNode helper(int postStart, int inStart, int inEnd, int[] inorder, int[] postorder) {
        if (postStart < 0 || inStart > inEnd) {
            return null;
        }

        //找到当前根节点在中序遍历对应的节点
        TreeNode root = new TreeNode(postorder[postStart]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }

        root.left = helper(postStart - inEnd + inIndex - 1, inStart, inIndex - 1, inorder, postorder);
        root.right = helper(postStart - 1, inIndex + 1, inEnd, inorder, postorder);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        System.out.println((new Solution()).buildTree(inorder, postorder).val);
        System.out.println((new Solution()).buildTree(inorder, postorder).left.val);
        System.out.println((new Solution()).buildTree(inorder, postorder).right.val);
        System.out.println((new Solution()).buildTree(inorder, postorder).right.left.val);
        System.out.println((new Solution()).buildTree(inorder, postorder).right.right.val);


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
