package _leetcode._design._1472;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 1472. 设计浏览器历史记录
 * 你有一个只支持单个标签页的 浏览器 ，最开始你浏览的网页是 homepage ，你可以访问其他的网站 url ，也可以在浏览历史中后退 steps 步或前进 steps 步。
 *
 * 请你实现 BrowserHistory 类：
 *
 * BrowserHistory(string homepage) ，用 homepage 初始化浏览器类。
 * void visit(string url) 从当前页跳转访问 url 对应的页面  。执行此操作会把浏览历史前进的记录全部删除。
 * string back(int steps) 在浏览历史中后退 steps 步。如果你只能在浏览历史中后退至多 x 步且 steps > x ，那么你只后退 x 步。请返回后退 至多 steps 步以后的 url 。
 * string forward(int steps) 在浏览历史中前进 steps 步。如果你只能在浏览历史中前进至多 x 步且 steps > x ，那么你只前进 x 步。请返回前进 至多 steps步以后的 url 。
 * @Date: 2021/8/27
 */

public class BrowserHistory {
    private List<String> list;
    private int cur;
    private int tail;

    public BrowserHistory(String homepage) {
        this.list = new ArrayList<>();
        this.cur = 0;
        this.tail = 0;
        list.add(homepage);
    }

    public void visit(String url) {
        list.add(++cur, url);
        tail = cur;
    }

    public String back(int steps) {
        if (steps <= cur) {
            cur -= steps;
        } else {
            cur = 0;
        }
        return list.get(cur);
    }

    public String forward(int steps) {
        if (steps <= tail - cur) {
            cur += steps;
        } else {
            cur = tail;
        }
        return list.get(cur);
    }
}
