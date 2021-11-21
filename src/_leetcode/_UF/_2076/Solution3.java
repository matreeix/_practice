package _leetcode._UF._2076;

/**
 * @Description:
 * @Date: 2021/11/17
 */

public class Solution3 {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        boolean[] res = new boolean[requests.length];
        UF uf = new UF(n);
        for (int i = 0; i < res.length; i++) {
            int[] r = requests[i];
            int p1 = uf.find2(r[0]);
            int p2 = uf.find2(r[1]);
            if (p1 == p2) {
                res[i] = true;
            } else {
                uf.union(r[0], r[1]);
                boolean canUnion = true;
                for (int[] restriction : restrictions) {
                    if (uf.find2(restriction[0]) == uf.find2(restriction[1])) {
                        canUnion = false;
                        break;
                    }
                }
                if (!canUnion) {
                    uf.p[p2] = p2;// 使用非路径压缩的UF可以撤销最后的合并
                }
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

        private int find2(int x) {
            while (x != p[x])
                x = p[x];
            return x;
        }


        private void union(int x, int y) {
            p[find(y)] = find(x);
        }
    }
}
