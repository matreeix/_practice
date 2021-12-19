package _leetcode._CONTEST._weekly._272;

/**
 * @Description: 5957. 向字符串添加空格
 * 给你一个下标从 0 开始的字符串 s ，以及一个下标从 0 开始的整数数组 spaces 。
 * 数组 spaces 描述原字符串中需要添加空格的下标。每个空格都应该插入到给定索引处的字符值 之前 。
 * 例如，s = "EnjoyYourCoffee" 且 spaces = [5, 9] ，那么我们需要在 'Y' 和 'C' 之前添加空格，这两个字符分别位于下标 5 和下标 9 。因此，最终得到 "Enjoy Your Coffee" 。
 * 请你添加空格，并返回修改后的字符串。
 * 提示：
 * 1 <= s.length <= 3 * 10^5
 * s 仅由大小写英文字母组成
 * 1 <= spaces.length <= 3 * 10^5
 * 0 <= spaces[i] <= s.length - 1
 * spaces 中的所有值 严格递增
 * @Date: 2021/12/19
 */

public class Solution2 {
    public String addSpaces(String s, int[] spaces) {
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < spaces.length; i++) spaces[i] += i;
        int idx = 0;
        for (int i = 0; i < s.length(); ) {
            if (idx < spaces.length && spaces[idx] == res.length()) {
                res.append(" ");
                idx++;
            } else {
                res.append(s.charAt(i));
                i++;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "LeetcodeHelpsMeLearn";
        int[] spaces = {8, 13, 15};
        System.out.println((new Solution2()).addSpaces(s, spaces));
    }
}
