package _leetcode._search._1760;

/**
 * @Description: 1760. 袋子里最少数目的球
 * 给你一个整数数组 nums ，其中 nums[i] 表示第 i 个袋子里球的数目。同时给你一个整数 maxOperations 。
 * 你可以进行如下操作至多 maxOperations 次：
 * 选择任意一个袋子，并将袋子里的球分到 2 个新的袋子中，每个袋子里都有 正整数 个球。
 * 比方说，一个袋子里有 5 个球，你可以把它们分到两个新袋子里，分别有 1 个和 4 个球，或者分别有 2 个和 3 个球。
 * 你的开销是单个袋子里球数目的 最大值 ，你想要 最小化 开销。
 * 请你返回进行上述操作后的最小开销。
 * @Date: 2021/2/21
 */

public class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int max = 0;
        for (int i : nums) max = Math.max(max, i);
        if (max == 1) return 1;
        int cnt = 0, l = 1, r = max;
        while (l < r) {
            int mid = l + (r - l) / 2;
            cnt = 0;
            for (int num : nums)
                cnt += (num - 1) / mid;//将n拆成max的最少开销次数
            if (cnt > maxOperations) {//需要的操作次数不够
                l = mid + 1;
            } else {//操作次数溢出
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {431, 922, 158, 60, 192, 14, 788, 146, 788, 775, 772, 792, 68, 143, 376, 375, 877, 516, 595, 82, 56, 704, 160, 403, 713, 504, 67, 332, 26};
        System.out.println((new Solution()).minimumSize(nums, 80));//129

        int[] nums1 = {9};
        System.out.println((new Solution()).minimumSize(nums1, 2));//3

        int[] nums2 = {2, 4, 8, 2};
        System.out.println((new Solution()).minimumSize(nums2, 4));//2

        int[] nums3 = {7, 17};
        System.out.println((new Solution()).minimumSize(nums3, 2));//7

        int[] nums4 = {501, 67, 484, 937, 816, 895, 294, 240, 736, 245, 266, 698, 371, 538, 265, 309, 422, 476, 827, 816, 927, 379, 732, 941, 119, 303, 914, 311, 518, 843, 359, 198, 341, 633, 671, 22, 23, 235, 556, 92, 239, 389, 393, 74, 799, 792, 477, 696, 150, 39, 979, 97, 330, 81, 798, 630, 954, 955, 633, 438, 342, 909, 103, 82, 184, 240, 693, 705, 225, 55, 311, 181, 422, 371, 177, 156, 138, 806, 255, 633, 801, 427, 214, 49, 957, 738, 325, 317, 576, 117, 955, 931, 83, 100, 931, 227, 616, 109, 333, 285, 113, 744, 398, 981, 760};
        System.out.println((new Solution()).minimumSize(nums4, 92));//333
    }

}
