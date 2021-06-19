package _leetcode._Cracking_the_Coding_Interview._17._14;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description: 面试题 17.14. 最小K个数
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * @Author: matreeix
 * @Date: 2020/12/20
 */

public class Solution {
    //小根堆,30ms
    public int[] smallestK(int[] arr, int k) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int i : arr)
            q.add(i);
        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = q.poll();
        }
        return res;
    }

    //排序法，7ms
    public int[] smallestK2(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    //快排法
    public int[] smallestK3(int[] arr, int k) {
        return soluByQsort(arr,k);
    }
    private int[] soluByQsort(int[] arr, int k){
        if (k >= arr.length) { return arr; }

        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int d = partition(arr,left, right);
            if(d == k - 1){
                break;
            }
            if(d > k - 1){
                right = d - 1;
            }else if(d < k - 1){
                left = d + 1;
            }
        }
        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;

    }

    private int partition(int[] arr, int start, int end){
        int tmp = arr[start];
        while(start < end){
            //先右边
            while(end > start && arr[end] > tmp){
                end--;
            }
            //当比其少了，替换
            if(start < end){
                //直接赋值即可，start已备份,
                arr[start] = arr[end];
                //只备份了一个
                start++;
            }
            //下面再看左边
            while (start < end && arr[start] < tmp){
                start++;
            }
            //左边不满足了；比其大了
            if(start < end){
                //上面的end已经被赋值到了tmp的坑，所以这个可以直接赋值不会丢
                arr[end] = arr[start];
                end--;
            }
        }
        //循环最后是start
        arr[start] = tmp;
        return start;
    }

}
