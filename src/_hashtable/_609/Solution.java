package _hashtable._609;

import java.util.*;

/**
 * @Description: 在系统中查找重复文件
 * @Author: 67ng
 * @Date: 2020/5/23
 */
public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] s = path.split(" ");
            String prefix = s[0];
            for (int i = 1; i < s.length; i++) {
                int start = s[i].indexOf("(");
                String content = s[i].substring(start + 1, s[i].length() - 1);
                String pathAll = prefix + "/" + s[i].substring(0, start);
                if (map.containsKey(content))
                    map.get(content).add(pathAll);
                else
                    map.put(content, new ArrayList<String>() {{
                        add(pathAll);
                    }});
            }
        }
        for (List pathAlls : map.values())
            if (pathAlls.size() > 1)
                res.add(pathAlls);
        return res;
    }

    public static void main(String[] args) {
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        System.out.println((new Solution()).findDuplicate(paths));
    }
}
