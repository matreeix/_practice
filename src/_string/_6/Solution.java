package _string._6;

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 6. Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * @Author: caffebaby
 * @Date: 2020/8/6
 */

public class Solution {

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<Character>[] lists = new List[numRows];
        for (int i = 0; i < lists.length; i++)
            lists[i] = new ArrayList<>();
        int rows = 0;
        boolean add = true;
        for (char ch : s.toCharArray()) {
            if (add && rows < numRows - 1) {
                lists[rows++].add(ch);
            } else if (!add && rows > 0) {
                lists[rows--].add(ch);
            } else if (rows == numRows - 1) {
                lists[rows--].add(ch);
                add = false;
            } else if (rows == 0) {
                lists[rows++].add(ch);
                add = true;
            }
        }
        StringBuilder res = new StringBuilder();
        for (List<Character> list : lists)
            for (char ch : list)
                res.append(ch);
        return res.toString();
    }

    //力扣官方
    public String convert2(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    public String convert3(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++)
            sb[i] = new StringBuffer();

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows - 2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }


    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 3));//LCIRETOESIIGEDHN

    }
}
