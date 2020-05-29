package _stack._556;

import java.util.Arrays;

/**
 * @Description: 下一个更大元素 III
 *
 * 32位的整数是否存在相同数字组成的恰好比它大的数，没有返回-1
 * @Author: sanketdige268
 * @Date: 2019/8/16 20:39
 */

/*
 首先，让我们看一下边缘情况:
     1.如果所有数字按降序排序，则输出始终为“不可能”。例如，4321。
     2.如果所有数字都按升序排序，那么我们需要交换最后两位数字。例如，1234。
     3.对于其他情况，我们需要从最右边处理数字（为什么？因为我们需要找到所有更大数字中最小的数字）

 现在主要算法按以下步骤工作:

      I）从最右边的数字遍历给定的数字，继续遍历，直到找到小于先前遍历的数字的数字。例如，如
      果输入数字是“534976”，则我们在4处停止，因为4小于下一个数字9.如果我们没有找到这样的
      数字，则输出为“-1”。

      II）现在在上面找到的数字'd'的右侧搜索大于'd'的最小数字。对于“53 4 976”，4的右侧包
      含“976”。大于4的最小数字是6。

      III）交换上面找到的两位数，我们在上面的例子中得到53 6 97 4。

      IV）现在将所有数字从“d”旁边的位置排序到数字末尾。排序后得到的数字是输出。对于上面的示例
      ，我们以粗体536 974对数字进行排序。我们得到“536 479 ”，这是输入534976的下一个更大的数字。

*/

public class Solution {
    public int nextGreaterElement(int n) {
        char[] number = (n + "").toCharArray();

        int i, j;
        for (i = number.length - 1; i > 0; i--)
            if (number[i - 1] < number[i])
                break;

        if (i == 0)//降序数返回-1
            return -1;

        int x = number[i - 1], smallest = i;
        for (j = i + 1; j < number.length; j++)
            if (number[j] > x && number[j] <= number[smallest])
                smallest = j;//找到降序列中大于x的最小数字

        char temp = number[i - 1];
        number[i - 1] = number[smallest];
        number[smallest] = temp;

        Arrays.sort(number, i, number.length);

        long val = Long.parseLong(new String(number));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
    }

}
