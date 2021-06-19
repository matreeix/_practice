package _leetcode._CONTEST._weekly._198;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 5466. 最大不重叠子字符串数
 * <p>
 * 给定一串s 小写字母，您需要找到 满足以下条件的最大非空子字符串  数s：
 * 该子不重叠，即对于任何两个子s[i..j]和s[k..l]，要么j < k或者i > l 是真实的。
 * 包含某个字符的子字符串也  c 必须包含所有出现的c。
 * 查找满足上述条件的最大子字符串数。如果有多个解决方案的子字符串数量相同，则返回总长度最小的解决方案。 可以证明，存在最小总长度的唯一解决方案。
 * 请注意，您可以按任何顺序返回子字符串。
 * @Author: matreeix
 * @Date: 2020/7/19
 */

public class Solution3 {
    //未完成的解法
    public static List<String> maxNumOfSubstrings(String S) {
        if (S == null || S.length() == 0) return null;

        List<String> list = new ArrayList<>();
        int[] end = new int[26];  //record the last index of the each char
        int[] begin = new int[26];  //record the start index of the each char
        Arrays.fill(begin, -1);

        for (int i = 0; i < S.length(); i++)
            end[S.charAt(i) - 'a'] = i;

        for (int i = 0; i < S.length(); i++)
            if (begin[S.charAt(i) - 'a'] == -1)
                begin[S.charAt(i) - 'a'] = i;

        int start = 0;
        int last = end[S.charAt(0) - 'a'];
        for (int i = 0; i < S.length(); i++) {

            if (end[S.charAt(i) - 'a'] < last) {
                start = i;
                last = end[S.charAt(i) - 'a'];
            } else {
                last = Math.max(last, end[S.charAt(i) - 'a']);
            }

            if (last == i && end[S.charAt(i) - 'a'] - begin[S.charAt(i) - 'a'] == last - start) {
                list.add(S.substring(start, last + 1));
                start = last + 1;
            } else if (last == i) {
                start = last + 1;
            }
        }
        return list;
    }


    private int checkSubstr(String s, int i, int l[], int r[]) {
        int right = r[s.charAt(i) - 'a'];
        for (int j = i; j <= right; ++j) {
            if (l[s.charAt(j) - 'a'] < i)//[j....i.....j....i]
                return -1;
            right = Math.max(right, r[s.charAt(j) - 'a']);//[i.....j....i....j]
        }
        return right;
    }

    //贪心+双指针
    public List<String> maxNumOfSubstrings2(String s) {
        int[] l = new int[26];
        int[] r = new int[26];
        Arrays.fill(l, s.length());
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < s.length(); ++i) {
            int ch = s.charAt(i) - 'a';
            l[ch] = Math.min(l[ch], i);//字母首次出现的位置
            r[ch] = Math.max(r[ch], i);//字母最后出现的位置
        }
        int right = s.length();
        for (int i = 0; i < s.length(); ++i)
            if (i == l[s.charAt(i) - 'a']) {
                int new_right = checkSubstr(s, i, l, r);
                if (new_right != -1) {
                    if (i > right || res.isEmpty())//超出范围
                        res.add("");
                    right = new_right;
                    res.set(res.size() - 1, s.substring(i, right + 1));
                }
            }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "adefaddaccc";
        String s2 = "abbaccd";
        String s3 = "ababc";

        System.out.println(maxNumOfSubstrings(s1));
        System.out.println(maxNumOfSubstrings(s2));
        System.out.println(maxNumOfSubstrings(s3));

    }
}