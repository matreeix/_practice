package _hashtable._500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。
 * @Author: 67ng
 * @Date: 2020/5/5
 */
public class Solution {
    public String[] findWords(String[] words) {
        if (words == null)
            return null;

        List<String> ans = new ArrayList<>();

        // 字典行
        String lines[] = new String[]{
                "qwertyuiop",
                "asdfghjkl",
                "zxcvbnm"
        };

        for (String word : words) {
            if (judge(word.toLowerCase(), lines)) {
                ans.add(word);
            }
        }

        return ans.toArray(new String[ans.size()]);
    }

    private boolean judge(String word, String[] lines) {
        boolean ok = true;
        String find = null;

        // 先用word首字符确定属于哪一行
        for (String line : lines) {
            if (line.indexOf(word.charAt(0)) > -1) {
                find = line;
                break;
            }
        }

        if (find == null) {
            ok = false;
            return ok;
        }

        // 判断word字符串所有字符是否都属于同一行
        for (int i = 1; i < word.length(); i++) {
            if (find.indexOf(word.charAt(i)) < 0) {
                ok = false;
                break;
            }
        }

        return ok;
    }

    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(Arrays.toString((new Solution()).findWords(words)));
    }
}
