package _greedy._649;

import java.util.*;

/**
 * @Description: Dota2的参议院
 * <p>
 * 思路：使用贪心策略，当前选手尽量ban掉后面最靠近的对手，使其丧失ban队友的机会
 * @Author: matreeix
 * @Date: 2020/6/1
 */
public class Solution {
    //使用队列
    public static String predictPartyVictory(String senate) {
        Queue<Integer> queue = new LinkedList();
        int[] people = new int[]{0, 0};//记录R和D的数量
        int[] bans = new int[]{0, 0};//累计ban掉的数量

        for (char person : senate.toCharArray()) {
            int x = person == 'R' ? 1 : 0;
            people[x]++;
            queue.add(x);
        }

        while (people[0] > 0 && people[1] > 0) {
            int x = queue.poll();
            if (bans[x] > 0) {//前面有ban掉
                bans[x]--;
                people[x]--;
            } else {//前面没有ban，为对手ban数加一并放进队尾
                bans[x ^ 1]++;
                queue.add(x);
            }
        }

        return people[1] > 0 ? "Radiant" : "Dire";
    }

    public String predictPartyVictory2(String senate) {
        boolean R = true, D = true;
        char[] arr = senate.toCharArray();
        //标记变量，ban > 0的时候，此时R方有权利把D方的成员淘汰掉
        //ban < 0的时候，D方有权利把R方的成员淘汰掉
        int ban = 0;//记录ban权重，妙啊！！！
        while (R && D) {
            //当遇到双方成员的时候置为true，表示当前还有人员存在
            //当R或D为false，表示一方已经没有成员存在了，胜负已分，结束循环
            R = false;
            D = false;
            for (int i = 0; i < arr.length; ++i) {
                if (arr[i] == 'R') {
                    R = true;
                    if (ban < 0)
                        arr[i] = 'O';
                    ++ban;
                } else if (arr[i] == 'D') {
                    D = true;
                    if (ban > 0)
                        arr[i] = 'O';
                    --ban;
                }
            }
        }
        return ban > 0 ? "Radiant" : "Dire";
    }

    public static void main(String[] args) {
//        String s = "RDD";
        String s = "DDRRR";
        System.out.println(predictPartyVictory(s));
    }
}
