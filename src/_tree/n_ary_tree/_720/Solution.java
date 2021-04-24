package _tree.n_ary_tree._720;

/**
 * @Description: 720. 词典中最长的单词
 * 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
 * 若无答案，则返回空字符串。
 * @Date: 2021/4/24
 */

public class Solution {
    int longestLen = 0;
    String ansLongerWord = "";

    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        for (String s : words) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                if (cur.children[c - 'a'] == null)
                    cur.children[c - 'a'] = new TrieNode();
                cur = cur.children[c - 'a'];
            }
            cur.isEnd = true;
            cur.word = s;
        }

        longestWordDFS(root, 0);
        return ansLongerWord;
    }

    public void longestWordDFS(TrieNode root, int depth) {
        if (root == null || (depth > 0 && !root.isEnd)) //当前节点为空，或者当前节点（非根节点）不是单词的结尾时，return剪枝
            return;

        //每次搜索更新最大深度和最长单词
        if (depth > longestLen) {
            longestLen = depth;
            ansLongerWord = root.word;
        }

        for (TrieNode node : root.children)
            if (node != null)
                longestWordDFS(node, depth + 1);
    }
}

class TrieNode {
    String word;
    TrieNode[] children;
    boolean isEnd;

    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}
