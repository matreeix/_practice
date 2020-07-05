package _string._1496;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description: 判断路径是否相交
 * <p>
 * 给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
 * 机器人从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
 * 如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。
 * <p>
 * 注意：
 * 1. 1 <= path.length <= 10^4
 * 2. path 仅由 {'N', 'S', 'E', 'W} 中的字符组成
 * @Author: Pythagodzilla
 * @Date: 2020/7/5
 */

public class Solution {
    public boolean isPathCrossing(String path) {
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Map<Character, Integer> map = new HashMap<>();
        map.put('N', 0);
        map.put('S', 1);
        map.put('E', 2);
        map.put('W', 3);
        Set<Pair<Integer, Integer>> points = new HashSet<>();
        points.add(new Pair<>(0, 0));
        int x = 0, y = 0;
        for (char ch : path.toCharArray()) {
            int newX = x + dir[map.get(ch)][0];
            int newY = y + dir[map.get(ch)][1];
            Pair<Integer, Integer> newPoint = new Pair<>(newX, newY);
            if (points.contains(newPoint))
                return true;
            else
                points.add(newPoint);
            x = newX;
            y = newY;
        }
        return false;
    }

    //优秀解答
    public boolean isPathCrossing2(String path) {
        if (path.contains("NS") || path.contains("SN") || path.contains("EW") || path.contains("WE"))
            return true;
        char[] pat = path.toCharArray();
        int N = 0;
        int S = 0;
        int E = 0;
        int W = 0;
        for (int i = 0; i < pat.length; i++) {
            switch (pat[i]) {
                case 'N':
                    N++;
                    break;
                case 'S':
                    S++;
                    break;
                case 'E':
                    E++;
                    break;
                case 'W':
                    W++;
                    break;
            }
            if (N == S && E == W)//统计相反步数，妙啊！
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "NES";
        String s2 = "NESWW";
        System.out.println((new Solution()).isPathCrossing(s1));
        System.out.println((new Solution()).isPathCrossing(s2));
    }

}
