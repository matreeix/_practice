package _leetcode._math._367;

/**
 * @description ：魔法数 0x5f3759df和0x5f375a86
 * @date ： 2020-02-18
 */
public class Solution3 {
   /* public int sqrt(float x) {
        if (x == 0) return 0;
        float result = x;
        float xhalf = 0.5f * result;
        int i = *(int*)&result;
        i = 0x5f375a86 - (i >> 1); // what the fuck?
        result = *(float*)&i;
        result = result * (1.5f - xhalf * result * result); // Newton step, repeating increases accuracy
        result = result * (1.5f - xhalf * result * result);
        return 1.0f / result;
    }*/
}
