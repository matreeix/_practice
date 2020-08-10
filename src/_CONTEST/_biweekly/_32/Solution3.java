package _CONTEST._biweekly._32;

/**
 * @Description: 5470. 平衡括号字符串的最少插入次数
 * 给你一个括号字符串 s ，它只包含字符 '(' 和 ')' 。一个括号字符串被称为平衡的当它满足：
 * 任何左括号 '(' 必须对应两个连续的右括号 '))' 。
 * 左括号 '(' 必须在对应的连续两个右括号 '))' 之前。
 * 比方说 "())"， "())(())))" 和 "(())())))" 都是平衡的， ")()"， "()))" 和 "(()))" 都是不平衡的。
 * <p>
 * 你可以在任意位置插入字符 '(' 和 ')' 使字符串平衡。
 * <p>
 * 请你返回让 s 平衡的最少插入次数。
 * @Author: Pythagodzilla
 * @Date: 2020/8/8
 */

public class Solution3 {
    //错误解法
    public static int minInsertions(String s) {
        int l = 0, r = 0, deadR = 0;
        int insert = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (l != 0 && r == 1) {//()(
                    l--;
                    insert++;
                    r = 0;
                }
                l++;
            } else if (ch == ')') {
                if (l == 0) {
                    deadR++;
                } else if (r == 0) {
                    r++;
                } else if (r == 1) {
                    r = 0;
                    l--;
                }
            }
        }
        if (l != 0)
            insert += (r == 1 ? 2 * l - 1 : 2 * l);
        if (deadR != 0) {
            insert += (deadR % 2 == 0 ? deadR / 2 : deadR / 2 + 2);
        }
        return insert;
    }

    public int minInsertions2(String s) {
        int res = 0, right = 0;//right表示所需的右括号的数量。
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                if (right % 2 == 1) {//注意，如果不需要两个连续的右括号，则不需要此部分。
                    right--;
                    res++;
                }
                right += 2;
            } else {
                right--;
                if (right < 0) {//需要添加一个左括号
                    right += 2;
                    res++;
                }
            }
        }
        return right + res;
    }


    public static void main(String[] args) {
//        System.out.println(minInsertions("(()))"));
//        System.out.println(minInsertions("())"));
//        System.out.println(minInsertions("))())("));
//        System.out.println(minInsertions("(((((("));
//        System.out.println(minInsertions(")))))))"));
        System.out.println(minInsertions(")"));//

    }
}
