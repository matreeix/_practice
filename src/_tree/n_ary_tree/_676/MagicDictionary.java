package _tree.n_ary_tree._676;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 676. 实现一个魔法字典
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
 * 实现 MagicDictionary 类：
 * MagicDictionary() 初始化对象
 * void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
 * bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。
 * @Created by: matreeix
 * @Date: 2021/6/10
 */
public class MagicDictionary {

    /**
     * Initialize your data structure here.
     */
    Map<Integer, List<String>> buckets;//<length,words>
    public MagicDictionary() {
        buckets = new HashMap();
    }

    public void buildDict(String[] words) {
        for (String word: words)
            buckets.computeIfAbsent(word.length(), x -> new ArrayList()).add(word);
    }

    public boolean search(String word) {
        if (!buckets.containsKey(word.length()))
            return false;
        for (String candidate: buckets.get(word.length())) {
            int mismatch = 0;
            for (int i = 0; i < word.length(); ++i)
                if (word.charAt(i) != candidate.charAt(i))
                    if (++mismatch > 1)
                        break;
            if (mismatch == 1) return true;
        }
        return false;
    }
}
