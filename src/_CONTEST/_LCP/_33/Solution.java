package _CONTEST._LCP._33;

import java.util.PriorityQueue;

/**
 * @Description: LCP 33. 蓄水
 * 给定 N 个无限容量且初始均空的水缸，每个水缸配有一个水桶用来打水，第 i 个水缸配备的水桶容量记作 bucket[i]。小扣有以下两种操作：
 * 升级水桶：选择任意一个水桶，使其容量增加为 bucket[i]+1
 * 蓄水：将全部水桶接满水，倒入各自对应的水缸
 * 每个水缸对应最低蓄水量记作 vat[i]，返回小扣至少需要多少次操作可以完成所有水缸蓄水要求。
 *
 * 注意：实际蓄水量 达到或超过 最低蓄水量，即完成蓄水要求。
 * @Created by: matreeix
 * @Date: 2021/6/18
 */
public class Solution {
    public int storeWater(int[] bucket, int[] vat) {
        int max = 0;
        for (int v : vat) max = Math.max(max, v);
        if (max == 0) return 0;
        int n = bucket.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= 10000; i++) {//遍历倒水次数
            int per = 0;
            int cur = i;//倒水i次，所以操作次数+i
            for (int j = 0; j < n; j++) {//遍历每个水缸
                per = (vat[j] + i - 1) / i;// 水槽容量/倒水次数=每次倒水量
//+（i - 1）目的是为了向上取整(除完后如果有余数，加上i-1之后就一定会多商1，从而达到向上取整的功能)
//使用vat[j]%i==0 ? vat[j]/i : vat[j]/i+1 代替也行，但是更慢
                cur += Math.max(0, per - bucket[j]);// 每次倒水量-初始水量=需要升级次数
            }
            ans = Math.min(ans, cur);//所有倒水次数中，取最小的操作次数
        }
        return ans;
    }

    public int storeWater2(int[] bucket, int[] vat) {
        int count = 0;
        int len = bucket.length;
        for(int i = 0; i < len; i++) {
            if(bucket[i] == 0) {
                if(vat[i] != 0) {
                    count++;
                }
                bucket[i] = 1;
            }
        }
        PriorityQueue<BucketAndVat> queue = new PriorityQueue<>();
        for(int i = 0; i < len; i++) {
            queue.offer(new BucketAndVat(bucket[i], vat[i]));
        }
        int ans = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            BucketAndVat current = queue.poll();
            int bucketSize = current.bucketSize;
            int vatSize = current.vatSize;
            int times = vatSize / bucketSize + (vatSize % bucketSize == 0?0:1);
            if(count > ans) {
                break;
            }
            ans = Math.min(ans, times + count);
            current.bucketSize += 1;
            queue.offer(current);
            count++;
        }
        return ans;
    }

    private static class BucketAndVat implements Comparable {
        int bucketSize;

        int vatSize;

        BucketAndVat(int bucketSize, int vatSize) {
            this.bucketSize = bucketSize;
            this.vatSize = vatSize;
        }

        public int compareTo(Object o) {
            BucketAndVat oo = (BucketAndVat)o;
            int v1 = bucketSize * oo.vatSize;
            int v2 = vatSize * oo.bucketSize;
            if(v1 > v2) {
                return 1;
            }else if(v1 == v2) {
                return 0;
            }else {
                return -1;
            }
        }
    }

}
