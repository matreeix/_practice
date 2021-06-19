package _leetcode._math._906;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 打表法
 * @Date: 2021/3/20
 */

public class Solution3 {

    public int superpalindromesInRange(String left, String right) {
        Long nl = Long.valueOf(left);
        Long nr = Long.valueOf(right);
        List<Long> ans = new ArrayList<>();
        ans.add(1L);
        ans.add(4L);
        ans.add(9L);
        ans.add(121L);
        ans.add(484L);
        ans.add(10201L);
        ans.add(12321L);
        ans.add(14641L);
        ans.add(40804L);
        ans.add(44944L);
        ans.add(1002001L);
        ans.add(1234321L);
        ans.add(4008004L);
        ans.add(100020001L);
        ans.add(102030201L);
        ans.add(104060401L);
        ans.add(121242121L);
        ans.add(123454321L);
        ans.add(125686521L);
        ans.add(400080004L);
        ans.add(404090404L);
        ans.add(10000200001L);
        ans.add(10221412201L);
        ans.add(12102420121L);
        ans.add(12345654321L);
        ans.add(40000800004L);
        ans.add(1000002000001L);
        ans.add(1002003002001L);
        ans.add(1004006004001L);
        ans.add(1020304030201L);
        ans.add(1022325232201L);
        ans.add(1024348434201L);
        ans.add(1210024200121L);
        ans.add(1212225222121L);
        ans.add(1214428244121L);
        ans.add(1232346432321L);
        ans.add(1234567654321L);
        ans.add(4000008000004L);
        ans.add(4004009004004L);
        ans.add(100000020000001L);
        ans.add(100220141022001L);
        ans.add(102012040210201L);
        ans.add(102234363432201L);
        ans.add(121000242000121L);
        ans.add(121242363242121L);
        ans.add(123212464212321L);
        ans.add(123456787654321L);
        ans.add(400000080000004L);
        ans.add(10000000200000001L);
        ans.add(10002000300020001L);
        ans.add(10004000600040001L);
        ans.add(10020210401202001L);
        ans.add(10022212521222001L);
        ans.add(10024214841242001L);
        ans.add(10201020402010201L);
        ans.add(10203040504030201L);
        ans.add(10205060806050201L);
        ans.add(10221432623412201L);
        ans.add(10223454745432201L);
        ans.add(12100002420000121L);
        ans.add(12102202520220121L);
        ans.add(12104402820440121L);
        ans.add(12122232623222121L);
        ans.add(12124434743442121L);
        ans.add(12321024642012321L);
        ans.add(12323244744232321L);
        ans.add(12343456865434321L);
        ans.add(12345678987654321L);
        ans.add(40000000800000004L);
        ans.add(40004000900040004L);
        int n = ans.size();
        int l = 0, r = n;
        while (l < r) {//二分查找法
            int m = l + (r - l) / 2;
            if (ans.get(m) >= nl) r = m;
            else l = m + 1;
        }
        int l1 = l;
        l = 0;
        r = n;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (ans.get(m) > nr) r = m;
            else l = m + 1;
        }
        int l2 = l - 1;
        return (l2 - l1 + 1);
    }

}
