package _leetcode._design._1396;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 1396. 设计地铁系统
 * 请你实现一个类 UndergroundSystem ，它支持以下 3 种方法：
 *
 * 1. checkIn(int id, string stationName, int t)
 *
 * 编号为 id 的乘客在 t 时刻进入地铁站 stationName 。
 * 一个乘客在同一时间只能在一个地铁站进入或者离开。
 * 2. checkOut(int id, string stationName, int t)
 *
 * 编号为 id 的乘客在 t 时刻离开地铁站 stationName 。
 * 3. getAverageTime(string startStation, string endStation)
 *
 * 返回从地铁站 startStation 到地铁站 endStation 的平均花费时间。
 * 平均时间计算的行程包括当前为止所有从 startStation 直接到达 endStation 的行程。
 * 调用 getAverageTime 时，询问的路线至少包含一趟行程。
 * 你可以假设所有对 checkIn 和 checkOut 的调用都是符合逻辑的。也就是说，如果一个顾客在 t1 时刻到达某个地铁站，那么他离开的时间 t2 一定满足 t2 > t1 。所有的事件都按时间顺序给出。
 * @Date: 2021/8/28
 */

public class UndergroundSystem {
    private Map<Pair<String, String>, List<Integer>> getCnt;
    private Map<Integer, Custom> inUnderground;

    public UndergroundSystem() {
        this.inUnderground = new HashMap<>();
        this.getCnt = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        inUnderground.put(id, new Custom(id, stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Custom custom = inUnderground.get(id);
        String stationName1 = custom.stationName;
        String stationName2 = stationName;
        Pair<String, String> tmp = new Pair<>(stationName1, stationName2);
        int time = t - custom.time;
        if (getCnt.containsKey(tmp)) {
            List<Integer> val = getCnt.get(tmp);
            val.add(time);
        } else {
            getCnt.put(tmp, new ArrayList<Integer>() {{
                add(time);
            }});
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        double res = 0.0;
        List<Integer> list = getCnt.get(new Pair<>(startStation, endStation));
        for (int time : list) {
            res += time;
        }
        return res / list.size();
    }

    public class Custom {
        private int id;
        private String stationName;
        private int time;

        public Custom(int id, String stationName, int time) {
            this.id = id;
            this.stationName = stationName;
            this.time = time;
        }
    }
}
