package _greedy._1306;


import java.util.Arrays;

/**
 * @Description:跳跃游戏Ⅲ 给定一个非负整数数组arr，您最初位于数组的start索引处。当位于的索引是i时，可以跳至i + arr[i]或i - arr[i]的索引位置，
 * 检查是否可以到达任何值为0的索引。请注意，您无法跳出阵列。
 * @Author: caffebaby
 * @Date: 2020/3/4
 */
public class Solution {
    public boolean canReach(int[] arr, int start) {
        int[] visited = new int[arr.length];

        dfs(arr, start, 1, visited);//通过DFS将start索引能到达的visited值都标为1

        for (int i = 0; i < visited.length; i++)
            if (visited[i] == 1 && arr[i] == 0)
                return true;
        return false;
    }

    private void dfs(int[] arr, int v, int key, int[] visited) {
        visited[v] = key;
        if (v + arr[v] <= arr.length - 1 && visited[v + arr[v]] == 0)
            dfs(arr, v + arr[v], key, visited);
        if (v - arr[v] >= 0 && visited[v - arr[v]] == 0)
            dfs(arr, v - arr[v], key, visited);
    }

    public boolean canReach2(int[] arr, int st) {
        if (st >= 0 && st < arr.length && arr[st] < arr.length) {//确保不越界
            int jump = arr[st];
            arr[st] += arr.length;//确保不会重复访问造成无限递归
            return jump == 0 || canReach2(arr, st + jump) || canReach2(arr, st - jump);
        }
        return false;
    }


    public static void main(String[] args) {
        int[] arr1 = {4, 2, 3, 0, 3, 1, 2};
        int[] arr2 = {3, 0, 2, 1, 2};
        int[] arr3 = {4, 2, 3, 0, 3, 1, 2};
        System.out.println((new Solution()).canReach(arr1, 5));
        System.out.println((new Solution()).canReach(arr2, 2));
        System.out.println((new Solution()).canReach(arr3, 0));
    }

}
