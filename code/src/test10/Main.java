package test10;

/**
 * Created with IntelliJ IDEA.
 * Description: 3. 无重复字符的最长子串(https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/)
 * Author: 行空XKong
 * Date: 2024-10-06
 * Time: 18:12
 * Version:
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int[] hash = new int[128];
        int left = 0, right = 0, len = 0, n = s.length();
        while (right < n) {
            ++hash[arr[right]];
            while (hash[arr[right]] > 1) {
                --hash[arr[left++]];
            }
            len = Math.max(len, right - left + 1);
            ++right;
        }
        return len;
    }
}
