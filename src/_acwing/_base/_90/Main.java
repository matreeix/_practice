package _acwing._base._90;

import java.util.Scanner;

/**
 * @Description: 90. 64位整数乘法
 * 求 a 乘 b 对 p 取模的值。
 * 输入格式
 * 第一行输入整数a，第二行输入整数b，第三行输入整数p。
 * 输出格式
 * 输出一个整数，表示a*b mod p的值。
 * 数据范围
 * 1≤a,b,p≤10^18
 * @Date: 2021/7/2
 */

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = Long.parseLong(sc.nextLine());
        long b = Long.parseLong(sc.nextLine());
        long p = Long.parseLong(sc.nextLine());
        System.out.println(qmul(a, b, p));
    }

    public static long qmul(long a, long b, long p) {
        long res = 0L % p, t = a;
        while (b > 0L) {
            if ((b & 1L) == 1L) res = (res + t) % p;
            t = (t + t) % p;
            b >>= 1L;
        }
        return res;
    }
}
