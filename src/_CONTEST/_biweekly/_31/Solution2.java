package _CONTEST._biweekly._31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 1524. 和为奇数的子数组数目
 * 给你一个整数数组 arr 。请你返回和为 奇数 的子数组数目。
 * 由于答案可能会很大，请你将结果对 10^9 + 7 取余后返回。
 * @Author: caffebaby
 * @Date: 2020/7/27
 */

public class Solution2 {

    //LTE O(n^2)，子数组的奇数个数为奇数时，其和才为奇数
    public static int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int[] odd = new int[n];//[0,i]的奇数个数
        odd[0] = arr[0] % 2 == 0 ? 0 : 1;
//        int[] sub_odd = new int[n * (n + 1) / 2];//数组太大,存不了
        int[] sub_odd = new int[n + 1];//储存频数，最多有n个奇数
        sub_odd[odd[0]]++;
        for (int i = 1; i < odd.length; i++) {
            if (arr[i] % 2 != 0) odd[i] = odd[i - 1] + 1;
            else odd[i] = odd[i - 1];

            sub_odd[odd[i]]++;
            for (int j = 0; j <= i - 1; j++)
                sub_odd[odd[i] - odd[j]]++;
        }

        int res = 0;
        for (int i = 0; i < sub_odd.length; i++)
            if (i % 2 != 0)
                res += sub_odd[i];
        return res;
    }

    //O(n)
    public int numOfSubarrays2(int[] arr) {
        int sum = 0;
        for (int i = 0, odd = 0; i < arr.length; ++i) {
            if (arr[i] % 2 == 1)
                odd = i - odd + 1;
            sum = (sum + odd) % 1000000007;
        }
        return sum;
    }

    //前缀和,O(n)，
    //cur = 0如果当前前缀总和是偶数，
    //cur = 1并且当前前缀总和是奇数，
    //count[0]则偶数前缀总和
    //count[1]的数量是奇数前缀总和的数量
    //
    //对于：数组A中的每个元素：
    //如果当前前缀和为偶数，则res + =奇数前缀和的数量；
    //如果当前前缀和为奇数，则res + =偶数前缀和的数量
    public int numOfSubarrays3(int[] A) {
        int cur = 0, res = 0, count[] = {1, 0}, mod = (int)1e9 + 7;
        for (int a: A) {
            cur ^= a & 1;
            res = (res + count[1 - cur]) % mod;
            count[cur]++;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7};
        int[] arr4 = {100, 100, 99, 99};
        int[] arr5 = {7};
        System.out.println(numOfSubarrays(arr1));//4
        System.out.println(numOfSubarrays(arr2));//0
        System.out.println(numOfSubarrays(arr3));//16
        System.out.println(numOfSubarrays(arr4));//4
        System.out.println(numOfSubarrays(arr5));//1
    }
}
