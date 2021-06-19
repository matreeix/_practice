package _leetcode._CONTEST._weekly._221;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description: 1707. 与数组中元素的最大异或值
 * 给你一个由非负整数组成的数组 nums 。另有一个查询数组 queries ，其中 queries[i] = [xi, mi] 。
 * 第 i 个查询的答案是 xi 和任何 nums 数组中不超过 mi 的元素按位异或（XOR）得到的最大值。换句话说，
 * 答案是 max(nums[j] XOR xi) ，其中所有 j 均满足 nums[j] <= mi 。如果 nums 中的所有元素都大于 mi，最终答案就是 -1 。
 * 返回一个整数数组 answer 作为查询的答案，其中 answer.length == queries.length 且 answer[i] 是第 i 个查询的答案。
 * @Date: 2020/12/29
 */

public class Solution4 {
    //暴力解法,O(n^2)
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        Arrays.sort(nums);
        for (int i = 0; i < res.length; i++) {
            if (queries[i][1] < nums[0]) {
                res[i] = -1;
            } else {
                for (int num : nums) {
                    if (num <= queries[i][1])
                        res[i] = Math.max(queries[i][0] ^ num, res[i]);
                }
            }
        }
        return res;
    }


    //字典树
    class TrieNode {
        TrieNode nums[] = new TrieNode[2];
        int prefixValue;
    }

    public int[] maximizeXor2(int[] nums, int[][] queries) {
        int queriesLength = queries.length;
        int[] ans = new int[queriesLength];
        int[][] temp = new int[queriesLength][3];
        for (int i = 0; i < queriesLength; i++) {
            temp[i][0] = queries[i][0];
            temp[i][1] = queries[i][1];
            temp[i][2] = i;
        }

        Arrays.sort(temp, Comparator.comparingInt(a -> a[1]));
        int index = 0;
        Arrays.sort(nums);
        TrieNode root = new TrieNode();

        for (int query[] : temp) {
            while (index < nums.length && nums[index] <= query[1]) {
                insert(root, nums[index]);
                index++;
            }
            int tempAns = -1;
            if (index != 0) {
                tempAns = search(root, query[0]);
            }
            ans[query[2]] = tempAns;
        }

        return ans;
    }

    public void insert(TrieNode root, int n) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (n >> i) & 1;
            if (node.nums[bit] == null) {
                node.nums[bit] = new TrieNode();
            }
            node = node.nums[bit];
        }
        node.prefixValue = n;
    }

    public int search(TrieNode root, int n) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (n >> i) & 1;
            int requiredBit = bit == 1 ? 0 : 1;
            if (node.nums[requiredBit] != null) {
                node = node.nums[requiredBit];
            } else {
                node = node.nums[bit];
            }
        }
        return node.prefixValue ^ n;
    }
}
