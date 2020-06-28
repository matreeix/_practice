package _hashtable._49;

import java.util.*;

/**
 * @Description: 字母异位词分组
 * <p>
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * @Author: Pythagodzilla
 * @Date: 2020/6/28
 */

public class Solution {
    //暴力解法
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        boolean mark = false;//标记
        for (String str : strs) {
            for (String s : map.keySet()) {//遍历map的key看是否已经存在
                if (isAnagram(s, str)) {
                    map.get(s).add(str);
                    mark = true;
                }
            }
            if (!mark)
                map.put(str, new ArrayList<String>() {{//添加新的异位词组
                    this.add(str);
                }});
            mark = false;
        }
        return new ArrayList<>(map.values());
    }

    //判断是否是字母异位词
    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            count[ch - 'a']--;
        }
        for (int i : count)
            if (i != 0)
                return false;
        return true;
    }

    //可以将每个字符串 \text{s}s 转换为字符数 count，由26个非负整数组成，表示 a，b，c 的数量等。我们使用这些计数作为哈希映射的基础。
    //在 Java 中，我们的字符数 count 的散列化表示将是一个用 **＃** 字符分隔的字符串。 例如，abbccc 将表示为 ＃1＃2＃3＃0＃0＃0 ...＃0，
    //其中总共有26个条目。
    //构造字符串为key
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0)
            return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray())
                count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key))
                ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    //最优解法，what the fuck？
    public List<List<String>> groupAnagrams3(String[] strs) {
        int n = strs.length;
        List<List<String>> res = new ArrayList<>();
        HashMap<Long, Integer> map = new HashMap<>();//hashcoded->编号
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                73, 79, 83, 89, 97, 101};//前26个素数
        for (int i = 0; i < n; ++i) {
            String str = strs[i];
            long hashcode = getHashcode(str, primes);
            if (map.containsKey(hashcode)) {
                res.get(map.get(hashcode)).add(str);
                continue;
            }
            res.add(new ArrayList<String>());
            map.put(hashcode, res.size() - 1);
            res.get(res.size() - 1).add(str);
        }
        return res;
    }

    //用hashcode来判断字母异位词,可能会溢出
    private long getHashcode(String str, int[] primes) {
        long hashcode = 1;
        for (int i = 0; i < str.length(); ++i) {
            int c = primes[str.charAt(i) - 'a'];
            hashcode *= c;
        }
        return hashcode;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Solution s = new Solution();
        System.out.println(s.groupAnagrams(strs));
        System.out.println(Long.MAX_VALUE);
    }
}
