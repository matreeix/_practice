package _tree.n_ary_tree._720;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 哈希表
 * @Date: 2021/4/24
 */

public class Solution2 {

    //不排序
    public String longestWord(String[] words) {
        boolean currLongest = false;

        String ans = "";
        Set<String> wordset = new HashSet<>();
        wordset.addAll(Arrays.asList(words));
        for (String word : words) {
            if (word.length() > ans.length() || word.length() == ans.length() && word.compareTo(ans) < 0) {
                currLongest = true;
                for (int k = 1; k < word.length(); k++) {
                    if (!wordset.contains(word.substring(0, k))) {
                        currLongest = false;
                        break;
                    }
                }

                if (currLongest) ans = word;
            }
        }
        return ans;
    }

    //排序
    public String longestWord2(String[] words) {
        //对数组排序，再利用Set对字母存储，小的单词一定包含在后面大的单词里面。后面只需要取前缀相同的
        //对字母排序后，第一个单词一定是共有的，后面只需在此基础上添加
        Arrays.sort(words);

        Set<String> set = new HashSet<>();
        String res = "";
        for (String s : words) {
            //如果单词只有一个字母，那一定是共有的
            if (s.length() == 1 || set.contains(s.substring(0, s.length() - 1))) {
                res = s.length() > res.length() ? s : res;
                set.add(s);
            }
        }
        return res;
    }
}
