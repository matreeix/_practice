package _tree.n_ary_tree._676;

import java.util.*;

/**
 * @Description: 广义邻居
 * @Created by: matreeix
 * @Date: 2021/6/10
 */
public class MagicDictionary2 {

    Set<String> words;
    Map<String, Integer> count;

    public MagicDictionary2() {
        words = new HashSet();
        count = new HashMap();
    }

    //生成广义邻居，即将一个字符用 * 代替
    private ArrayList<String> generalizedNeighbors(String word) {
        ArrayList<String> ans = new ArrayList();
        char[] ca = word.toCharArray();
        for (int i = 0; i < word.length(); ++i) {
            char letter = ca[i];
            ca[i] = '*';
            String magic = new String(ca);
            ans.add(magic);
            ca[i] = letter;
        }
        return ans;
    }

    public void buildDict(String[] words) {
        for (String word : words) {
            this.words.add(word);
            for (String nei : generalizedNeighbors(word)) {
                count.put(nei, count.getOrDefault(nei, 0) + 1);
            }
        }
    }

    public boolean search(String word) {
        for (String nei : generalizedNeighbors(word)) {
            int c = count.getOrDefault(nei, 0);
            if (c > 1 || c == 1 && !words.contains(word))
                return true;
        }
        return false;
    }
}
