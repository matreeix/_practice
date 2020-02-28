package _array._457;

/**
 * @Description: 环形数组判断
 * @Author: 67ng
 * @Date: 2020/2/28
 */
public class Solution {
    public boolean circularArrayLoop(int[] nums) {
        if (nums.length < 2) return false;

        for (int i = 0; i < nums.length; i++) {
            if (findLoop(nums, i))
                return true;
        }
        return false;
    }

    //判断从startIndex出发能否找到合格的环形数组
    public boolean findLoop(int[] nums, int startIndex) {
        boolean[] visited = new boolean[nums.length];
        int curIndex = startIndex;
        int nextIndex = 0;
        while (true) {//找到循环开始的索引
            if (visited[curIndex] == true)
                break;
            else
                visited[curIndex] = true;
            if (nums[curIndex] > 0) {
                nextIndex = (nums[curIndex] + curIndex) % nums.length;
            } else if (nums[curIndex] < 0) {
                int temp = (nums[curIndex] + curIndex) % nums.length;
                nextIndex = temp >= 0 ? temp : nums.length + temp;
            }
            curIndex = nextIndex;
        }

        int start = curIndex;
        do {//再循环一遍，判断是否合格
            if (nums[curIndex] > 0) {
                nextIndex = (nums[curIndex] + curIndex) % nums.length;
            } else if (nums[curIndex] < 0) {
                int temp = (nums[curIndex] + curIndex) % nums.length;
                nextIndex = temp >= 0 ? temp : nums.length + temp;
            }
            if (curIndex == nextIndex)//循环长度为1
                return false;
            if ((nums[curIndex] ^ nums[nextIndex]) < 0)//有反向
                return false;
            curIndex = nextIndex;
        } while (start != curIndex);
        return true;
    }
}
