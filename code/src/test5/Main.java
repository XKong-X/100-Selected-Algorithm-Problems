package test5;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 611. 有效三角形的个数(https://leetcode.cn/problems/valid-triangle-number/description/)
 * Author: 行空XKong
 * Date: 2024-10-05
 * Time: 12:25
 * Version:
 */
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ret = 0, n = nums.length;
        for (int c = n - 1; c >= 0; --c) {
            int left = 0, right = c - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[c]) {
                    ret += right - left;
                    --right;
                } else {
                    ++left;
                }
            }
        }
        return ret;
    }
}
