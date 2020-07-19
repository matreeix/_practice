package _hashtable;

import java.util.*;

/**
 * @Description: 测试Map的性质
 * @Author: Pythagodzilla
 * @Date: 2020/7/19
 */

public class Test {
    public static void main(String[] args) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        map.put(1, new HashSet<Integer>() {{
            add(1);
            add(2);
        }});
        map.put(2, new HashSet<Integer>() {{
            add(2);
            add(3);
        }});
        map.put(3, new HashSet<Integer>() {{
            add(3);
            add(4);
            add(5);
        }});


//        java.util.ConcurrentModificationException
//        for (int ele:map.keySet())
//            if (map.get(ele)==1)
//                map.remove(ele);

//        map.keySet().removeIf(key -> map.get(key).size() == 3);
//        map.values().removeIf(value->value.contains(5));

//        for (Iterator<Integer> iterator = map.keySet().iterator(); iterator.hasNext(); ) {
//            Integer key = iterator.next();
//            if (key == 2) {
//                map.put(key,null);
//            }
//        }
        for (int i = 1; i <= map.size(); i++) {
            System.out.println(map.get(i));
        }

        System.out.println(map);
    }
}
