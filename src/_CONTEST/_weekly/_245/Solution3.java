package _CONTEST._weekly._245;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 5785. 合并若干三元组以形成目标三元组
 * 三元组 是一个由三个整数组成的数组。给你一个二维整数数组 triplets ，其中 triplets[i] = [ai, bi, ci] 表示第 i 个 三元组 。同时，给你一个整数数组 target = [x, y, z] ，表示你想要得到的 三元组 。
 * 为了得到 target ，你需要对 triplets 执行下面的操作 任意次（可能 零 次）：
 * 选出两个下标（下标 从 0 开始 计数）i 和 j（i != j），并 更新 triplets[j] 为 [max(ai, aj), max(bi, bj), max(ci, cj)] 。
 * 例如，triplets[i] = [2, 5, 3] 且 triplets[j] = [1, 7, 5]，triplets[j] 将会更新为 [max(2, 1), max(5, 7), max(3, 5)] = [2, 7, 5] 。
 * 如果通过以上操作我们可以使得目标 三元组 target 成为 triplets 的一个 元素 ，则返回 true ；否则，返回 false 。
 * @Created by: matreeix
 * @Date: 2021/6/13
 */
public class Solution3 {

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean b1 = false, b2 = false, b3 = false;
        Set<int[]> set = new HashSet<>();
        for (int[] triplet : triplets) {
            if (triplet[0] <= target[0]
                    && triplet[1] <= target[1]
                    && triplet[2] <= target[2]) {
                set.add(triplet);
            }
        }

        for (int[] arr : set) {
            if (arr[0] == target[0]) b1 = true;
            if (arr[1] == target[1]) b2 = true;
            if (arr[2] == target[2]) b3 = true;
        }
        return b1 && b2 && b3;
    }

    public class Triplet {
        private int a;
        private int b;
        private int c;

        public Triplet(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public boolean equals(Object obj) {
            // 如果为同一对象的不同引用,则相同
            if (this == obj || obj == null) {
                return false;
            }
            // 如果两者属于不同的类型,不能相等
            if (getClass() != obj.getClass()) {
                return false;
            }

            // 类型相同, 比较内容是否相同
            Triplet other = (Triplet) obj;
            return this.a == other.a
                    && this.b == other.b
                    && this.c == other.c;
        }
    }
}
