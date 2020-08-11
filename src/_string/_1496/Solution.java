package _string._1496;

import javafx.util.Pair;

import java.util.*;

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
 * @Author: caffebaby
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

    //错误解答
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
            if (N == S && E == W)//只能判断是否返回原点
                return true;
        }
        return false;
    }

    //优秀解答，妙啊，状态压缩
    public boolean isPathCrossing3(String path) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(0);
        int x = 0, y = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'N')
                x += 1;
            else if (path.charAt(i) == 'S')
                x -= 1;
            else if (path.charAt(i) == 'E')
                y += 1;
            else
                y -= 1;

            if (al.contains(x + y * (path.length() + 1)))
                return true;
            else
                al.add(x + y * (path.length() + 1));
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "NES";
        String s2 = "NESWW";
        String s3 = "NENESW";
        System.out.println((new Solution()).isPathCrossing(s1));
        System.out.println((new Solution()).isPathCrossing(s2));
        System.out.println((new Solution()).isPathCrossing2(s3));
        System.out.println((new Solution()).isPathCrossing(s3));
        System.out.println((new Solution()).isPathCrossing3(s3));
    }

}
