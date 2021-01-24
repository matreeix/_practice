package _CONTEST._biweekly._44;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 5646. 需要教语言的最少人数
 * 在一个由 m 个用户组成的社交网络里，我们获取到一些用户之间的好友关系。两个用户之间可以相互沟通的条件是他们都掌握同一门语言。
 * 给你一个整数 n ，数组 languages 和数组 friendships ，它们的含义如下：
 * 1.总共有 n 种语言，编号从 1 到 n 。
 * 2.languages[i] 是第 i 位用户掌握的语言集合。
 * 3.friendships[i] = [u​​​​​​i​​​, v​​​​​​i] 表示 u​​​​​​​​​​​i​​​​​ 和 vi 为好友关系。
 * 你可以选择 一门 语言并教会一些用户，使得所有好友之间都可以相互沟通。请返回你 最少 需要教会多少名用户。
 * 请注意，好友关系没有传递性，也就是说如果 x 和 y 是好友，且 y 和 z 是好友， x 和 z 不一定是好友。
 * @Date: 2021/1/23
 */

public class Solution2 {
    /**
     * 首先，找到无法交流的人。
     * 然后，在其中找到最流行的语言。
     * 然后将这种语言教给不说的少数族裔：
     * */
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int ans = 0;
        Set<Integer> dontspeak = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0], v = f[1];
            u--;
            v--;
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            for (int num : languages[u]) set1.add(num);
            for (int num : languages[v]) set2.add(num);
            set1.retainAll(set2);// set1 intersection set2
            if (set1.size() == 0) { // this means there is no common element between set1 and set2
                dontspeak.add(u);
                dontspeak.add(v);
            }
        }
        int[] freq = new int[n + 1];
        for (int idx : dontspeak) { //counting frequency of languages spoke
            for (int ele : languages[idx]) freq[ele]++;
        }
        int maxx = 0;
        for (int i = 0; i < n + 1; ++i) { // finding popular language frequency
            if (freq[i] > maxx) maxx = freq[i];
        }
        ans = dontspeak.size() - maxx;
        return ans;
    }
}
