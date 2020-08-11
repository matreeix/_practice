package backtracking._89;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 格雷编码
 * <p>
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * <p>
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
 * <p>
 * 格雷编码序列必须以 0 开头。
 * @Author: caffebaby
 * @Date: 2020/6/14
 */
public class Solution {

    /**
     * 构造法，镜像反射(妙啊！)
     * <p>
     * 思路：
     * 设 n 阶格雷码集合为 G(n)，则 G(n+1) 阶格雷码为：
     * 给 G(n) 阶格雷码每个元素二进制形式前面添加 0，得到 G'(n)；
     * 设 G(n) 集合倒序（镜像）为 R(n)，给 R(n) 每个元素二进制形式前面添加 1，得到 R'(n)；
     * G(n+1) = G'(n) ∪ R'(n) 拼接两个集合即可得到下一阶格雷码。
     * <p>
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/gray-code/solution/gray-code-jing-xiang-fan-she-fa-by-jyd/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {{
            add(0);
        }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));
            head <<= 1;
        }
        return res;
    }

    //二进制转格雷码公式法，位运算，性能最优
    public List<Integer> grayCode2(int n) {
        List<Integer> res = new ArrayList<>();
        int store = (1 << n);
        for (int i = 0; i < store; i++) {
            res.add(i ^ (i >> 1));
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(41 ^ 33);
    }

}
