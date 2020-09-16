package _CONTEST._weekly._206;

import java.util.ArrayList;

/**
 * @Description: 1585. 检查字符串是否可以通过排序子字符串得到另一个字符串
 * 给你两个字符串 s 和 t ，请你通过若干次以下操作将字符串 s 转化成字符串 t ：
 * 选择 s 中一个 非空 子字符串并将它包含的字符就地 升序 排序。
 * 比方说，对下划线所示的子字符串进行操作可以由 "14234" 得到 "12344" 。
 * 如果可以将字符串 s 变成 t ，返回 true 。否则，返回 false 。
 * <p>
 * 一个 子字符串 定义为一个字符串中连续的若干字符。
 * @Author: matreeix
 * @Date: 2020/9/16
 */

public class Solution4 {
    public boolean isTransformable(String s, String t) {
        ArrayList<Integer> idx[] = new ArrayList[10];
        int pos[] = new int[10];
        for (int i = 0; i <= 9; ++i)
            idx[i] = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); ++i)
            idx[s.charAt(i) - '0'].add(i);
        for (int i = 0; i < t.length(); ++i) {
            int d = t.charAt(i) - '0';
            if (pos[d] >= idx[d].size())
                return false;
            for (int j = 0; j < d; ++j)
                if (pos[j] < idx[j].size() && idx[j].get(pos[j]) < idx[d].get(pos[d]))
                    return false;
            ++pos[d];
        }
        return true;
    }
}
