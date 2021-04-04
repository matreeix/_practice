package _CONTEST._biweekly._49;

import java.util.Arrays;

/**
 * @Description: 5706. 句子相似性 III
 * 一个句子是由一些单词与它们之间的单个空格组成，且句子的开头和结尾没有多余空格。比方说，"Hello World" ，"HELLO" ，"hello world hello world" 都是句子。每个单词都 只 包含大写和小写英文字母。
 * 如果两个句子 sentence1 和 sentence2 ，可以通过往其中一个句子插入一个任意的句子（可以是空句子）而得到另一个句子，那么我们称这两个句子是 相似的 。比方说，sentence1 = "Hello my name is Jane" 且 sentence2 = "Hello Jane" ，我们可以往 sentence2 中 "Hello" 和 "Jane" 之间插入 "my name is" 得到 sentence1 。
 * 给你两个句子 sentence1 和 sentence2 ，如果 sentence1 和 sentence2 是相似的，请你返回 true ，否则返回 false 。
 * 提示：
 * <p>
 * 1 <= sentence1.length, sentence2.length <= 100
 * sentence1 和 sentence2 都只包含大小写英文字母和空格。
 * sentence1 和 sentence2 中的单词都只由单个空格隔开。
 * @Date: 2021/4/3
 */

public class Solution2 {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.equals(sentence2)) return true;
        String[] a = sentence1.split(" ");
        String[] b = sentence2.split(" ");
        return a.length > b.length ? insertA2B(b, a) :
                a.length < b.length && insertA2B(a, b);
    }

    private boolean insertA2B(String[] strings1, String[] strings2) {
        int l = 0, r = strings1.length - 1;
        int ll = 0, rr = strings2.length - 1;
        while (l <= r) {
            if (strings1[l].equals(strings2[ll])) {
                l++;
                ll++;
            } else if (strings1[r].equals(strings2[rr])) {
                r--;
                rr--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.areSentencesSimilar("of", "A lot of words"));
    }

}
