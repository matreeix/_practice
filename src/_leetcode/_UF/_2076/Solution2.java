package _leetcode._UF._2076;

/**
 * @Description: 标准解法
 * @Date: 2021/11/17
 */

public class Solution2 {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        boolean[] res = new boolean[requests.length];
        UF uf = new UF(n);
        for (int i = 0; i < res.length; i++) {
            int[] r = requests[i];
            int p1 = uf.find(r[0]);
            int p2 = uf.find(r[1]);
            if (p1 == p2) {
                res[i] = true;
            } else {
                boolean canUnion = true;
                for (int[] restriction : restrictions) {
                    int u = uf.find(restriction[0]);
                    int v = uf.find(restriction[1]);
                    if ((p1 == u && p2 == v) || (p1 == v && p2 == u)) {
                        canUnion = false;
                        break;
                    }
                }
                if (canUnion) uf.union(r[0], r[1]);// 合并
                res[i] = canUnion;
            }
        }

        return res;
    }

    public class UF {

        private int[] p;

        public UF(int n) {
            p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
            }
        }

        private int find(int x) {
            if (x != p[x])
                p[x] = find(p[x]);
            return p[x];
        }

        private void union(int x, int y) {
            p[find(y)] = find(x);
        }

    }
}
