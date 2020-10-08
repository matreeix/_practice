package _CONTEST._biweekly._36;

import java.util.*;

/**
 * @Description: 5516. 警告一小时内使用相同员工卡大于等于三次的人
 * 力扣公司的员工都使用员工卡来开办公室的门。每当一个员工使用一次他的员工卡，安保系统会记录下员工的名字和使用时间。
 * 如果一个员工在一小时时间内使用员工卡的次数大于等于三次，这个系统会自动发布一个 警告 。
 * 给你字符串数组 keyName 和 keyTime ，期中 [keyName[i], keyTime[i]] 对应一个人的名字和他在 某一天 内使用员工卡的时间。
 * 使用时间的格式是 24小时制 ，形如 "HH:MM" ，比方说 "23:51" 和 "09:49" 。
 * 请你返回去重后的收到系统警告的员工名字，将它们按 字典序升序 排序后返回。
 * <p>
 * 请注意 "10:00" - "11:00" 视为一个小时时间范围内，而 "23:51" - "00:10" 不被视为一小时内，因为系统记录的是某一天内的使用情况。
 * @Author: matreeix
 * @Date: 2020/10/3
 */

public class Solution2 {
    //hashmap + 1滑动窗口
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, TreeSet<Integer>> nameToTime = new HashMap<>();
        for (int i = 0; i < keyName.length; ++i) {
            int time = Integer.parseInt(keyTime[i].substring(0, 2)) * 60 + Integer.parseInt(keyTime[i].substring(3));
            nameToTime.computeIfAbsent(keyName[i], s -> new TreeSet<>()).add(time);
        }
        TreeSet<String> names = new TreeSet<>();
        for (Map.Entry<String, TreeSet<Integer>> e : nameToTime.entrySet()) {
            List<Integer> list = new ArrayList<>(e.getValue());
            for (int i = 2; i < list.size(); ++i) {
                if (list.get(i) - list.get(i - 2) <= 60 ) {
                    names.add(e.getKey());
                    break;
                }
            }
        }
        return new ArrayList<>(names);
    }

    //Deque
    public List<String> alertNames2(String[] keyName, String[] keyTime) {
        Map<String, TreeSet<Integer>> nameToTime = new HashMap<>();
        for (int i = 0; i < keyName.length; ++i) {
            int time = Integer.parseInt(keyTime[i].substring(0, 2)) * 60 + Integer.parseInt(keyTime[i].substring(3));
            nameToTime.computeIfAbsent(keyName[i], s -> new TreeSet<>()).add(time);
        }
        TreeSet<String> names = new TreeSet<>();
        for (Map.Entry<String, TreeSet<Integer>> e : nameToTime.entrySet()) {
            Deque<Integer> dq = new ArrayDeque<>();
            for (int time : new ArrayList<>(e.getValue())) {
                dq.offer(time);
                if (dq.peekLast() - dq.peek() > 60) {
                    dq.poll();
                }
                if (dq.size() >= 3) {
                    names.add(e.getKey());
                    break;
                }
            }
        }
        return new ArrayList<>(names);
    }

    public static void main(String[] args) {
        
    }


}
