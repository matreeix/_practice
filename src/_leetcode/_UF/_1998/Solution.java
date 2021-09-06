package _leetcode._UF._1998;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 1998. 数组的最大公因数排序
 * 给你一个整数数组 nums ，你可以在 nums 上执行下述操作 任意次 ：
 * <p>
 * 如果 gcd(nums[i], nums[j]) > 1 ，交换 nums[i] 和 nums[j] 的位置。其中 gcd(nums[i], nums[j]) 是 nums[i] 和 nums[j] 的最大公因数。
 * 如果能使用上述交换方式将 nums 按 非递减顺序 排列，返回 true ；否则，返回 false 。
 * @Date: 2021/9/6
 */

public class Solution {

    class UnionFind {
        public int[] parent;
        public UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (x == parent[x]) return x;
            return parent[x] = find(parent[x]); // Path compression
        }

        void Union(int u, int v) {
            int pu = find(u), pv = find(v);
            if (pu != pv) parent[pu] = pv;
        }
    }

    public int[] spf; // spf[x] is the smallest prime factor of number x, where x >= 2

    public boolean gcdSort(int[] nums) {
        int maxNum = -1;
        for (int num : nums) maxNum = Math.max(maxNum, num);
        sieve(maxNum + 1);

        UnionFind uf = new UnionFind(maxNum + 1);
        for (int x : nums)
            for (int f : getPrimeFactors(x))
                uf.Union(x, f);

        int[] sortedArr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedArr);
        for (int i = 0; i < nums.length; ++i)
            if (uf.find(nums[i]) != uf.find(sortedArr[i]))
                return false; // can't swap nums[i] with sortedArr[i]
        return true;
    }

    public void sieve(int n) { // O(Nlog(logN)) ~ O(N)
        spf = new int[n];
        for (int i = 2; i < n; ++i) spf[i] = i;
        for (int i = 2; i * i < n; i++) {
            if (spf[i] != i) continue; // skip if `i` is not a prime number
            for (int j = i * i; j < n; j += i)
                if (spf[j] > i)
                    spf[j] = i; // update to the smallest prime factor of j
        }
    }

    public List<Integer> getPrimeFactors(int n) { // O(logN)
        List<Integer> factors = new ArrayList<>();
        while (n > 1) {
            factors.add(spf[n]);
            n /= spf[n];
        }
        return factors;
    }

}
