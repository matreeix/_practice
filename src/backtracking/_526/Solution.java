package backtracking._526;

/**
 * @Description:
 * @Author: caffebaby
 * @Date: 2020/4/26
 */
public class Solution {
    //回溯法
    // 时间复杂度：O(k)。k 是有效排列的数目。
    //空间复杂度：O(n)。使用了大小为 n 的数组 visited。递归树的深度最多为 n，这里 n 是给定的整数 n。
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
