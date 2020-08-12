package _other._119;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
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
