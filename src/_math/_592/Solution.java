package _math._592;

/**
 * @Description: 592. 分数加减运算
 * 给定一个表示分数加减运算表达式的字符串，你需要返回一个字符串形式的计算结果。 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。
 * <p>
 * 说明:
 * <p>
 * 输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。 
 * 输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。
 * 输入只包含合法的最简分数，每个分数的分子与分母的范围是  [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。
 * 输入的分数个数范围是 [1,10]。
 * 最终结果的分子与分母保证是 32 位整数范围内的有效整数。
 * @Created by: matreeix
 * @Date: 2021/6/2
 */
public class Solution {

    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    public String fractionAddition(String expression) {
        if (expression.charAt(0) != '-') expression = "+" + expression;
        int[][] tmp = new int[11][3];
        int idx = -1;
        boolean flag = false;
        for (char ch : expression.toCharArray()) {
            switch (ch) {
                case '+':
                    tmp[++idx][0] = 1;
                    flag = false;
                    break;
                case '-':
                    tmp[++idx][0] = -1;
                    flag = false;
                    break;
                case '/':
                    flag = true;
                    break;
                default:
                    if (!flag)
                        tmp[idx][1] = tmp[idx][1] * 10 + (ch - '0');
                    else
                        tmp[idx][2] = tmp[idx][2] * 10 + (ch - '0');
                    break;
            }
        }
        int a = 0, b = 1;
        for (int i = 0; tmp[i][0] != 0; i++) {
            b *= tmp[i][2];
        }
        for (int i = 0; tmp[i][0] != 0; i++) {
            a = tmp[i][0] == 1 ? a + tmp[i][1] * (b / tmp[i][2]) : a - tmp[i][1] * (b / tmp[i][2]);
        }
        StringBuilder sb = new StringBuilder();
        int gcd = gcd(Math.abs(a), b);
        sb.append(a / gcd);
        sb.append("/");
        sb.append(b / gcd);
        return sb.toString();
    }
}
