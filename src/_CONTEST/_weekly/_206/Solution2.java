package _CONTEST._weekly._206;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 1583. 统计不开心的朋友
 * 给你一份 n 位朋友的亲近程度列表，其中 n 总是 偶数 。
 * 对每位朋友 i，preferences[i] 包含一份 按亲近程度从高到低排列 的朋友列表。换句话说，排在列表
 * 前面的朋友与 i 的亲近程度比排在列表后面的朋友更高。每个列表中的朋友均以 0 到 n-1 之间的整数表示。
 * 所有的朋友被分成几对，配对情况以列表 pairs 给出，其中 pairs[i] = [xi, yi] 表示 xi 与 yi 配对，
 * 且 yi 与 xi 配对。
 * 但是，这样的配对情况可能会使其中部分朋友感到不开心。在 x 与 y 配对且 u 与 v 配对的情况下，
 * 如果同时满足下述两个条件，x 就会不开心：
 *
 * 1.x 与 u 的亲近程度胜过 x 与 y，且
 * 2.u 与 x 的亲近程度胜过 u 与 v
 * 返回 不开心的朋友的数目 。
 * @Author: matreeix
 * @Date: 2020/9/16
 */

public class Solution2 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[] map = new int[n];
        for(int[] pair: pairs){ // Keep record of current matches.
            map[pair[0]] = pair[1];
            map[pair[1]] = pair[0];
        }
        int res = 0;

        Map<Integer, Integer>[] prefer = new Map[n]; // O(1) to fetch the index from the preference array.

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n-1; j++){
                if(prefer[i] == null)
                    prefer[i] = new HashMap<>();
                prefer[i].put(preferences[i][j], j);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j : preferences[i]){
                if(prefer[j].get(i) < prefer[j].get(map[j])
                        && prefer[i].get(map[i]) > prefer[i].get(j)){ // Based on the definition of "unhappy"...
                    res++;
                    break;
                }
            }
        }
        return res;
    }

}
