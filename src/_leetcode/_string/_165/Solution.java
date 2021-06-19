package _leetcode._string._165;

/**
 * @Description: 比较版本号大小
 * @Author: matreeix
 * @Date: 2020/3/1
 */
public class Solution {
    public static int compareVersion(String version1, String version2) {
        String[] strings1 = version1.split("\\.");
        String[] strings2 = version2.split("\\.");

        int maxLen = Math.max(strings1.length, strings2.length);
        int minLen = Math.min(strings1.length, strings2.length);


        //先比较等长的部分
        for (int i = 0; i < minLen; i++) {
            if (Integer.parseInt(strings1[i]) > Integer.parseInt(strings2[i]))
                return 1;
            else if (Integer.parseInt(strings1[i]) < Integer.parseInt(strings2[i]))
                return -1;
        }

        //比较不等长的部分
        if (minLen != maxLen) {
            for (int i = minLen; i < maxLen; i++) {
                if (maxLen == strings1.length) {
                    if (Integer.parseInt(strings1[i]) != 0)
                        return 1;
                } else {
                    if (Integer.parseInt(strings2[i]) != 0)
                        return -1;
                }
            }
        }

        return 0;
    }

    public int compareVersion2(String version1, String version2) {
        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");

        int length = Math.max(levels1.length, levels2.length);
        for (int i=0; i<length; i++) {
            Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
        }

        return 0;
    }



    public static void main(String[] args) {
//        String version1 = "0.1";
//        String version2 = "1.1";

//        String version1 = "1.0.1";
//        String version2 = "1";
//
//        String version1 = "1.1.2.1";
//        String version2 = "1.1.3";
//
        String version1 = "1.01";
        String version2 = "1.1";


        System.out.println(compareVersion(version1, version2));
    }
}
