package _CONTEST._weekly._198;

/**
 * @Description: 5464. 水壶
 * <p>
 * 给定numBottles 满水的瓶子，您可以将numExchange空水瓶换成一个满的水瓶。
 * 喝满水的瓶子的操作会将其变成空瓶子。
 * 返回您可以喝的最大水瓶数量。
 * @Author: Pythagodzilla
 * @Date: 2020/7/19
 */

public class Solution1 {
    //模拟法，O(logN)
    public static int numWaterBottles(int numBottles, int numExchange) {
        if (numBottles < numExchange) return numBottles;
        int res = numBottles;
        int empty = numBottles;
        while (empty >= numExchange) {
            res += empty / numExchange;
            empty = empty % numExchange + empty / numExchange;
        }
        return res;
    }

    //数学法
    public static int numWaterBottles2(int numBottles, int numExchange) {
        return numBottles + (numBottles - 1) / (numExchange - 1);
    }

    public static void main(String[] args) {
        int numBottles1 = 9, numExchange1 = 3;
        int numBottles2 = 15, numExchange2 = 4;
        int numBottles3 = 5, numExchange3 = 5;

        System.out.println(numWaterBottles(numBottles1, numExchange1));//13
        System.out.println(numWaterBottles(numBottles2, numExchange2));//19
        System.out.println(numWaterBottles(numBottles3, numExchange3));//6
    }
}
