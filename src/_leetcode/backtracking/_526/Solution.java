package _leetcode.backtracking._526;

/**
 * @Description: 526. 优美的排列
 * 假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：
 * <p>
 * 第 i 位的数字能被 i 整除
 * i 能被第 i 位上的数字整除
 * 现在给定一个整数 N，请问可以构造多少个优美的排列？
 * @Author: matreeix
 * @Date: 2020/4/26
 */
public class Solution {
    //回溯法
    //时间复杂度：O(k)，k 是有效排列的数目。
    //空间复杂度：O(n)，使用了大小为 n 的数组 visited。递归树的深度最多为 n，这里 n 是给定的整数 n。
    int count = 0;

    public int countArrangement(int N) {
        boolean[] visited = new boolean[N + 1];
        calculate(N, 1, visited);
        return count;
    }

    public void calculate(int N, int pos, boolean[] visited) {
        if (pos > N)
            count++;
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                calculate(N, pos + 1, visited);
                visited[i] = false;
            }
        }
    }
}
