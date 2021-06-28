package _leetcode._CONTEST._biweekly._55;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description: 5783. 设计电影租借系统
 * 你有一个电影租借公司和 n 个电影商店。你想要实现一个电影租借系统，它支持查询、预订和返还电影的操作。同时系统还能生成一份当前被借出电影的报告。
 * 所有电影用二维整数数组 entries 表示，其中 entries[i] = [shopi, moviei, pricei] 表示商店 shopi 有一份电影 moviei 的拷贝，租借价格为 pricei 。每个商店有 至多一份 编号为 moviei 的电影拷贝。
 * 系统需要支持以下操作：
 * Search：找到拥有指定电影且 未借出 的商店中 最便宜的 5 个 。商店需要按照 价格 升序排序，如果价格相同，则 shopi 较小 的商店排在前面。如果查询结果少于 5 个商店，则将它们全部返回。如果查询结果没有任何商店，则返回空列表。
 * Rent：从指定商店借出指定电影，题目保证指定电影在指定商店 未借出 。
 * Drop：在指定商店返还 之前已借出 的指定电影。
 * Report：返回 最便宜的 5 部已借出电影 （可能有重复的电影 ID），将结果用二维列表 res 返回，其中 res[j] = [shopj, moviej] 表示第 j 便宜的已借出电影是从商店 shopj 借出的电影 moviej 。res 中的电影需要按 价格 升序排序；如果价格相同，则 shopj 较小 的排在前面；如果仍然相同，则 moviej 较小 的排在前面。如果当前借出的电影小于 5 部，则将它们全部返回。如果当前没有借出电影，则返回一个空的列表。
 * 请你实现 MovieRentingSystem 类：
 * MovieRentingSystem(int n, int[][] entries) 将 MovieRentingSystem 对象用 n 个商店和 entries 表示的电影列表初始化。
 * List<Integer> search(int movie) 如上所述，返回 未借出 指定 movie 的商店列表。
 * void rent(int shop, int movie) 从指定商店 shop 借出指定电影 movie 。
 * void drop(int shop, int movie) 在指定商店 shop 返还之前借出的电影 movie 。
 * List<List<Integer>> report() 如上所述，返回最便宜的 已借出 电影列表。
 * 注意：测试数据保证 rent 操作中指定商店拥有 未借出 的指定电影，且 drop 操作指定的商店 之前已借出 指定电影。
 * @Date: 2021/6/27
 */

public class MovieRentingSystem {
    Comparator<Entry> comparator = (o1, o2) -> {
        if (o1.price != o2.price) return Integer.compare(o1.price, o2.price);
        if (o1.shop != o2.shop) return Integer.compare(o1.shop, o2.shop);
        return Integer.compare(o1.movie, o2.movie);
    };
    HashMap<Integer, Set<Entry>> unrented = new HashMap<>(); // Map moveId -> TreeSet of Entries
    HashMap<Pair<Integer, Integer>, Integer> price = new HashMap(); // Map (shop, movie) -> price
    TreeSet<Entry> rented = new TreeSet<>(comparator);

    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] entry : entries) {
            int s = entry[0], m = entry[1], p = entry[2];
            unrented.computeIfAbsent(m, x -> new TreeSet<>(comparator)).add(new Entry(p, s, m));
            price.put(new Pair(s, m), p);
        }
    }

    public List<Integer> search(int movie) {
        return unrented.getOrDefault(movie, Collections.emptySet()).stream().limit(5).map(e -> e.shop).collect(Collectors.toList());
    }

    public void rent(int shop, int movie) {
        int p = price.get(new Pair(shop, movie));
        unrented.get(movie).remove(new Entry(p, shop, movie));
        rented.add(new Entry(p, shop, movie));
    }

    public void drop(int shop, int movie) {
        int p = price.get(new Pair(shop, movie));
        unrented.get(movie).add(new Entry(p, shop, movie));
        rented.remove(new Entry(p, shop, movie));
    }

    public List<List<Integer>> report() {
        return rented.stream().limit(5).map(e -> Arrays.asList(e.shop, e.movie)).collect(Collectors.toList());
    }

    class Entry {
        int price, shop, movie;

        public Entry(int price, int shop, int movie) {
            this.price = price;
            this.shop = shop;
            this.movie = movie;
        }
    }
}
