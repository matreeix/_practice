package _leetcode._search._475;

import java.util.Arrays;

/**
 * @Description: 找出加热器的最小半径可以加热所有屋子
 * <p>
 * 1.对于每个house，找到它们之间的位置heaters（因此我们需要对heaters数组进行排序）。
 * 2.计算距离house的距离，左heater，右heater，获得了MIN这两个值的平均值。边界处没有左加热器或右加热器。
 * 3.MAX在步骤2中更新获得距离之间的值。
 * <p>
 * 时间复杂度：max（O（nlogn），O（mlogn）），m是房屋的长度，n是加热器的长度。
 * @Author: matreeix
 * @Date: 2020/3/13
 */
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;

        for (int house : houses) {
            //Arrays.binarySearch(arr,key),key在arr里，返回key在arr里的索引；
            //key不在arr里时，返回插入arr后key对应的-(index+1),最右边还要-1
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = -(index + 1);
            }
            //设heaters数组极值为min和max
            int dist1 = index - 1 >= 0
                    ? house - heaters[index - 1] //house在[min,max]
                    : Integer.MAX_VALUE;//house<min
            int dist2 = index < heaters.length
                    ? heaters[index] - house//house在[min,max]
                    : Integer.MAX_VALUE;//house>max

            result = Math.max(result, Math.min(dist1, dist2));
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6,7};
        int key1 = 0;
        int key2 = 3;
        int key3 = 5;
        int key4 = 8;
        //index均为插入之后的对应索引
        System.out.println(Arrays.binarySearch(arr,key1));//-(index+1)
        System.out.println(Arrays.binarySearch(arr,key2));//index
        System.out.println(Arrays.binarySearch(arr,key3));//-(index+1)
        System.out.println(Arrays.binarySearch(arr,key4));//-arr.length-1

    }

}
