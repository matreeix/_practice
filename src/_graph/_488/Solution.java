package _graph._488;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 祖玛游戏
 * @Author: caffebaby
 * @Date: 2020/2/17
 */
public class Solution {
    private int minStep = Integer.MAX_VALUE;

    public int findMinStep(String board, String hand) {
        HashMap<Character, Integer> hands = new HashMap<>();//存储手中的字符
        for (char ch : hand.toCharArray()) {
            if (hands.containsKey(ch))
                hands.put(ch, hands.get(ch) + 1);
            else
                hands.put(ch, 1);
        }
        List<Character> boards = new LinkedList<>();
        for (char ch : board.toCharArray())
            boards.add(ch);

        return canEliminate(boards, hands, 0);
    }

    public int canEliminate(List<Character> board, HashMap<Character, Integer> hand, int step) {
        if (board.size() == 0) {//全部消除完
            return step;
        }
        if (hand.size() == 0 && board.size() != 0) return Integer.MAX_VALUE;//弹药用完还是没消除完

        step++;
        HashMap<Character, Integer> newHand = new HashMap<>();
        for (char ch : hand.keySet())
            if (hand.get(ch) > 0)
                newHand.put(ch, hand.get(ch));//新hand只存储大于0的key

        for (int i = 0; i < board.size() + 1; i++) {//字符插入的位置
            for (char ch : hand.keySet()) {//选择的插入的字符
                board.add(i, ch);//插入原字符串
                List<Character> newBoard = getOne(board);

                newHand.put(ch, hand.get(ch) - 1);
                minStep = Math.min(canEliminate(newBoard, newHand, step), minStep);
                board.remove(i);
            }
        }

        return minStep == Integer.MAX_VALUE ? -1 : minStep;
    }


    //在新生成的字符串中根据规则满三递归消除，得到最后结果
    public List<Character> getOne(List<Character> list) {
        int startSize = list.size();
        int i = 0, j = 1;
        while (i < list.size() && j < list.size()) {
            if (list.get(i) == list.get(j)) {
                j++;
            } else if (j - i < 3) {
                i = j;
                j++;
            } else {//需要消除
                int count = j - i;
                while (count > 0) {
                    list.remove(i);
                    count--;
                }
                j = i + 1;
            }
        }
        int endSize = list.size();
        if (startSize == endSize)
            return list;
        else
            return getOne(list);
    }

    public static void main(String[] args) {
        String board = "WWRRWW", hand = "WRB";
        System.out.println((new Solution()).findMinStep(board, hand));
    }
}
