package _math._13;

import java.util.HashMap;

/**
 * @Description: 13. 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * 1.I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * 2.X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * 3.C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * @Date: 2021/4/1
 */

public class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0)
            return -1;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length(), result = map.get(s.charAt(len - 1));
        for (int i = len - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) result += map.get(s.charAt(i));
            else result -= map.get(s.charAt(i));
        }
        return result;
    }

    //性能更好
    public int romanToInt2(String s) {
        int res = 0;
        for(int i = s.length()-1;i>=0;i--){
            switch(s.charAt(i)){

                case 'M':
                    res+=1000;
                    break;
                case 'D':
                    res+=500;
                    break;
                case 'C':
                    res+=100 * (res>=500?-1:1);
                    break;
                case 'L':
                    res+=50;
                    break;
                case 'X':
                    res+=10 * (res>=50?-1:1);
                    break;
                case 'V':
                    res+=5;
                    break;
                case 'I':
                    res+=1 * (res >= 5 ? -1:1);
                    break;

                default:
                    break;

            }

        }
        return res;
    }
}
