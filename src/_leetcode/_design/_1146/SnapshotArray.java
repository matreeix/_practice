package _leetcode._design._1146;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @Description: 1146. 快照数组
 * 实现支持下列接口的「快照数组」- SnapshotArray：
 * SnapshotArray(int length) - 初始化一个与指定长度相等的 类数组 的数据结构。初始时，每个元素都等于 0。
 * void set(index, val) - 会将指定索引 index 处的元素设置为 val。
 * int snap() - 获取该数组的快照，并返回快照的编号 snap_id（快照号是调用 snap() 的总次数减去 1）。
 * int get(index, snap_id) - 根据指定的 snap_id 选择快照，并返回该快照指定索引 index 的值。
 * @Date: 2021/11/18
 */

public class SnapshotArray {
    private List<TreeMap<Integer, Integer>> listMap;
    private int snapId;

    public SnapshotArray(int length) {
        this.snapId = 0;
        this.listMap = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            listMap.add(new TreeMap<Integer, Integer>() {{
                put(0, 0);
            }});
        }
    }

    public void set(int index, int val) {
        TreeMap<Integer, Integer> map = listMap.get(index);
        map.put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        TreeMap<Integer, Integer> map = listMap.get(index);
        return map.get(map.floorKey(snap_id));
    }
}
