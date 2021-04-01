package _string._14;

/**
 * @Description: 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * @Date: 2021/4/1
 */

public class Solution {

    //暴力
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        for (int i = 0; i <= strs[0].length(); i++) {
            if (i == strs[0].length()) return strs[0];
            char ch = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++)
                if (i == strs[j].length() || ch != strs[j].charAt(i))
                    return strs[0].substring(0, i);
        }
        return "";
    }

    public String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length == 0)    return "";
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
            i++;
        }
        return pre;
    }
}
