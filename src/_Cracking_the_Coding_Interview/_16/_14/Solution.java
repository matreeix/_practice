package _Cracking_the_Coding_Interview._16._14;

/**
 * @Description: 面试题 16.14. 最佳直线
 * 给定一个二维平面及平面上的 N 个点列表Points，其中第i个点的坐标为Points[i]=[Xi,Yi]。请找出一条直线，其通过的点的数目最多。
 * <p>
 * 设穿过最多点的直线所穿过的全部点编号从小到大排序的列表为S，你仅需返回[S[0],S[1]]作为答案，若有多条直线穿过了相同数量的点，
 * 则选择S[0]值较小的直线返回，S[0]相同则选择S[1]值较小的直线返回。
 * @Author: matreeix
 * @Date: 2020/11/6
 */

public class Solution {
    public int[] bestLine(int[][] points) {
        int[] res = new int[2];   //用来存满足条件的两个点
        int cnt;            //记录直线穿过点的数量
        int maxp = 0;         //记录cnt的最大值
        int n = points.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                cnt = 2;//先确定两个点
                if (n - 1 - j + 1 + 1 <= maxp)
                    break;
                long x1 = points[j][0] - points[i][0];
                long y1 = points[j][1] - points[i][1];
                for (int k = j + 1; k < n; k++) {//不断更新第三个点
                    long x2 = points[k][0] - points[i][0];
                    long y2 = points[k][1] - points[i][1];
                    if (x1 * y2 == x2 * y1)//判断两个向量，即三点是否共线
                        cnt++;
                }
                if (cnt > maxp) {//更新最优解
                    maxp = cnt;
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
}
