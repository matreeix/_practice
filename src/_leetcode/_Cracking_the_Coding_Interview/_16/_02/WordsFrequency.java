package _leetcode._Cracking_the_Coding_Interview._16._02;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 面试题 16.02. 单词频率
 * 设计一个方法，找出任意指定单词在一本书中的出现频率。
 * <p>
 * 你的实现应该支持如下操作：
 * 1.WordsFrequency(book)构造函数，参数为字符串数组构成的一本书
 * 2.get(word)查询指定单词在书中出现的频率
 *
 * 提示：
 *
 * book[i]中只包含小写字母
 * 1 <= book.length <= 100000
 * 1 <= book[i].length <= 10
 * get函数的调用次数不会超过100000
 *
 * @Author: matreeix
 * @Date: 2020/10/17
 */

public class WordsFrequency {
    private Map<String, Integer> map = new HashMap<>();

    public WordsFrequency(String[] book) {
        for (String word : book) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
    }

    public int get(String word) {
        return map.getOrDefault(word, 0);
    }
}

/**
 * Your WordsFrequency object will be instantiated and called as such:
 * WordsFrequency obj = new WordsFrequency(book);
 * int param_1 = obj.get(word);
 */