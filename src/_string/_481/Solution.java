package _string._481;

/**
 * @Description: 神奇的字符串
 * 分析：
 * 易知该字符串是没有循环的。
 * 若有循环，其次数串循环就小于该字符串，就能找到更小的循环，故没有循环。
 * @Author: matreeix
 * @Date: 2020/5/17
 */
public class Solution {
    //神奇字符串可以由自身简单生成，规则如下：
    //从头开始遍历，如果碰到1，则在字符串末尾添加一个与结尾字符串不同的字符，反之添加两个。
    public int magicalString(int n) {
        if (n == 0) return 0;
        if (n <= 3) return 1;
        int[] nums = new int[n + 1];
        int index = 2, end = 3, count = 1;
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 2;
        while (end < n) {
            //temp表示即将添加到字符串尾部的数字
            int temp = 3 - nums[end - 1];
            //index指针用于指导end指针生成字符串
            //nums[index]==2表示需要在字符串尾部添加两个temp，反之添加一个temp
            if (nums[index] == 2) {
                nums[end] = temp;
                nums[end + 1] = temp;
                //累加1出现的次数
                if (temp == 1) {
                    if (end + 1 < n)
                        count += 2;
                    else
                        count++;
                }
                end += 2;
            } else {
                nums[end] = temp;
                //累加1出现的次数
                if (temp == 1)
                    count++;
                end++;
            }
            index++;
        }
        return count;
    }
}
