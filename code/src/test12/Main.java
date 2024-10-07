package test12;

/**
 * Created with IntelliJ IDEA.
 * Description: 1658. 将 x 减到 0 的最小操作数(https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/description/)
 * Author: 行空XKong
 * Date: 2024-10-07
 * Time: 0:57
 * Version:
 */
class Solution {
    public int minOperations(int[] nums, int x) {
        int left = 0, right = 0, len = -1, sum = 0, n = nums.length;// len 不能初始化为 0, 初始化为 0 时，若整个数组加起来才等于 target ，则 sum == target（即等于0）一直成立，导致最后返回 -1
        for (int tmp : nums) sum += tmp;
        int target = sum - x;
        sum = 0;
        if (target < 0) return -1;
        while (right < n) {
            sum += nums[right];
            while (sum > target) {
                sum -= nums[left++];
            }
            if (sum == target) {
                len = Math.max(len, right - left + 1);
            }
            ++right;
        }
        return len == -1 ? len : n - len;
    }
}
