package test4;

/**
 * Created with IntelliJ IDEA.
 * Description: 11. 盛最多水的容器(https://leetcode.cn/problems/container-with-most-water/)
 * Author: 行空XKong
 * Date: 2024-10-05
 * Time: 11:20
 * Version:
 */
class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxV = 0;
        while (left < right) {
            int v = (right - left) * Math.min(height[left], height[right]);
            maxV = maxV > v ? maxV : v;
            if (height[left] < height[right]) {
                ++left;
            } else {
                --right;
            }
        }
        return maxV;
    }
}
