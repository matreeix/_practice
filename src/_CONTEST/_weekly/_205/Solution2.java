package _CONTEST._weekly._205;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 5508. 数的平方等于两数乘积的方法数
 * 给你两个整数数组 nums1 和 nums2 ，请你返回根据以下规则形成的三元组的数目（类型 1 和类型 2 ）：
 * 类型 1：三元组 (i, j, k) ，如果 nums1[i]^2 == nums2[j] * nums2[k] 其中 0 <= i < nums1.length 且 0 <= j < k < nums2.length
 * 类型 2：三元组 (i, j, k) ，如果 nums2[i]^2 == nums1[j] * nums1[k] 其中 0 <= i < nums2.length 且 0 <= j < k < nums1.length
 * <p>
 * 提示：
 * 1 <= nums1.length, nums2.length <= 1000
 * 1 <= nums1[i], nums2[i] <= 10^5
 * @Author: matreeix
 * @Date: 2020/9/6
 */

public class Solution2 {
    public int numTriplets(int[] nums1, int[] nums2) {
        return countForArray(nums1, nums1) + countForArray(nums1, nums1);
    }

    private int countForArray(int[] n1, int[] n2) {
        int res = 0, last_res = 0, last_n = 0;
        Arrays.sort(n1);
        for (int i = 0; i < n1.length; last_n = n1[i++])
            if (n1[i] == last_n) res += last_res;
            else res += last_res = twoProduct((long) n1[i] * n1[i], n2);
        return res;
    }

    private int twoProduct(long i, int[] n) {
        Map<Long, Long> m = new HashMap<>();
        int cnt = 0;
        for (long v : n) {
            if (i % v == 0)
                cnt += m.getOrDefault(i / v, 0l);
            m.put(v, m.getOrDefault(v, 0l) + 1);
        }
        return cnt;
    }

}
