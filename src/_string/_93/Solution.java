package _string._93;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 恢复IP地址
 * <p>
 * 有效IP地址的定义：
 * 1.不带“.”的ip的长度应该等于s的长度；
 * 2. ip的数字顺序应与s的数字顺序相同；
 * 3.每个部分均以“.”分隔，且除了“0”外，不应以“0”开头；
 * 4.每个部分均以“.”分隔，且值位于[0,255]。
 * @Author: 67ng
 * @Date: 2020/3/1
 */

/*
* 回溯法
* */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        doRestore(result, "", s, 0);
        return result;
    }

    private void doRestore(List<String> result, String path, String s, int k) {
        if (s.isEmpty() || k == 4) {
            if (s.isEmpty() && k == 4)
                result.add(path.substring(1));
            return;
        }
        for (int i = 1; i <= (s.charAt(0) == '0' ? 1 : 3) && i <= s.length(); i++) { // Avoid leading 0
            String part = s.substring(0, i);
            if (Integer.valueOf(part) <= 255)
                doRestore(result, path + "." + part, s.substring(i), k + 1);
        }
    }

    public static void main(String[] args) {
//        String s = "010010";//["0.1.0.10","0.1.1.0","0.10.0.10","0.10.1.0","0.100.1.0","1.0.0.10","1.0.1.0","10.0.1.0"]
        String s = "25525511135";//["255.255.11.135", "255.255.111.35"]
        System.out.println((new Solution()).restoreIpAddresses(s));
    }
}
