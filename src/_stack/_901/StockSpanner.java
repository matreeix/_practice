package _stack._901;

/**
 * @Description: 901. 股票价格跨度
 * 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
 * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
 * <p>
 * 提示：
 * 1.调用 StockSpanner.next(int price) 时，将有 1 <= price <= 10^5。
 * 2.每个测试用例最多可以调用  10000 次 StockSpanner.next。
 * 3.在所有测试用例中，最多调用 150000 次 StockSpanner.next。
 * 4.此问题的总时间限制减少了 50%。
 * @Date: 2021/3/18
 */

public class StockSpanner {
    private int[] val;
    private int[] store;
    private int idx;

    public StockSpanner() {
        this.val = new int[10001];
        this.store = new int[10001];
        this.idx = 0;
    }

    public int next(int price) {
        val[idx] = price;
        int res = 1;
        int i = idx - 1;
        while ( i >= 0 && val[i] <=price ) {
            res += store[i];
            i -= store[i];//跳跃式减少
        }
        store[idx++] = res;
        return res;
    }

    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();
        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(60));
        System.out.println(obj.next(70));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));
        System.out.println(obj.next(85));
    }
}
