package _graph._332;

import java.util.*;

/**
 * @Description: 重建行程
 * <p>
 * 给定以成对的出发和到达机场为代表的机票清单，请按[from, to]顺序重构行程。
 * 所有的票都属于一个从JFK那里出发的人。因此，行程必须以JFK开始。
 * <p>
 * 注意：
 * 如果有多个有效行程，则当以单个字符串读取时，应返回词汇顺序最小的行程。
 * 所有机场均以三个大写字母（IATA代码）表示。
 * 您可以假设所有机票均形成至少一个有效行程。
 * @Author: 67ng
 * @Date: 2020/3/8
 */

//Hierholzer算法
public class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> map = new HashMap<>();
        for (List<String> list : tickets) {
            if (!map.containsKey(list.get(0))) {
                map.put(list.get(0), new PriorityQueue<String>((a, b) -> a.compareTo(b)) {{
                    add(list.get(1));
                }});
            } else {
                map.get(list.get(0)).add(list.get(1));
            }
        }
        List<String> res = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        String cur = "JFK";
        stack.push(cur);
        while (!stack.isEmpty()) {
            if (map.get(cur) != null && map.get(cur).size() != 0) {
                stack.push(cur);
                cur = map.get(cur).poll();
            } else {
                //注意下面两行代码的顺序
                res.add(cur);
                cur = stack.pop();
            }
        }
        Collections.reverse(res);
        return res;
    }

    public List<String> findItinerary2(String[][] tickets) {
        Map<String, PriorityQueue<String>> targets = new HashMap<>();
        for (String[] ticket : tickets)
            targets.computeIfAbsent(ticket[0],
                    k -> new PriorityQueue()).add(ticket[1]);
        List<String> route = new LinkedList();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.empty()) {
            while (targets.containsKey(stack.peek())
                    && !targets.get(stack.peek()).isEmpty())
                stack.push(targets.get(stack.peek()).poll());
            route.add(0, stack.pop());
        }
        return route;
    }

    public static void main(String[] args) {

    }
}
















