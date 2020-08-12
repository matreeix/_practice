package _CONTEST._weekly._198;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 1521. 找到最接近目标值的函数值
 * <p>
 * Winston 构造了一个如上所示的函数 func 。他有一个整数数组 arr 和一个整数 target ，
 * 他想找到让 |func(arr, l, r) - target| 最小的 l 和 r 。
 * <p>
 * 请你返回 |func(arr, l, r) - target| 的最小值。
 * 请注意， func 的输入参数 l 和 r 需要满足 0 <= l, r < arr.length。
 *
 * 提示：
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^6
 * 0 <= target <= 10^7
 *
 * @Author: matreeix
 * @Date: 2020/7/19
 */

public class Solution4 {
    //暴力解法
    public static int closestToTarget(int[] arr, int target) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                res = Math.min(res, Math.abs(func(arr, i, j) - target));
            }
        }
        return res;
    }

    private static int func(int[] arr, int l, int r) {
        if (l > r) return -1000_000_000;
        int ans = arr[l];
        for (int i = l + 1; i <= r; i++) {
            ans &= arr[i];
        }
        return ans;
    }

    //O(N^2),模拟法， c = a & b,则c<a且c<b
    public int closestToTarget2(int[] arr, int target) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int ans = arr[i];
            for (int j = i; j < arr.length; j++) {
                ans &= arr[j];
                res = Math.min(res, Math.abs(ans - target));
                if (res == 0)//0是最好的结果
                    return res;
                if (ans < target)//再进行与运算只会更小
                    break;
            }
            if (ans > target)//后面进行与运算只会更大
                break;
        }
        return res;
    }

    //O(N)
    public int closestToTarget3(int[] arr, int target) {
        int res = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> tmp = new HashSet<>();
            tmp.add(arr[i]);
            for (int n : set)
                tmp.add(n & arr[i]);
            for (int n : tmp)
                res = Math.min(res, Math.abs(n - target));
            set = tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 8, 16};
        int target = 0;

        System.out.println(closestToTarget(arr, target));
//        System.out.println(1234 & 2345);
//        System.out.println(-10 & -19);
//        System.out.println(-2 & -5);
//        for (int i = -1; i > -10000; i--) {
//            for (int j = i - 1; j > -10000; j--) {
//                if ((i & j) > i || (i & j) > j) {
//                    System.out.println("i:" + i + " j:" + j);
//                }
//
//                if ((i & j) > 0) {
//                    System.out.println("i:" + i + " j:" + j);
//                }
//            }
//        }


    }
}