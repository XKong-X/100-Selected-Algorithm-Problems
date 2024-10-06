package test8;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 18. 四数之和(https://leetcode.cn/problems/4sum/description/)
 * Author: 行空XKong
 * Date: 2024-10-05
 * Time: 19:50
 * Version:
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; ) {
            for (int j = i + 1; j < n; ) {
                int left = j + 1, right = n - 1;
                long tmpTarget = target - (long) (nums[i] + nums[j]);
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum < tmpTarget) {
                        ++left;
                    } else if (sum > tmpTarget) {
                        --right;
                    } else {
                        ret.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        ++left;
                        right--;// 缩小区间
                        // 去重
                        while (left < right && nums[left - 1] == nums[left]) {
                            ++left;
                        }
                        while (left < right && nums[right + 1] == nums[right]) {
                            --right;
                        }
                    }
                }
                ++j;// 缩小区间
                // 去重
                while (j < n && nums[j - 1] == nums[j]) {
                    ++j;
                }
            }
            ++i;// 缩小区间
            // 去重
            while (i < n && nums[i - 1] == nums[i]) {
                ++i;
            }
        }
        return ret;
    }
}
