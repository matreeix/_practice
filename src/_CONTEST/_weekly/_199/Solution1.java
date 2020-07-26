package _CONTEST._weekly._199;

import com.sun.java.swing.plaf.windows.WindowsDesktopIconUI;

import java.util.Arrays;

/**
 * @Description: 5472. 重新排列字符串
 * 给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
 * 请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。
 * 返回重新排列后的字符串。
 * @Author: Pythagodzilla
 * @Date: 2020/7/26
 */

public class Solution1 {
    public static String restoreString(String s, int[] indices) {
        char[] chars = new char[s.length()];
        for (int i = 0; i < indices.length; i++)
            chars[indices[i]] = s.charAt(i);
        return new String(chars);

    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        String s = "codeleet";
        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};
        System.out.println(restoreString(s, indices));
    }
}
