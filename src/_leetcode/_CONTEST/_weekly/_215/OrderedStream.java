package _leetcode._CONTEST._weekly._215;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 1656. 设计有序流
 * 有 n 个 (id, value) 对，其中 id 是 1 到 n 之间的一个整数，value 是一个字符串。不存在 id 相同的两个 (id, value) 对。
 * <p>
 * 设计一个流，以 任意 顺序获取 n 个 (id, value) 对，并在多次调用时 按 id 递增的顺序 返回一些值。
 * <p>
 * 实现 OrderedStream 类：
 * <p>
 * 1.OrderedStream(int n) 构造一个能接收 n 个值的流，并将当前指针 ptr 设为 1 。
 * 2.String[] insert(int id, String value) 向流中存储新的 (id, value) 对。存储后：
 * a.如果流存储有 id = ptr 的 (id, value) 对，则找出从 id = ptr 开始的 最长 id 连续递增序列 ，并 按顺序 返回与这些 id 关联的值的列表。然后，将 ptr 更新为最后那个  id + 1 。
 * b.否则，返回一个空列表。
 * @Author: matreeix
 * @Date: 2020/11/21
 */

public class OrderedStream {
    private String[] arr;
    private int n;
    private int ptr;

    public OrderedStream(int n) {
        this.n = n;
        this.ptr = 1;
        this.arr = new String[n + 1];
    }

    public List<String> insert(int id, String value) {
        arr[id] = value;

        List<String> res = new ArrayList<>();
        while (ptr <= n && arr[ptr] != null) {
            res.add(arr[ptr]);
            ptr++;
        }
        return res;
    }
}
