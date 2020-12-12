package _Cracking_the_Coding_Interview._17._08;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description: 面试题 17.08. 马戏团人塔
 * 有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。
 * 出于实际和美观的考虑，在上面的人要比下面的人矮一点且轻一点。已知马戏团每个人的身高和体重，请编写代码计算叠罗汉最多能叠几个人。
 * 提示：
 * <p>
 * height.length == weight.length <= 10000
 * @Author: matreeix
 * @Date: 2020/12/11
 */

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    //俄罗斯信封套娃问题
    public int maxEnvelopes(int[][] envelopes) {
        // sort on increasing in first dimension and decreasing in second
        Arrays.sort(envelopes, (arr1, arr2) -> {
            if (arr1[0] == arr2[0]) return arr2[1] - arr1[1];
            else return arr1[0] - arr2[0];
        });
        // extract the second dimension and run LIS
        int[] secondDim = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; ++i)
            secondDim[i] = envelopes[i][1];
        return lengthOfLIS(secondDim);
    }

    //79ms
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int[][] tmp = new int[height.length][2];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i][0] = height[i];
            tmp[i][1] = weight[i];
        }
        return maxEnvelopes(tmp);
    }

    //22ms
    static final int BIT = 14;
    static final int BASE = (1 << BIT) - 1;
    public int bestSeqAtIndex2(int[] height, int[] weight) {
        int N = height.length;
        for (int i = 0; i < N; i++) {
            height[i] = (height[i] << BIT) + (BASE - weight[i]);
        }
        Arrays.sort(height);
        int[] dp = new int[N];
        int R = 0;
        for (int num: height) {
            if (insert(dp, R - 1, BASE - (num & BASE)) == R) R++;
        }
        return R;
    }

    public int insert(int[] A, int R, int num) {
        if (R >= 0 && A[R] < num) {
            A[R + 1] = num;
            return R + 1;
        }
        int L = 0;
        while (L < R) {
            int mid = L + R >> 1;
            if (A[mid] < num) L = mid + 1;
            else R = mid;
        }
        A[L] = num;
        return L;
    }

}





