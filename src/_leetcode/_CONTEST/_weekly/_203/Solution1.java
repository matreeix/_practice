package _leetcode._CONTEST._weekly._203;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 5495. 圆形赛道上经过次数最多的扇区
 * <p>
 * 给你一个整数 n 和一个整数数组 rounds 。有一条圆形赛道由 n 个扇区组成，扇区编号从 1 到 n 。
 * 现将在这条赛道上举办一场马拉松比赛，该马拉松全程由 m 个阶段组成。其中，第 i 个阶段将会从扇区 rounds[i - 1] 开始，
 * 到扇区 rounds[i] 结束。举例来说，第 1 阶段从 rounds[0] 开始，到 rounds[1] 结束。
 * 请你以数组形式返回经过次数最多的那几个扇区，按扇区编号 升序 排列。
 * 注意，赛道按扇区编号升序逆时针形成一个圆（请参见第一个示例）。
 * @Author: matreeix
 * @Date: 2020/8/23
 */

public class Solution1 {

    public List<Integer> mostVisited(int n, int[] A) {
        List<Integer> res = new ArrayList<>();
        for (int i = A[0]; i <= A[A.length - 1]; ++i)
            res.add(i);
        if (res.size() > 0) return res;
        for (int i = 1; i <= A[A.length - 1]; ++i)
            res.add(i);
        for (int i = A[0]; i <= n; ++i)
            res.add(i);
        return res;
    }
}
