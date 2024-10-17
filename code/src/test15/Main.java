package test15;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 30. 串联所有单词的子串(https://leetcode.cn/problems/substring-with-concatenation-of-all-words/description/)
 * Author: 行空XKong
 * Date: 2024-10-16
 * Time: 22:57
 * Version:
 */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        Map<String, Integer> hash1 = new HashMap<>();
        for (String str : words) {
            hash1.put(str, hash1.getOrDefault(str, 0) + 1);
        }
        int n = words[0].length(), m = words.length;
        for (int i = 0; i < n; ++i) {// 执行次数
            Map<String, Integer> hash2 = new HashMap<>();
            for (int left = i, right = i, count = 0; right + n <= s.length(); right += n) {
                String in = s.substring(right, right + n);
                hash2.put(in, hash2.getOrDefault(in, 0) + 1);// 进窗口
                if (hash2.get(in) <= hash1.getOrDefault(in, 0)) ++count;// 更新 count
                if (right - left + 1 > n * m) {// 判断
                    String out = s.substring(left, left + n);
                    if (hash2.get(out) <= hash1.getOrDefault(out, 0)) --count;// 更新 count
                    // 出窗口
                    hash2.put(out, hash2.get(out) - 1);
                    left += n;
                }
                if (count == m) ret.add(left);
            }
        }
        return ret;
    }
}
