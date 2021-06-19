package _leetcode._CONTEST._LCP._29;

/**
 * @Description: LCP 29. 乐团站位
 * 某乐团的演出场地可视作 num * num 的二维矩阵 grid（左上角坐标为 [0,0])，每个位置站有一位成员。乐团共有 9 种乐器，乐器编号为 1~9，每位成员持有 1 个乐器。
 * 为保证声乐混合效果，成员站位规则为：自 grid 左上角开始顺时针螺旋形向内循环以 1，2，...，9 循环重复排列。例如当 num = 5 时，站位如图所示
 * 1 2 3 4 5
 * 7 8 9 1 6
 * 6 6 7 2 7
 * 5 5 4 3 8
 * 4 3 2 1 9
 * 请返回位于场地坐标 [Xpos,Ypos] 的成员所持乐器编号。
 * <p>
 * 提示：
 * 1 <= num <= 10^9
 * 0 <= Xpos, Ypos < num
 * @Date: 2021/4/10
 */

public class Solution {
    public int orchestraLayout(int num, int xPos, int yPos) {
        long x = xPos, y = yPos, n = num, level, start;
        if (x <= y) { // 直接根据在哪半边分类讨论
            level = Math.min(x, n - 1 - y); // 确定在哪一层（最外层是第0层），实际通用求法是min({x,n-1-x,y,n-1-y})，这里由于分类讨论所以拆开了
            start = n * n - (n - 2 * level) * (n - 2 * level) - 1; // 利用补集的思想，求出第k层的最后一个值（这里暗含了把1~9映射为0~8）
            return (int) ((start + (x - level) + (y - level) + 1) % 9) + 1; // 按顺时针计算当前坐标与start的相对距离
        }
        level = Math.min(y, n - 1 - x);
        start = n * n - (n - 2 * (level + 1)) * (n - 2 * (level + 1)); // 求第k+1层的第一个值
        return (int) ((start - ((x - level) + (y - level))) % 9) + 1; // 按逆时针计算当前坐标与start的相对距离，这里计算的时候仍参考第k层的第一个位置，因为这两个位置正好是左上和右下的关系
    }

    //楼教主的解法
    public int orchestraLayout2(int n, int x0, int y0) {
        long key = Math.min(Math.min(x0, n - 1 - x0), Math.min(y0, n - 1 - y0));
        long ret = 0;
        if (key > 0) {
            ret += (n - 1) * key * 4;
            ret -= 4 * (key - 1) * key;
        }
        x0 -= key;
        y0 -= key;
        long size = n - key - key;
        if (x0 == 0)
            ret += y0;
        else if (y0 == size - 1)
            ret += size - 1 + x0;
        else if (x0 == size - 1)
            ret += (size - 1) * 2 + (size - 1 - y0);
        else
            ret += (size - 1) * 3 + (size - 1 - x0);
        return (int) (ret % 9) + 1;
    }

}
