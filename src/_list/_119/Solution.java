package _list._119;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 119. 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * @Author: matreeix
 * @Date: 2019/8/9 22:42
 */
public class Solution {
    public static List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> row = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++)
                row.set(j, row.get(j) + row.get(j + 1));

        }
        return row;

    }


    public static void main(String[] args) {
        int rowIndx = 3;
        System.out.println(getRow(rowIndx));
    }
}
