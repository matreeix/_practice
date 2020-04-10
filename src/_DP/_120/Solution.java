package _DP._120;

import java.util.ArrayList;
import java.util.List;

/**
 * @description ：杨辉三角求最小和
 * @date ： 2020-04-10
 */
public class Solution {
    //自顶向下
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int[][] mem = new int[height][height];//记录到达每个值时取得的最小和
        mem[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < height; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0)
                    mem[i][j] = mem[i - 1][j] + triangle.get(i).get(j);//最左边的数
                else if (j == i)
                    mem[i][j] = mem[i - 1][j - 1] + triangle.get(i).get(j);//最右边的数
                else
                    mem[i][j] = Math.min(mem[i - 1][j], mem[i - 1][j - 1]) + triangle.get(i).get(j);
            }
        }

        int max = Integer.MAX_VALUE;
        for (int i : mem[height - 1])
            max = Math.min(max, i);

        return max;
    }

    //自底向上
    public int minimumTotal2(List<List<Integer>> triangle) {
        int[] layer = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                layer[j] = Math.min(layer[j], layer[j + 1]) + triangle.get(i).get(j);
            }
        }
        return layer[0];
    }


    public static void main(String[] args) {
//              [2],
//              [3,4],
//              [6,5,7],
//              [4,1,8,3]
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        list1.add(2);
        list2.add(3);
        list2.add(4);
        list3.add(6);
        list3.add(5);
        list3.add(7);
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(0, list1);
        lists.add(1, list2);
        lists.add(2, list3);
        lists.add(3, list4);
        System.out.println(lists);
        System.out.println((new Solution()).minimumTotal(lists));
    }
}
