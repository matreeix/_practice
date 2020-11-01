package _CONTEST._weekly._213;

/**
 * @Description: 5554. 能否连接形成数组
 * 给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。
 * 请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
 * <p>
 * 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
 * <p>
 * 提示：
 * <p>
 * 1 <= pieces.length <= arr.length <= 100
 * sum(pieces[i].length) == arr.length
 * 1 <= pieces[i].length <= arr.length
 * 1 <= arr[i], pieces[i][j] <= 100
 * arr 中的整数 互不相同
 * pieces 中的整数 互不相同（也就是说，如果将 pieces 扁平化成一维数组，数组中的所有整数互不相同）
 * @Author: matreeix
 * @Date: 2020/11/1
 */

public class Solution1 {
    public static boolean canFormArray(int[] arr, int[][] pieces) {
        boolean[] visited = new boolean[pieces.length];
        for (int i = 0; i < arr.length; ) {
            int start = -1;
            for (int j = 0; j < pieces.length; j++) {
                if (visited[j] == false && pieces[j][0] == arr[i]) {
                    start = j;
                }
            }
            if (start == -1) return false;
            for (int k = 0; k < pieces[start].length; k++) {
                if (pieces[start][k] != arr[i])
                    return false;
                else
                    i++;
            }
        }
        return true;
    }

}
