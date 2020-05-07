package _tree._binary_tree._894;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Description: 节点数为 N 的所有满二叉树
 * @Author: 67ng
 * @Date: 2020/5/7
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


    //令 F(N)作为所有含 N 个结点的可能的满二叉树的列表。
    //因此，对于 N≥3，我们可以设定如下的递归策略：F(N) =[对于所有的 x，所有的树的左子结点来自 F(x) ,
    //而右子结点来自 F(N-1-x)]。

    Map<Integer, List<TreeNode>> memo = new HashMap();

    public List<TreeNode> allPossibleFBT(int N) {
        if (!memo.containsKey(N)) {
            List<TreeNode> ans = new LinkedList();
            if (N == 1) {
                ans.add(new TreeNode(0));
            } else if (N % 2 == 1) {
                for (int x = 0; x < N; ++x) {
                    for (TreeNode left: allPossibleFBT(x))
                        for (TreeNode right: allPossibleFBT(N - 1 - x)) {
                            TreeNode bns = new TreeNode(0);//根节点
                            bns.left = left;
                            bns.right = right;
                            ans.add(bns);
                        }
                }
            }
            memo.put(N, ans);
        }

        return memo.get(N);
    }
}
