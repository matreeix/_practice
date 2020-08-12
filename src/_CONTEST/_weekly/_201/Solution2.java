package _CONTEST._weekly._201;

/**
 * @Description: 5484. 找出第 N 个二进制字符串中的第 K 位
 * 给你两个正整数 n 和 k，二进制字符串  Sn 的形成规则如下：
 * S1 = "0"
 * 当 i > 1 时，Si = Si-1 + "1" + reverse(invert(Si-1))
 * 其中 + 表示串联操作，reverse(x) 返回反转 x 后得到的字符串，而且 invert(x) 还会翻转 x 中的每一位（0 变为 1，而 1 变为 0）
 * <p>
 * 例如，符合上述描述的序列的前 4 个字符串依次是：
 * <p>
 * S1 = "0"
 * S2 = "011"
 * S3 = "0111001"
 * S4 = "011100110110001"
 * 请你返回  Sn 的 第 k 位字符 ，题目数据保证 k 一定在 Sn 长度范围以内。
 * @Author: matreeix
 * @Date: 2020/8/9
 */

public class Solution2 {

    //递归
    public static char findKthBit(int n, int k) {
        if (n == 1 || k == 1) return '0';
        if ((k & (k - 1)) == 0) return '1';
        int mid = 1 << (n - 1);
        if (mid == 2) {
            if (k > mid) return '1';
            else return '0';
        } else if (mid > 2) {
            if (k > mid) return findKthBit(n - 1, 2 * mid - k) == '0' ? '1' : '0';
            else if (k < mid) return findKthBit(n - 1, k);
        }
        return 'a';
    }

    //迭代
    public char findKthBit2(int n, int k) {
        int flip = 0, l = (1 << n) - 1;
        while (k > 1) {
            if (k == l / 2 + 1)//在中间
                return flip == 0 ? '1' : '0';
            if (k > l / 2) {//在右边
                k = l + 1 - k;
                flip ^= 1;//作为翻转的标记
            }
            l /= 2;
        }
        return flip == 0 ? '0' : '1';
    }

    public static void main(String[] args) {
        System.out.println(findKthBit(3, 1));
        System.out.println(findKthBit(4, 11));
        System.out.println(findKthBit(1, 1));
        System.out.println(findKthBit(2, 3));
        System.out.println(findKthBit(3, 5));
    }
}
