package _greedy._1754;

/**
 * @Description: 1754. 构造字典序最大的合并字符串
 * 给你两个字符串 word1 和 word2 。你需要按下述方式构造一个新字符串 merge ：如果 word1 或 word2 非空，只能选择 其一 继续操作：
 * 如果 word1 非空，将 word1 中的第一个字符附加到 merge 的末尾，并将其从 word1 中移除。
 * 例如，word1 = "abc" 且 merge = "dv" ，在执行此选项操作之后，word1 = "bc" ，同时 merge = "dva"
 * 返回你可以构造的字典序 最大 的合并字符串 merge 。
 * @Date: 2021/2/20
 */

public class Solution {
    //O(m*n)
    public String largestMerge(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0)
            return word1 + word2;
        if (word1.compareTo(word2) > 0)
            return word1.charAt(0) + largestMerge(word1.substring(1), word2);
        return word2.charAt(0) + largestMerge(word1, word2.substring(1));
    }

    public String largestMerge2(String word1, String word2) {
        char[] a = word1.toCharArray();
        char[] b = word2.toCharArray();
        int n = a.length;
        int m = b.length;
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < n && j < m) {
            if (a[i] > b[j]) {
                sb.append(a[i]);
                i++;
            } else if (b[j] > a[i]) {
                sb.append(b[j]);
                j++;
            } else {
                int x = i;
                int y = j;
                while (x < n && y < m && a[x] == b[y]) {
                    x++;
                    y++;
                }
                if (x == n && y == m) {
                    sb.append(a[i++]);
                    continue;
                }
                if (x == n) {
                    sb.append(b[j++]);
                    continue;
                }
                if (y == m) {
                    sb.append(a[i++]);
                    continue;
                }
                if (a[x] > b[y]) {
                    sb.append(a[i++]);
                } else {
                    sb.append(b[j++]);
                }
            }
        }
        while (i < n) {
            sb.append(a[i]);
            i++;
        }
        while (j < m) {
            sb.append(b[j]);
            j++;
        }
        return sb.toString();
    }
}
