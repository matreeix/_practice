package _leetcode._array._11;

/**
 * @Description: 容器能装的最大水容量
 * 算法原理：
 * 给定a1，a2，a3 ... an作为输入数组。假设a10和a20是最大面积情况。我们需要证明左指针可以到达a10，
 * 并且在左指针停留在a10的时间内，右指针可以到达a20。
 * 核心问题是要证明：当左指针位于a10且右指针位于a21时，下一个动作必须是指向a20的右指针。
 *证明如下：
 * 由于我们总是将指针移动到较小的值，即如果a10> a21，则应按照希望将指针从a21移到a20。
 * 为什么a10> a21？因为如果a21> a10，则a10和a20的面积必须小于a10和a21的面积。
 * 因为a10和a21的面积至少为高度[a10] *（21-10），而a10和a20的面积最大为高度[a10] *（20-10）。
 * 因此，假设a10与a20具有最大面积是矛盾的。因此，a10必须大于a21，然后下一移动a21必须移动到a20。所以可以达到面积最大的状态。
 * @Date: 2020/2/20
 */
public class Solution {
    /*
    *
    * 这种解法其实可以看做一种贪心算法
    * */
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int right = height.length - 1;
        int left = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));//维护了最大面积的值
            //下面的代码保证了可以达到面积最大的状态
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(arr));
    }
}
