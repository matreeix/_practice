package _array._506;

import java.util.Arrays;

/**
 * @Description: 506. 相对名次
 * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
 * (注：分数越高的选手，排名越靠前。)
 * @Date: 2021/3/26
 */

public class Solution {

    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[] tmp = new int[n];//状态压缩数组
        for (int i = 0; i < n; i++) {
            tmp[i] = score[i] * 10000 + i;
        }
        Arrays.sort(tmp);
        String[] res = new String[n];
        for (int i = n - 1; i >= 0; i--) {
            int idx = tmp[i] % 10000;
            if (i == n - 1)
                res[idx] = "Gold Medal";
            else if (i == n - 2)
                res[idx] = "Silver Medal";
            else if (i == n - 3)
                res[idx] = "Bronze Medal";
            else
                res[idx] = n - i + "";
        }
        return res;
    }

    public String[] findRelativeRanks2(int[] score) {
        int n = score.length;
        String[] result = new String[n];
        int max = 0;
        for (int num : score) {
            if (max < num) {
                max = num;
            }
        }
        int[] array = new int[max + 1];
        for (int i = 0; i < n; i++) {
            array[score[i]] = i + 1;
        }
        int count = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] != 0) {
                switch (count) {
                    case 1:
                        result[array[i] - 1] = "Gold Medal";
                        break;
                    case 2:
                        result[array[i] - 1] = "Silver Medal";
                        break;
                    case 3:
                        result[array[i] - 1] = "Bronze Medal";
                        break;
                    default:
                        result[array[i] - 1] = String.valueOf(count);
                }
                count++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] s = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(findRelativeRanks(s)));
    }

}
