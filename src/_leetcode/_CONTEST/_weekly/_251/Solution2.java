package _leetcode._CONTEST._weekly._251;

/**
 * @Description: 5824. 子字符串突变后可能得到的最大整数
 * 给你一个字符串 num ，该字符串表示一个大整数。另给你一个长度为 10 且 下标从 0  开始 的整数数组 change ，该数组将 0-9 中的每个数字映射到另一个数字。更规范的说法是，数字 d 映射为数字 change[d] 。
 * 你可以选择 突变  num 的任一子字符串。突变 子字符串意味着将每位数字 num[i] 替换为该数字在 change 中的映射（也就是说，将 num[i] 替换为 change[num[i]]）。
 * 请你找出在对 num 的任一子字符串执行突变操作（也可以不执行）后，可能得到的 最大整数 ，并用字符串表示返回。
 * 子字符串 是字符串中的一个连续序列。
 * <p>
 * 提示：
 * 1 <= num.length <= 10^5
 * num 仅由数字 0-9 组成
 * change.length == 10
 * 0 <= change[d] <= 9
 * @Date: 2021/7/25
 */

public class Solution2 {

    public String maximumNumber(String num, int[] change) {
        StringBuilder res = new StringBuilder();
        boolean start = false;
        boolean end = false;
        for (char ch : num.toCharArray()) {
            int tmp = ch - '0';
            if (change[tmp] > tmp) {
                start = true;
                if (!end) res.append(change[tmp]);
                else res.append(tmp);
            } else if (change[tmp] == tmp) {
                res.append(tmp);
            } else {
                res.append(tmp);
                if (start && !end) end = true;
            }
        }
        return res.toString();
    }

}
