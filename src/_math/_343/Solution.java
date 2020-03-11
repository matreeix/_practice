package _math._343;

/**
 * @Description:
 * 给定一个正整数n，将其分解为至少两个正整数的和，
 * 并使这些整数的乘积最大化。返回您可以获得的最大值
 *
 * @Author: 67ng
 * @Date: 2020/3/11
 */
public class Solution {
    //使用dp
    public static long IntegerBreak1(int num) {
        long[] mem = new long[num + 1];
        mem[0] = 0;
        mem[1] = 1;
        for (int i = 2; i <= num; i++) {
            for (int j = 1; j < i; j++) {
                mem[i] = Math.max(mem[i], Math.max(mem[i - j] * j, j * (i - j)));
            }
        }
        return mem[num];
    }

    //优化dp
    public static long IntegerBreak2(int num) {
        long[] mem = new long[num + 1];
        mem[0] = 0;
        mem[1] = 1;
        mem[2] = 1;
        mem[3] = 2;
        mem[4] = 4;
        mem[5] = 6;
        mem[6] = 9;
        for (int i = 7; i <= num; i++) {
            for (int j = 1; j < i; j++) {
                mem[i] = Math.max(mem[i], mem[i - j] * j);
            }
        }
        return mem[num];
    }

    //使用数学方法
    public static long IntegerBreak3(int num) {
        if (num <= 3) return num - 1;
        int a = num / 3, b = num % 3;
        if (b == 0) return (int) Math.pow(3, a);
        if (b == 1) return (int) Math.pow(3, a - 1) * 4;
        return (int) Math.pow(3, a) * 2;
    }

    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        System.out.println(IntegerBreak1(100));
        System.out.println("spend1:" + (System.currentTimeMillis() - start1));
        long start2 = System.currentTimeMillis();
        System.out.println(IntegerBreak2(100));
        System.out.println("spend2:" + (System.currentTimeMillis() - start2));
        long start3 = System.currentTimeMillis();
        System.out.println(IntegerBreak3(100));
        System.out.println("spend3:" + (System.currentTimeMillis() - start3));

    }
}
