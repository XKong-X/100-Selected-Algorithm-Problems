package test7;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 15. 三数之和(https://leetcode.cn/problems/3sum/description/)
 * Author: 行空XKong
 * Date: 2024-10-05
 * Time: 15:40
 * Version:
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < nums.length;) {
            if (nums[i] > 0) return ret;
            int left = i + 1, right = nums.length - 1, target = -nums[i];
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum < target) {
                    ++left;
                } else if (sum > target) {
                    --right;
                } else {
                    // 加入
                    ret.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    ++left;--right;// 缩小区间
                    // 去重
                    while (left < right && nums[left - 1] == nums[left]) {
                        ++left;
                    }
                    while (left < right && nums[right + 1] == nums[right]) {
                        --right;
                    }
                }
            }
            ++i;
            // 再次去重
            while (i < nums.length && nums[i - 1] == nums[i]) {
                ++i;
            }
        }
        return ret;
    }
}
