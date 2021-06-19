package _leetcode._math._441;

/**
 * @Description: 441. 排列硬币
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 * @Date: 2021/3/25
 */

public class Solution {

    public static int arrangeCoins(int n) {
        long sqr = (long) Math.sqrt(n * 2L);
        if (sqr * (sqr + 1L) <= n * 2L) {
            return (int) sqr;
        } else {
            return (int) (sqr - 1);
        }
    }

    //二次方程根
    public int arrangeCoins2(int n) {
        return (int)(Math.sqrt(2) * Math.sqrt(n + 0.125) - 0.5);
    }

    //二分查找
    public int arrangeCoins3(int n) {
        int res=0;
        int l=1,r=n;
        while(l<=r){
            long  m=l+(r-l)/2;
            if(m*(m+1)/2==n) return (int)m;
            else if(m*(m+1)/2<n){
                res=(int)m;
                l=(int)m+1;
            }
            else r=(int)m-1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(10));//4
        System.out.println(arrangeCoins(4));//2
        System.out.println(arrangeCoins(8));//3
        System.out.println(arrangeCoins(1804289383));//60070
    }

}
