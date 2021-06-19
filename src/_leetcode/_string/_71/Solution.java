package _leetcode._string._71;

import java.util.*;

/**
 * @Description: 将linux路径规范化（用数组实现效率更快）
 * @Author: matreeix
 * @Date: 2019/8/20 21:37
 */
public class Solution {

    public static String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String dir : path.split("/")) {//通过/分割
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!skip.contains(dir)) stack.push(dir);
        }
        String res = "";
        for (String dir : stack) res = "/" + dir + res;//拼接为路径
        return res.isEmpty() ? "/" : res;
    }

    public static void main(String[] args) {
        String str1 = "/a//b////c/d//././/..";
        String str2 = "/a/./b/../../c/";
        String str3 = "/../";
        System.out.println(simplifyPath(str1));
        System.out.println(simplifyPath(str2));
        System.out.println(simplifyPath(str3));
    }
}
