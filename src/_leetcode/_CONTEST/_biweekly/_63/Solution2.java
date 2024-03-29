package _leetcode._CONTEST._biweekly._63;

/**
 * @Description: 5886. 如果相邻两个颜色均相同则删除当前颜色
 * 总共有 n 个颜色片段排成一列，每个颜色片段要么是 'A' 要么是 'B' 。给你一个长度为 n 的字符串 colors ，其中 colors[i] 表示第 i 个颜色片段的颜色。
 * Alice 和 Bob 在玩一个游戏，他们 轮流 从这个字符串中删除颜色。Alice 先手 。
 * 如果一个颜色片段为 'A' 且 相邻两个颜色 都是颜色 'A' ，那么 Alice 可以删除该颜色片段。Alice 不可以 删除任何颜色 'B' 片段。
 * 如果一个颜色片段为 'B' 且 相邻两个颜色 都是颜色 'B' ，那么 Bob 可以删除该颜色片段。Bob 不可以 删除任何颜色 'A' 片段。
 * Alice 和 Bob 不能 从字符串两端删除颜色片段。
 * 如果其中一人无法继续操作，则该玩家 输 掉游戏且另一玩家 获胜 。
 * 假设 Alice 和 Bob 都采用最优策略，如果 Alice 获胜，请返回 true，否则 Bob 获胜，返回 false。
 * 提示：
 * 1 <= colors.length <= 10^5
 * colors 只包含字母 'A' 和 'B'
 * @Date: 2021/10/16
 */

public class Solution2 {
    public static boolean winnerOfGame(String colors) {
        int n = colors.length();
        if (n < 3) return false;
        int a = 0;//Alice可以删除的次数
        int b = 0;//Bob可以删除的次数
        int cnt = 1;
        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                cnt++;
            } else {
                if (cnt > 2) {
                    a += colors.charAt(i - 1) == 'A' ? cnt - 2 : 0;
                    b += colors.charAt(i - 1) == 'B' ? cnt - 2 : 0;
                }
                cnt = 1;
            }
        }

        if (cnt > 2) {
            a += colors.charAt(n - 1) == 'A' ? cnt - 2 : 0;
            b += colors.charAt(n - 1) == 'B' ? cnt - 2 : 0;
        }


        if (a > b) {
            return true;
        } else {
            return false;
        }
    }

    public boolean winnerOfGame2(String s) {
        int a = 0, b = 0;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i + 1)) {
                if (s.charAt(i) == 'A')
                    a++;
                else
                    b++;
            }
        }
        return a > b;
    }

    public static void main(String[] args) {
        String s1 = "AAAABBBB";
        String s2 = "BBBBAAAA";
        String s3 = "AAA";
        String s4 = "BBBAAAABB";
//        System.out.println(winnerOfGame(s1));
//        System.out.println(winnerOfGame(s2));
//        System.out.println(winnerOfGame(s3));
        System.out.println(winnerOfGame(s4));
    }
}
