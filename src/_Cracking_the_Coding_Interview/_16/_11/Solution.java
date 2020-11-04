package _Cracking_the_Coding_Interview._16._11;

import java.util.Collections;

/**
 * @Description: 面试题 16.11. 跳水板
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 * <p>
 * 返回的长度需要从小到大排列。
 * 提示：
 * <p>
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 * @Author: matreeix
 * @Date: 2020/11/4
 */

public class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[0];
        if (shorter == longer) return new int[]{k * shorter};
        int[] res = new int[k + 1];
        for (int i = 0; i < res.length; i++)
            res[i] = (k - i) * shorter + i * longer;
        return res;
    }

}
