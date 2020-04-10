package _DP._337;

import javafx.util.Pair;

import java.util.*;

/**
 * @description ：打家劫舍3
 * @date ： 2020-04-10
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

    //对于每个树根，有两种情况：被抢劫或未被抢劫。rob(root)不能区分这两种情况，因此“信息随着递归的深入而丢失”，从而导致重复出现子问题。
    public int rob(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub(TreeNode root) {
        if (root == null) return new int[2];

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        int[] res = new int[2];//res[0]表示未打劫，res[1]表示打劫

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }

    public int rob2(TreeNode root) {
        return robSub(root, new HashMap<>());
    }

    private int robSub(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);

        int val = 0;

        if (root.left != null) {
            val += robSub(root.left.left, map) + robSub(root.left.right, map);
        }

        if (root.right != null) {
            val += robSub(root.right.left, map) + robSub(root.right.right, map);
        }

        val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
        map.put(root, val);

        return val;
    }

//             2
//            / \
//           1   3
//            \
//             4
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
//        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(4);

    }

    //得到二叉树每层的和的数组
    private static int[] getLevelSum(TreeNode root) {
        if (root == null) return null;

        List<Integer> level_sum = new ArrayList<>();
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.addLast(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> front = queue.removeFirst();

            TreeNode node = front.getKey();
            int level = front.getValue();
            if (level_sum.size() == level)
                level_sum.add(level, node.val);
            else
                level_sum.set(level, level_sum.get(level) + node.val);

            if (node.left != null)
                queue.addLast(new Pair<>(node.left, level + 1));
            if (node.right != null)
                queue.addLast(new Pair<>(node.right, level + 1));
        }

        int[] nums = new int[level_sum.size()];
        for (int i = 0; i < level_sum.size(); i++)
            nums[i] = level_sum.get(i);
        return nums;
    }
}
