package _leetcode._UF._2076;


/**
 * @Description: 2076. 处理含限制条件的好友请求
 * 给你一个整数 n ，表示网络上的用户数目。每个用户按从 0 到 n - 1 进行编号。
 * 给你一个下标从 0 开始的二维整数数组 restrictions ，其中 restrictions[i] = [xi, yi] 意味着用户 xi 和用户 yi 不能 成为 朋友 ，不管是 直接 还是通过其他用户 间接 。
 * 最初，用户里没有人是其他用户的朋友。给你一个下标从 0 开始的二维整数数组 requests 表示好友请求的列表，其中 requests[j] = [uj, vj] 是用户 uj 和用户 vj 之间的一条好友请求。
 * 如果 uj 和 vj 可以成为 朋友 ，那么好友请求将会 成功 。每个好友请求都会按列表中给出的顺序进行处理（即，requests[j] 会在 requests[j + 1] 前）。一旦请求成功，
 * 那么对所有未来的好友请求而言， uj 和 vj 将会 成为直接朋友 。
 * 返回一个 布尔数组 result ，其中元素遵循此规则：如果第 j 个好友请求 成功 ，那么 result[j] 就是 true ；否则，为 false 。
 * 注意：如果 uj 和 vj 已经是直接朋友，那么他们之间的请求将仍然 成功 。
 * @Date: 2021/11/16
 */

public class Solution {
    /**
     * 带路径压缩的并查集不支持最后一次合并的撤销操作
     *
     * */
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
                int[] tmp = new int[uf.p.length];
                System.arraycopy(uf.p, 0, tmp, 0, uf.p.length);// 必须拷贝parent数组，应该find()会改变parent的值
                uf.union(r[0], r[1]);// 合并
                boolean canUnion = true;
                for (int[] restriction : restrictions) {
                    if (uf.find(restriction[0]) == uf.find(restriction[1])) {
                        canUnion = false;
                        break;
                    }
                }
                if (!canUnion) {
                    uf.p = tmp;// 撤销合并
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

        private void union(int x, int y) {
            p[find(y)] = find(x);
        }

    }
}
