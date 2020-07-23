package _CONTEST._weekly._185;

/**
 * @Description: 1419. 数青蛙
 * 给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。由于同一时间可以有多只青蛙呱呱作响，
 * 所以 croakOfFrogs 中会混合多个 “croak” 。请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
 * 注意：要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。
 * 如果没有输出全部五个字母，那么它就不会发出声音。
 * 如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。
 * @Author: Pythagodzilla
 * @Date: 2020/7/22
 */

public class Solution3 {
    //用数组按顺序存储字符c、r、o、a、k,若存在升序则不合法，最多蛙数既是c和k的最大差值
    public static int minNumberOfFrogs(String croakOfFrogs) {
        int[] cnt = new int[5];//统计蛙鸣
        int res = 0;
        for (char ch : croakOfFrogs.toCharArray()) {
            cnt["croak".indexOf(ch)]++;
            for (int i = 0; i < 4; i++)
                if (cnt[i] - cnt[i + 1] < 0)
                    return -1;
            res = Math.max(res, cnt[0] - cnt[4]);
        }

        return cnt[0] == cnt[4] ? res : -1;
    }

    public static void main(String[] args) {
        String croakOfFrogs1 = "croakcroak";
        String croakOfFrogs2 = "crcoakroak";
        String croakOfFrogs3 = "croakcrook";
        System.out.println(minNumberOfFrogs(croakOfFrogs1));
        System.out.println(minNumberOfFrogs(croakOfFrogs2));
        System.out.println(minNumberOfFrogs(croakOfFrogs3));
    }
}
