package _leetcode._CONTEST._weekly._269;

import _util.ArrayUtil;
import _util.ReadWriteUtil;

import java.util.*;

/**
 * @Description: 5941. 找出知晓秘密的所有专家
 * 给你一个整数 n ，表示有 n 个专家从 0 到 n - 1 编号。另外给你一个下标从 0 开始的二维整数数组 meetings ，其中 meetings[i] = [xi, yi, timei]
 * 表示专家 xi 和专家 yi 在时间 timei 要开一场会。一个专家可以同时参加 多场会议 。最后，给你一个整数 firstPerson 。
 * 专家 0 有一个 秘密 ，最初，他在时间 0 将这个秘密分享给了专家 firstPerson 。接着，这个秘密会在每次有知晓这个秘密的专家参加会议时进行传播。
 * 更正式的表达是，每次会议，如果专家 xi 在时间 timei 时知晓这个秘密，那么他将会与专家 yi 分享这个秘密，反之亦然。
 * 秘密共享是 瞬时发生 的。也就是说，在同一时间，一个专家不光可以接收到秘密，还能在其他会议上与其他专家分享。
 * 在所有会议都结束之后，返回所有知晓这个秘密的专家列表。你可以按 任何顺序 返回答案。
 * 提示：
 * 2 <= n <= 10^5
 * 1 <= meetings.length <= 10^5
 * meetings[i].length == 3
 * 0 <= xi, yi <= n - 1
 * xi != yi
 * 1 <= timei <= 10^5
 * 1 <= firstPerson <= n - 1
 * @Date: 2021/11/28
 */

public class Solution4 {
    // 并查集
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        UF uf = new UF(n);
        uf.union(firstPerson, 0);

        Arrays.sort(meetings, Comparator.comparingInt(m -> m[2]));
        Set<Integer> tmpSet = new HashSet<>();
        int p = uf.find(firstPerson), curTime = meetings[0][2];

        for (int[] meeting : meetings) {
            if (curTime != meeting[2]) {// 更新时刻
                for (int tmp : tmpSet) {// 没有得到秘密的专家就复原
                    if (uf.find(tmp) != p) {
                        uf.restore(tmp);
                    }
                }
                tmpSet.clear();
                curTime = meeting[2];
            }
            tmpSet.add(meeting[0]);
            tmpSet.add(meeting[1]);
            if (p == uf.find(meeting[0]) || p == uf.find(meeting[1])) {
                uf.union(firstPerson, meeting[0]);
                uf.union(firstPerson, meeting[1]);
            } else {// 将未获得秘密的专家先合并
                uf.union(meeting[0], meeting[1]);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (uf.find(i) == p)
                ans.add(i);
        return ans;
    }

    public static class UF {

        public int[] p;

        public UF(int n) {
            p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
            }
        }

        public int find(int x) {
            if (x != p[x])
                p[x] = find(p[x]);
            return p[x];
        }

        public void restore(int x) {
            p[x] = x;
        }

        public void union(int x, int y) {
            p[find(y)] = find(x);
        }
    }

    public Set<Integer> set;
    public Map<Integer, List<Integer>> map;

    // BFS
    public List<Integer> findAllPeople2(int n, int[][] meetings, int firstPerson) {
        set = new HashSet<>();
        set.add(0);
        set.add(firstPerson);

        Arrays.sort(meetings, Comparator.comparingInt(m -> m[2]));
        map = new HashMap<>();
        int curTime = meetings[0][2];

        for (int[] meeting : meetings) {
            if (curTime != meeting[2]) {// 更新时刻
                // 结算上一时刻
                bfs();
                map.clear();
                curTime = meeting[2];
            }
            map.putIfAbsent(meeting[0], new ArrayList<>());
            map.putIfAbsent(meeting[1], new ArrayList<>());
            map.get(meeting[0]).add(meeting[1]);
            map.get(meeting[1]).add(meeting[0]);
        }
        if (!map.isEmpty()) {
            bfs();
        }

        return new ArrayList<>(set);
    }

    private void bfs() {
        Set<Integer> tmp = new HashSet<>(map.keySet());
        tmp.retainAll(set);
        Queue<Integer> q = new LinkedList<>(tmp);
        while (!q.isEmpty()) {
            int cur = q.poll();
            List<Integer> list = map.get(cur);
            for (int next : list) {
                if (!set.contains(next)) {
                    set.add(next);
                    q.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr0 = ArrayUtil.parse2DimIntArr(ReadWriteUtil.readFileByLines("C:\\Users\\123456\\Desktop\\LeetCodeDemo1.txt"));
        int[][] arr1 = ArrayUtil.parse2DimIntArr(ReadWriteUtil.readFileByLines("C:\\Users\\123456\\Desktop\\LeetCodeDemo.txt"));
        int[] arr2 = ArrayUtil.parse1DimIntArr(ReadWriteUtil.readFileByLines("C:\\Users\\123456\\Desktop\\LeetCodeDemo2.txt"));
        Solution4 s = new Solution4();
        UF uf = new UF(4);
        int[][] arr = {{1, 0}, {2, 1}, {3, 2}};
        List<Integer> res1 = s.findAllPeople(10010, arr1, 10000);
    }
}
