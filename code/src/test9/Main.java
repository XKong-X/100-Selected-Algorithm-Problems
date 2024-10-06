package test9;

/**
 * Created with IntelliJ IDEA.
 * Description: 209. 长度最小的子数组(https://leetcode.cn/problems/minimum-size-subarray-sum/description/)
 * Author: 行空XKong
 * Date: 2024-10-06
 * Time: 16:56
 * Version:
 */
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, sum = 0, len = Integer.MAX_VALUE;
        int left = 0, right = 0;
        while (right < n ) {
            sum += nums[right];
            while (sum >= target) {
                int tmp = right - left + 1;
                if (tmp < len) len = tmp;
                sum -= nums[left];
                ++left;
            }
            ++right;
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
