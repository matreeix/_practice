package _leetcode._CONTEST._weekly._271;

/**
 * @Description: 5952. 环和杆
 * 总计有 n 个环，环的颜色可以是红、绿、蓝中的一种。这些环分布穿在 10 根编号为 0 到 9 的杆上。
 * 给你一个长度为 2n 的字符串 rings ，表示这 n 个环在杆上的分布。rings 中每两个字符形成一个 颜色位置对 ，用于描述每个环：
 * 第 i 对中的 第一个 字符表示第 i 个环的 颜色（'R'、'G'、'B'）。
 * 第 i 对中的 第二个 字符表示第 i 个环的 位置，也就是位于哪根杆上（'0' 到 '9'）。
 * 例如，"R3G2B1" 表示：共有 n == 3 个环，红色的环在编号为 3 的杆上，绿色的环在编号为 2 的杆上，蓝色的环在编号为 1 的杆上。
 * 找出所有集齐 全部三种颜色 环的杆，并返回这种杆的数量
 * 提示：
 * rings.length == 2 * n
 * 1 <= n <= 100
 * 如 i 是 偶数 ，则 rings[i] 的值可以取 'R'、'G' 或 'B'（下标从 0 开始计数）
 * 如 i 是 奇数 ，则 rings[i] 的值可以取 '0' 到 '9' 中的一个数字（下标从 0 开始计数）
 * @Date: 2021/12/12
 */

public class Solution1 {
    public int countPoints(String rings) {
        int[] res = new int[10];
        for (int i = 0; i < rings.length(); i += 2) {
            if (rings.charAt(i) == 'R' && res[rings.charAt(i + 1) - '0'] % 10 != 1) {
                res[rings.charAt(i + 1) - '0'] += 1;
            } else if (rings.charAt(i) == 'G' && (res[rings.charAt(i + 1) - '0'] / 10) % 10 != 1) {
                res[rings.charAt(i + 1) - '0'] += 10;
            } else if (rings.charAt(i) == 'B' && (res[rings.charAt(i + 1) - '0'] / 100) % 10 != 1) {
                res[rings.charAt(i + 1) - '0'] += 100;
            }
        }
        int ans = 0;
        for (int i : res)
            if (i == 111)
                ans++;
        return ans;
    }

    public int countPoints2(String rings) {
        int[] rods = new int[10];
        for (int i = 0; i < rings.length(); i += 2) {
            int color = rings.charAt(i) == 'R' ? 1 : rings.charAt(i) == 'G' ? 2 : 4;
            rods[rings.charAt(i + 1) - '0'] |= color;
        }
        int ans = 0;
        for (int i : rods)
            if (i == 7)
                ans++;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println((new Solution1()).countPoints("G4"));
    }
}
