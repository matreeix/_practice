package _array._228;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 228. 汇总区间
 * 给定一个无重复元素的有序整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * 1."a->b" ，如果 a != b
 * 2."a" ，如果 a == b
 * @Date: 2021/4/1
 */

public class Solution {
    public static List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nums.length; ++i){
            if(!(i + 1 < nums.length && nums[i] == nums[i + 1] - 1)){
                if(sb.length() > 0) sb.append("->");//已经有起始元素
                sb.append(nums[i]);
                ans.add(sb.toString());
                sb = new StringBuilder();
            } else{
                if(sb.length() == 0) sb.append(nums[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 1, 2, 4, 5, 7};
        int[] nums2 = {-1};
        System.out.println(summaryRanges(nums1));
        System.out.println(summaryRanges(nums2));
        StringBuilder sb= new StringBuilder();
        sb.append(-1);
        System.out.println(sb.length());
    }
}
