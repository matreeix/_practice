package _leetcode._design._2034;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Description:
 * @Date: 2021/11/10
 */

public class StockPrice2 {
    PriorityQueue<StockItem> minPq;
    PriorityQueue<StockItem> maxPq;
    Map<Integer, Integer> map;
    int latestTime = -1;

    public StockPrice2() {
        map = new HashMap<>();
        minPq = new PriorityQueue<>(Comparator.comparingInt(a -> a.price));
        maxPq = new PriorityQueue<>((a, b) -> b.price - a.price);
    }

    public void update(int timestamp, int price) {
        latestTime = Math.max(latestTime, timestamp);
        StockItem item = new StockItem(timestamp, price);
        minPq.offer(item);
        maxPq.offer(item);
        map.put(timestamp, price);
    }

    public int current() {
        return map.get(latestTime);
    }

    public int maximum() {
        StockItem item;
        while (true) {
            item = maxPq.peek();
            int timestamp = item.timestamp;
            if (item.price != map.get(timestamp)) {
                maxPq.poll();
            } else {
                break;
            }
        }
        return item.price;
    }

    public int minimum() {
        StockItem item;
        while (true) {
            item = minPq.peek();
            int timestamp = item.timestamp;
            if (item.price != map.get(timestamp)) {
                minPq.poll();
            } else {
                break;
            }
        }
        return item.price;
    }
}

class StockItem {
    int timestamp;
    int price;

    public StockItem(int timestamp, int price) {
        this.timestamp = timestamp;
        this.price = price;
    }
}
