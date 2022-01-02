package _leetcode._CONTEST._weekly._274;

/**
 * @Description: 5967. 检查是否所有 A 都在 B 之前
 * 给你一个 仅 由字符 'a' 和 'b' 组成的字符串  s 。如果字符串中 每个 'a' 都出现在 每个 'b' 之前，返回 true ；否则，返回 false 。
 * @Date: 2022/1/2
 */

public class Solution1 {
    public boolean checkString(String s) {
        return !s.contains("ba");
    }
}
