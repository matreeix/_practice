package _leetcode._math._204;

/**
 * @Description: 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 * @Author: matreeix
 * @Date: 2020/9/29
 */

public class Solution {
    //厄拉多塞筛法
    public static int countPrimes(int n) {
        int count = 0;
        boolean[] noPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!noPrime[i]) {
                count++;
                for (int k = 2; i * k < noPrime.length; k++)
                    noPrime[i * k] = true;
            }
        }
        return count;
    }

    //优化内存
    public static int countPrimes2(int n) {
        int count = 0;

        int[] signs = new int[n / 32 + 1];
        for (int i = 2; i < n; i++) {
            //将元素和需确定得数字经行按位或运算，如果值改变，说明不存在该数字（未登记该数字），则其为质数。
            //(当某个数为 2 的 n 次方时（n为自然数），其 & (n - 1) 所得值将等价于取余运算所得值)
            //*如果 x = 2^n ，则 x & (n - 1) == x % n
            //下面判断可以写成
            //if ((signs[i / size] & (1 << (i % 32))) == 0)
            if ((signs[i / 32] & (1 << (i & 31))) == 0) {
                count++;
                for (int j = i + i; j < n; j += i) {
                    //登记该数字
                    signs[j / 32] |= 1 << (j & 31);
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(countPrimes2(10));
        System.out.println(countPrimes2(5));
        System.out.println(countPrimes2(20));//2、3、5、7、11、13、17、19
    }
}
