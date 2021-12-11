package _leetcode._CONTEST._weekly._270;

import java.util.*;

/**
 * @Description: 2097. 合法重新排列数对
 * 给你一个下标从 0 开始的二维整数数组 pairs ，其中 pairs[i] = [starti, endi] 。
 * 如果 pairs 的一个重新排列，满足对每一个下标 i （ 1 <= i < pairs.length ）都有 endi-1 == starti ，那么我们就认为这个重新排列是 pairs 的一个 合法重新排列 。
 * 请你返回 任意一个 pairs 的合法重新排列。
 * 注意：数据保证至少存在一个 pairs 的合法重新排列。
 * 提示：
 * 1 <= pairs.length <= 10^5
 * pairs[i].length == 2
 * 0 <= starti, endi <= 10^9
 * starti != endi
 * pairs 中不存在一模一样的数对。
 * 至少 存在 一个合法的 pairs 重新排列。
 * @Date: 2021/12/6
 */

public class Solution4 {
    Map<Integer, List<Integer>> graph = new HashMap<>();// 记录有向图
    List<int[]> reverse = new ArrayList<>();
    LinkedList<Integer> ret = new LinkedList<>();

    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, Integer> netOut = new HashMap<>();// 记录纯入度
        for (int[] pair : pairs) {
            netOut.put(pair[1], netOut.getOrDefault(pair[1], 0) + 1);
            netOut.put(pair[0], netOut.getOrDefault(pair[0], 0) - 1);
            graph.putIfAbsent(pair[0], new ArrayList<>());
            graph.get(pair[0]).add(pair[1]);
        }

        int start = pairs[0][0];// 默认选择一个起点
        for (Map.Entry<Integer, Integer> entry : netOut.entrySet())
            if (entry.getValue() == -1)
                start = entry.getKey();// 纯出度为1的作为起点

        dfs2(start);

        int n = pairs.length;
        int[][] ans = new int[n][2];
        for(int i = 0; i < n; i++){
            ans[i][0] = ret.pollLast();
            ans[i][1] = ret.peekLast();
        }
        return ans;
    }
    private void dfs2(int start){
        List<Integer> list = graph.get(start);
        while(list != null && !list.isEmpty()){
            Integer next = list.get(0);
            list.remove(0);
            dfs2(next);
        }
        ret.add(start);
    }

//    public void getEulerPath(int cur) {
//        Stack<Integer> stack = new Stack<>();
//        stack.push(cur);
//        while (!stack.isEmpty()) {
//            List<Integer> adj = graph.get(cur);
//            if (adj != null && adj.size() != 0) {//当前顶点的度数不为0还有路可走
//                stack.push(cur);
//                List<Integer> list = graph.get(cur);
//                int next = list.get(0);
//                list.remove(0);
//                cur = next;
//            } else {//无路可走就是找到一个环
//                reverse.add(new int[]{stack.peek(), cur});
//                cur = stack.pop();//回退，直到退到一个顶点度数不为0的顶点，进入前面的if继续寻找新环
//            }
//        }
//    }

//    private void dfs(int cur) {
//        List<Integer> list = graph.get(cur);
//        while (list != null && list.size() > 0) {
//            int next = list.get(0);
//            list.remove(0);// 删除遍历过的边
//            dfs(next);
//            reverse.add(new int[]{cur, next}); // 当无路可走时就把当前边放进结果里
//        }
//    }

    public static void main(String[] args) {
        int[][] pairs = {{5, 1}, {4, 5}, {11, 9}, {9, 4}};
//        int[][] pairs = {{999, 990}, {356, 511}, {192, 879}, {246, 945}, {322, 602}, {776, 246}, {248, 126}, {503, 284}, {126, 164}, {494, 731}, {862, 382}, {731, 578}, {511, 277}, {122, 731}, {578, 99}, {731, 277}, {847, 538}, {246, 494}, {284, 138}, {382, 899}, {811, 439}, {164, 99}, {485, 307}, {618, 320}, {494, 511}, {413, 248}, {945, 356}, {990, 614}, {138, 18}, {164, 862}, {277, 164}, {826, 737}, {277, 322}, {618, 122}, {291, 639}, {288, 11}, {624, 485}, {740, 452}, {614, 740}, {307, 903}, {457, 412}, {538, 961}, {439, 122}, {961, 999}, {639, 822}, {903, 503}, {961, 776}, {138, 538}, {122, 826}, {99, 138}, {949, 175}, {452, 847}, {320, 624}, {879, 457}, {511, 961}, {835, 692}, {18, 949}, {737, 413}, {822, 999}, {11, 726}, {692, 618}, {899, 835}, {726, 192}, {999, 452}, {602, 811}, {452, 618}, {175, 246}, {99, 291}, {412, 494}};
        int[][] res = (new Solution4()).validArrangement(pairs);
        for (int[] i : res)
            System.out.println(Arrays.toString(i));
    }
}
