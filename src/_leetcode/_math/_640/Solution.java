package _leetcode._math._640;

/**
 * @Description: 方程求解
 * <p>
 * 求解一个给定的方程，将x以字符串"x=#value"的形式返回。该方程仅包含'+'，' - '操作，变量 x 和其对应系数。
 * <p>
 * 如果方程没有解，请返回“No solution”。
 * 如果方程有无限解，则返回“Infinite solutions”。
 * 如果方程中只有一个解，要保证返回值 x 是一个整数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/solve-the-equation
 * @Author: matreeix
 * @Date: 2020/5/31
 */
public class Solution {
    public String solveEquation(String equation) {
        if (equation == null || equation.length() == 0)
            return "No solution";
        int mark = equation.indexOf('=');
        String Lequ = equation.substring(0, mark);
        String Requ = equation.substring(mark + 1);
        int[] l = simplifyEqu(Lequ);
        int[] r = simplifyEqu(Requ);
        if (l[0] == r[0] && l[1] == r[1])
            return "Infinite solutions";
        else if (l[0] == r[0] && l[1] != r[1])
            return "No solution";
        else
            return "x=" + (r[1] - l[1]) / (l[0] - r[0]);
    }

    //化简方程左右两边为a * x + b形式
    private int[] simplifyEqu(String equ) {//kx+mx+c-d
        int[] res = new int[2];
        int a = 0, b = 0;
        String[] add_split = equ.split("\\+");//根据加法结合律
        for (String str : add_split) {
            if (str.contains("-")) {//若子串还含有减号运算符，继续划分粒度
                String[] sub_split = str.split("-");
                if (sub_split[0].length() != 0) {//第一个元素特殊处理
                    a = calRes(sub_split[0], a, b, 1)[0];
                    b = calRes(sub_split[0], a, b, 1)[1];
                }
                for (int i = 1; i < sub_split.length; i++) {
                    a = calRes(sub_split[i], a, b, 2)[0];
                    b = calRes(sub_split[i], a, b, 2)[1];
                }
            } else {
                a = calRes(str, a, b, 1)[0];
                b = calRes(str, a, b, 1)[1];
            }
        }
        return new int[]{a, b};
    }

    //计算每一个不可分割元素，mark为1是加，mark为2是减
    private int[] calRes(String ele, int a, int b, int mark) {
        if (ele == null || ele.length() == 0)
            System.out.println("输入数据出错");
        if (ele.contains("x")) {
            if (mark == 1)
                //对于"x"的情况要特殊处理
                a += (ele.length() > 1 ? Integer.valueOf(ele.substring(0, ele.length() - 1)) : 1);
            else
                a -= (ele.length() > 1 ? Integer.valueOf(ele.substring(0, ele.length() - 1)) : 1);
        } else {
            if (mark == 1)
                b += Integer.valueOf(ele);
            else
                b -= Integer.valueOf(ele);
        }
        return new int[]{a, b};
    }


    //性能较好的解答
    public String solveEquation2(String equation) {
        if (equation == null || equation.length() == 0) {
            return equation;
        }

        int equalIndex = equation.indexOf('=');
        int count = 0;//记录数值，包括数字和未知数的系数
        int left = 0;//记录"x"的系数
        int right = 0;//记录数字的值
        char alpha = 'x';
        int flag = 1;//'+'和'-'的标志
        boolean isZero = false;//处理"0x=0"的特殊情况
        for (int i = 0; i < equation.length(); i++) {
            char c = equation.charAt(i);
            if (c >= '0' && c <= '9') {//字符为数字
                count *= 10;
                count += c - '0';
                if (count==0)
                    isZero = true;
                if (i == equation.length() - 1)
                    right += flag * count;
            } else if (c >= 'a' && c <= 'z') {//字符为字母的情况
                alpha = c;
                // a + 3 = 2
                count = (count == 0) ? (isZero ? 0 : 1) : count;//对"x"特殊处理
                left += flag * ((i <= equalIndex) ? count : (-1) * count);
                count = 0;
                flag = 1;
                isZero = false;
            } else if (c == '+' || c == '-' || c == '=') {//字符为运算符的情况，处理数字
                if (i >= 1) {
                    char pre = equation.charAt(i - 1);
                    if (!(pre >= 'a' && pre <= 'z')) {//数字的情况
                        right += flag * ((i <= equalIndex) ? (-1) * count : count);
                        count = 0;
                        flag = 1;
                        isZero = false;
                    }
                }

                if (c == '-') {
                    flag = -1;
                }
            }
        }

        if (left == 0) {
            if (right == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        }

        int res = right / left;
        StringBuilder builder = new StringBuilder();
        builder.append(alpha).append('=').append(String.valueOf(res));
        return builder.toString();
    }

    public static void main(String[] args) {
//        String equ = "x+5-3+x=6+x-2";
//        String equ = "x=x";
//        String equ = "x=x+2";
        String equ = "0x=0";
        System.out.println((new Solution()).solveEquation2(equ));


    }
}
