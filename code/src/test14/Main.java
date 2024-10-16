package test14;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 438. 找到字符串中所有字母异位词(https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/)
 * Author: 行空XKong
 * Date: 2024-10-07
 * Time: 21:53
 * Version:
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<>();
        char[] s1 = s.toCharArray();
        char[] s2 = p.toCharArray();
        int[] hash2 = new int[26];
        for (char ch : s2) {
            ++hash2[ch - 'a'];
        }
        int[] hash1 = new int[26];
        int m = p.length();
        for (int left = 0, right = 0, count = 0; right < s1.length; ++right) {
            int in = s1[right] - 'a';
            ++hash1[in];// 进窗口
            if (hash1[in] <= hash2[in]) ++count;// 进入后更新有效元素的个数
            if (right - left + 1 > m) {// 判断
                int out = s1[left++] - 'a';
                if (hash1[out] <= hash2[out]) --count;// 出去前更新有效元素的个数
                --hash1[out];// 出窗口
            }
            // 更新结果
            if (count == m) ret.add(left);
        }
        return ret;
    }
}
