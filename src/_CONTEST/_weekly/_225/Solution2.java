package _CONTEST._weekly._225;

import com.sun.media.jfxmediaimpl.HostUtils;
import org.omg.CORBA.INTERNAL;

import java.util.Arrays;

/**
 * @Description: 5662. 满足三条件之一需改变的最少字符数
 * 给你两个字符串 a 和 b ，二者均由小写字母组成。一步操作中，你可以将 a 或 b 中的 任一字符 改变为 任一小写字母 。
 * <p>
 * 操作的最终目标是满足下列三个条件 之一 ：
 * 1.a 中的 每个字母 在字母表中 严格小于 b 中的 每个字母 。
 * 2.b 中的 每个字母 在字母表中 严格小于 a 中的 每个字母 。
 * 3.a 和 b 都 由 同一个 字母组成。
 * 返回达成目标所需的 最少 操作数。
 * @Date: 2021/1/24
 */

public class Solution2 {
    public static int minCharacters(String a, String b) {
        int[] acnt = new int[26];
        int[] bcnt = new int[26];
        int an = a.length(), bn = b.length();
        for (char c : a.toCharArray()) acnt[c - 'a']++;
        for (char c : b.toCharArray()) bcnt[c - 'a']++;
        int ans = Integer.MAX_VALUE, asum = 0, bsum = 0;//前缀和
        for (int i = 0; i < 25; i++) {
            asum += acnt[i];
            bsum += bcnt[i];
            ans = Math.min(Math.min(ans, an - acnt[i] + bn - bcnt[i]),//3
                    Math.min(an - asum + bsum, bn - bsum + asum));//1、2
        }
        ans = Math.min(ans, an - acnt[25] + bn - bcnt[25]);//全部改为z的情况
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minCharacters("aba", "caa"));//2
        System.out.println(minCharacters("dabadd", "cda"));//3
    }

}
