package _leetcode._greedy._406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 406. 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 * @Created by: matreeix
 * @Date: 2021/5/24
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //按照 hi为第一关键字降序，ki为第二关键字升序进行排序。
        Arrays.sort(people, (person1, person2) -> person1[0] != person2[0]
                ? person2[0] - person1[0]
                : person1[1] - person2[1]);
        List<int[]> ans = new ArrayList<int[]>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
