package test6;

/**
 * Created with IntelliJ IDEA.
 * Description: LCR 179. 查找总价格为目标值的两个商品(https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/description/)
 * Author: 行空XKong
 * Date: 2024-10-05
 * Time: 12:42
 * Version:
 */
class Solution {
    public int[] twoSum(int[] price, int target) {
        int left = 0, right = price.length - 1;
        int[] arr = {-1, -1};
        while (left < right) {
            if (price[left] + price[right] < target) {
                ++left;
            } else if (price[left] + price[right] > target) {
                --right;
            } else {
                arr[0] = price[left];
                arr[1] = price[right];
                break;
            }
        }
        return arr;
    }
}
