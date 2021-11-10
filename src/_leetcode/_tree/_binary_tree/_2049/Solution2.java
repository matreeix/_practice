package _leetcode._tree._binary_tree._2049;

/**
 * @Description:
 * @Date: 2021/11/9
 */

public class Solution2 {
    int res = 0;
    long max = Long.MIN_VALUE;

    public int countHighestScoreNodes(int[] parents) {
        int count = parents.length;
        int[] L = new int[count];
        int[] R = new int[count];
        for (int i = 0; i < count; ++i) L[i] = R[i] = -1;
        for (int i = 1; i < count; ++i) {
            int p = parents[i];
            if (L[p] == -1) L[p] = i;
            else R[p] = i;
        }

        dfs(parents, 0, L, R);
        return res;
    }

    public int dfs(int[] parents, int parent, int[] L, int[] R) {
        int left = 0;
        int right = 0;
        int count = parents.length;
        boolean flag = false;
        if (parent == -1) return 0;
        left = dfs(parents, L[parent], L, R);
        right = dfs(parents, R[parent], L, R);

        long score = (long) Math.max(left, 1) * Math.max(right, 1) * Math.max(count - left - right - 1, 1);
        if (score > max) {
            max = score;
            res = 1;
        } else if (score == max) {
            ++res;
        }
        return 1 + right + left;
    }
}
