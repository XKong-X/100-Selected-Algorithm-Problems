package test11;

/**
 * Created with IntelliJ IDEA.
 * Description: 1004. 最大连续1的个数 III(https://leetcode.cn/problems/max-consecutive-ones-iii/description/)
 * Author: 行空XKong
 * Date: 2024-10-06
 * Time: 19:16
 * Version:
 */
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, zeroCount = 0, n = nums.length, ret = 0;
        while (right < n) {
            // 进窗口
            if (nums[right] == 0) {
                ++zeroCount;
            }
            while (zeroCount > k) {// 判断
                if (nums[left++] == 0) {// 出窗口 + 更新计数器
                    --zeroCount;
                }
            }
            ret = Math.max(right - left + 1, ret);// 更新
            ++right;
        }
        return ret;
    }
}
