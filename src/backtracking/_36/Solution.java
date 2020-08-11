package backtracking._36;

import java.util.*;

/**
 * @Description: 判断数独的有效性
 * <p>
 * 1. 每行必须包含数字，1-9不能重复。
 * 2.每列必须包含数字，1-9 不能重复。
 * 3.3x3网格的9个子框中的每个必须包含数字，且1-9不能重复。
 * @Author: caffebaby
 * @Date: 2019/10/17 0:10
 */
public class Solution {

    public boolean isValidSudoku2(char[][] board) {
        Set seen = new HashSet();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i / 3 + "-" + j / 3))
                        return false;
            }
        }
        return true;
    }


    public static boolean isValidSudoku(char[][] strings) {
        int len = strings.length;
        char[] tmp1 = new char[9];
        char[] tmp2 = new char[9];
        char[] tmp3 = new char[9];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                tmp1[j] = strings[j][i];//行数
                tmp2[j] = strings[i][j];//列数
            }
            if (!isValid(tmp1) || !isValid(tmp2)) return false;

        }
        for (int k = 0; k < 7; k = k + 3) {//格子
            int num = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    tmp1[num] = strings[i + k][j];
                    tmp2[num] = strings[i][j + k];
                    tmp3[num] = strings[i + k][j + k];
                    num++;
                }
            }
            System.out.println(k);
            if (!isValid(tmp1) || !isValid(tmp2) || !isValid(tmp3)) return false;
        }
        return true;
    }

    public static boolean isValid(char[] chars) {//验证是否有效
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : chars) {
            if (map.get(ch) == null)
                map.put(ch, 1);
            else if (ch == '.')
                map.put('.', 1 + map.get('.'));
            else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        char[][] strings = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        char[][] strings2 = {
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };

        char[][] strings3 = {
                {'.', '.', '.', '.', '.', '.', '5', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'9', '3', '.', '.', '2', '.', '4', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '3', '4', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '5', '2', '.', '.'}
        };

//        System.out.println(isValidSudoku(strings));
//        System.out.println(isValidSudoku(strings2));
        System.out.println(isValidSudoku(strings3));
    }
}
