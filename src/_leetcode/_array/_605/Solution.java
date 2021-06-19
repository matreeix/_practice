package _leetcode._array._605;

/**
 * @Description: 数组中1代表种了花，0代表为空，相邻之间花不能挨着，求给定数组能否种植n朵花
 * @Author: matreeix
 * @Date: 2019/7/26 21:04
 */
//思路：
//  连续0的个数为m,则能种植花的朵数为n,则:
//      在中间(必须至少3个0)
//            偶数：n = (m-2)/2
//            奇数：n = (m-1)/2
//      靠边
//            偶数：n = m/2(两个0就可以种树)
//            奇数：n = (m-1)/2
//      全为0
//            偶数：n = m/2
//            奇数：n = (m+1)/2(一个0也可以种树)
public class Solution {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {//贪心算法
        int len = flowerbed.length;
        int index = 0;
        while (index < len) {
            if (index == 0) {
                if (flowerbed[1] == 1) {
                    index = 3;
                } else {
                    n--;
                    index = 2;
                }
            } else if (index == len - 1) {
                if (flowerbed[index - 1] == 1) index++;
                else {
                    n--;
                    index++;
                }
            } else {
                if (flowerbed[index] == 1) {//当前索引已经被种植直接考察下一个可能的位置
                    index = index + 2;
                } else {//当前位置为空
                    if (flowerbed[index + 1] == 1) {
                        index = index + 3;
                    } else {
                        if (flowerbed[index - 1] == 0) {
                            n--;
                            index = index + 2;
                        } else {
                            index = index + 1;
                        }
                    }
                }
            }
        }
        return n <= 0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 0, 1};
        int n = 2;
        System.out.println(canPlaceFlowers(arr, n));
    }
}
