package _math._991;

/**
 * @Description: 通过乘以2或者减一，从X变成Y的最小步数
 *
 * 思路：
 * 考虑由Y变成X，Y的操作为Y/2或者Y+1，
 * 若Y为奇数就减半，否则就加一，
 * 显然这就是最快的算法
 *
 * @Author: caffebaby
 * @Date: 2020/3/21
 */
public class Solution {
    public int brokenCalc(int X, int Y) {
        return X >= Y ? X - Y : 1 + Y % 2 + brokenCalc(X, (Y + 1) / 2);
    }
}
