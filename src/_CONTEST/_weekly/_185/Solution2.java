package _CONTEST._weekly._185;

import java.util.*;

/**
 * @Description: 1418. 点菜展示表
 * 给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders[i]=[customerNamei,tableNumberi,foodItemi] ，
 * 其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
 * 请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，
 * 后面每一列都是按字母顺序排列的餐品名称。接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
 * 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
 * @Author: Pythagodzilla
 * @Date: 2020/7/22
 */

public class Solution2 {
    public static List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> res = new ArrayList<>();
        List<String> firstRow = new ArrayList<>();
        firstRow.add("Table");
        TreeSet<String> set = new TreeSet<>();
        TreeMap<Integer, Map<String, Integer>> map = new TreeMap<>();
        for (List<String> order : orders) {
            String dish = order.get(2);
            set.add(dish);
            Integer table = Integer.parseInt(order.get(1));
            map.putIfAbsent(table, new HashMap<>());
            if (map.get(table).containsKey(dish)) {
                Map<String, Integer> m = map.get(table);
                m.put(dish, m.getOrDefault(dish, 0) + 1);
            } else {
                map.get(table).put(dish, 1);
            }
        }

        firstRow.addAll(set);
        res.add(firstRow);
        for (Map.Entry<Integer, Map<String, Integer>> entry : map.entrySet()) {
            List<String> list = new ArrayList<>();
            list.add(entry.getKey() + "");
            Map<String, Integer> m = entry.getValue();
            for (String dish : set) {
                if (m.containsKey(dish)) {
                    list.add(m.get(dish) + "");
                } else {
                    list.add("0");
                }
            }
            res.add(list);
        }
        return res;

    }

    public static void main(String[] args) {
        List<List<String>> orders = new ArrayList<>();
        List<String> order1 = Arrays.asList("David", "3", "Ceviche");
        List<String> order2 = Arrays.asList("Corina", "10", "Beef Burrito");
        List<String> order3 = Arrays.asList("David", "3", "Fried Chicken");
        List<String> order4 = Arrays.asList("Carla", "5", "Water");
        List<String> order5 = Arrays.asList("Carla", "5", "Ceviche");
        List<String> order6 = Arrays.asList("Rous", "3", "Ceviche");
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);
        orders.add(order6);

        System.out.println(displayTable(orders));
    }
}
