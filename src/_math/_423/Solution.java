package _math._423;

/**
 * @Description: 423. 从英文中重建数字
 * 给定一个非空字符串，其中包含字母顺序打乱的英文单词表示的数字0-9。按升序输出原始的数字。
 * 注意:
 * 输入只包含小写英文字母。
 * 输入保证合法并可以转换为原始的数字，这意味着像 "abc" 或 "zerone" 的输入是不允许的。
 * 输入字符串的长度小于 50,000。
 * @Created by: matreeix
 * @Date: 2021/5/27
 */
public class Solution {
    private int[] change(String s, int[] cnt, int mark) {
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a'] -= mark;
        }
        return cnt;
    }

    public String originalDigits(String str) {
        int[] cnt = new int[26];
        for (char ch : str.toCharArray()) cnt[ch - 'a']++;
        int[] nums = new int[10];

        int z = cnt['z' - 'a'];
        cnt = change("zero", cnt, z);

        int w = cnt['w' - 'a'];
        cnt = change("two", cnt, w);

        int x = cnt['x' - 'a'];
        cnt = change("six", cnt, x);

        int g = cnt['g' - 'a'];
        cnt = change("eight", cnt, g);

        int u = cnt['u' - 'a'];
        cnt = change("four", cnt, u);

        int r = cnt['r' - 'a'];
        cnt = change("three", cnt, r);

        int s = cnt['s' - 'a'];
        cnt = change("seven", cnt, s);

        int o = cnt['o' - 'a'];
        cnt = change("one", cnt, o);

        int f = cnt['f' - 'a'];
        cnt = change("five", cnt, f);

        int i = cnt['i' - 'a'];
        cnt = change("nine", cnt, i);

        nums[0] = z;
        nums[2] = w;
        nums[6] = x;
        nums[8] = g;
        nums[4] = u;
        nums[3] = r;
        nums[7] = s;
        nums[1] = o;
        nums[5] = f;
        nums[9] = i;
        StringBuilder res = new StringBuilder();
        for (int j = 0; j < nums.length; j++) {
            for (int k = 1; k <= nums[j]; k++) {
                res.append(j);
            }
        }
        return res.toString();
    }

    public String originalDigits2(String s) {
        int[] count = new int[10];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'z') count[0]++;
            if (c == 'w') count[2]++;
            if (c == 'x') count[6]++;
            if (c == 's') count[7]++; //7-6
            if (c == 'g') count[8]++;
            if (c == 'u') count[4]++;
            if (c == 'f') count[5]++; //5-4
            if (c == 'h') count[3]++; //3-8
            if (c == 'i') count[9]++; //9-8-5-6
            if (c == 'o') count[1]++; //1-0-2-4
        }
        count[7] -= count[6];
        count[5] -= count[4];
        count[3] -= count[8];
        count[9] = count[9] - count[8] - count[5] - count[6];
        count[1] = count[1] - count[0] - count[2] - count[4];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j < count[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.originalDigits("owoztneoer"));
        System.out.println(s.originalDigits("fviefuro"));
    }
}
