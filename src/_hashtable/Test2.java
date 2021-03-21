package _hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 比较数组hash和使用map的性能差异
 * <p>
 * 在由小写字母组成的字符串中，找出频数最大的字符，多个返回任意一个
 * @Date: 2021/3/21
 */

public class Test2 {

    public String productionString(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = (char) ('a' + (int) (Math.random() * 26));
            sb.append(ch);
        }
        return sb.toString();
    }

    public char getMaxChar(String s) {
        char[] chs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : chs)
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        char res = '0';
        int cnt = 0;
        for (char ch : map.keySet()) {
            int k = map.get(ch);
            if (k > cnt) {
                res = ch;
                cnt = k;
            }
        }
        return res;
    }

    public char getMaxChar2(String s) {
        char[] chs = s.toCharArray();
        int[] cnt = new int[26];
        for (char ch : chs)
            cnt[ch - 'a']++;
        char res = '0';
        int max = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > max) {
                res = (char) (i + 'a');
                max = cnt[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Test2 t = new Test2();
        String s = t.productionString(100000000);
        double time1 = System.currentTimeMillis();
        System.out.println(t.getMaxChar(s));
        double time2 = System.currentTimeMillis();
        System.out.println(t.getMaxChar2(s));
        double time3 = System.currentTimeMillis();

        System.out.println("map花费时间：" + (time2 - time1) / 1000 + "s");
        System.out.println("数组花费时间：" + (time3 - time2) / 1000 + "s");
    }
}
