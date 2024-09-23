package test1;

/**
 * Created with IntelliJ IDEA.
 * Description: 283. 移动零(https://leetcode.cn/problems/move-zeroes/description/)
 * Author: 行空XKong
 * Date: 2024-09-24
 * Time: 0:20
 * Version:
 */
class Solution {
    public void moveZeroes(int[] nums) {
        for (int i = -1, j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                ++i;
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
    }
}
