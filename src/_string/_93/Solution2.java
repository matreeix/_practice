package _string._93;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 4loop法
 * @Author: matreeix
 * @Date: 2020/3/3
 */
public class Solution2 {
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();

        StringBuffer ip = new StringBuffer();
        for (int a = 1; a <= 3; a++)
            for (int b = 1; b <= 3; b++)
                for (int c = 1; c <= 3; c++)
                    for (int d = 1; d <= 3; d++) {
                        if (a + b + c + d == s.length()) {
                            int n1 = Integer.parseInt(s.substring(0, a));//[0,a)->a
                            int n2 = Integer.parseInt(s.substring(a, a + b));//[a,a+b)->b
                            int n3 = Integer.parseInt(s.substring(a + b, a + b + c));//[a+b,a+b+c)->c
                            int n4 = Integer.parseInt(s.substring(a + b + c));//[a+b+c,s.length()-1]->d
                            if (n1 <= 255 && n2 <= 255 && n3 <= 255 && n4 <= 255) {
                                ip.append(n1).append('.').append(n2).append('.').append(n3).append('.').append(n4);
                                if (ip.length() == s.length() + 3) //去掉了"xx.00.xx"这种不合格的ip
                                    ret.add(ip.toString());
                                ip.delete(0, ip.length());
                            }
                        }
                    }
        return ret;
    }

    public static void main(String[] args) {
        String s = "25525511135";//["255.255.11.135", "255.255.111.35"]
        System.out.println((new Solution2()).restoreIpAddresses(s));
    }

}
