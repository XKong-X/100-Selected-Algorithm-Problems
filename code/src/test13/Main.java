package test13;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 904. 水果成篮(https://leetcode.cn/problems/fruit-into-baskets/description/)
 * Author: 行空XKong
 * Date: 2024-10-07
 * Time: 15:12
 * Version:
 */
class Solution {
    public int totalFruit(int[] fruits) {
        // Map<Integer, Integer> hash = new HashMap<>();
        // int left = 0, right = 0, n = fruits.length, count = 0;
        // while (right < n) {
        //     int in = fruits[right];
        //     hash.put(in, hash.getOrDefault(in, 0) + 1);// 进窗口
        //     while (hash.size() > 2) {
        //         int out = fruits[left++];
        //         hash.put(out, hash.get(out) - 1);// 出窗口
        //         if (hash.get(out) == 0) {
        //             hash.remove(out);
        //         }
        //     }
        //     count = Math.max(count, right++ - left + 1);// 更新 + 扩大窗口
        // }
        // return count;

        // 用数组模拟 HashMap(因为 0 <= fruits[i] < fruits.length)
        int left = 0, right = 0, n = fruits.length, count = 0, kinds = 0;
        int[] hash = new int[n + 1];
        while (right < n) {
            int in = fruits[right];
            if (hash[in] == 0) ++kinds;// 更新种类
            ++hash[in];// 进窗口
            while (kinds > 2) {
                int out = fruits[left++];
                --hash[out];// 出窗口
                if (hash[out] == 0) {
                    --kinds;
                }
            }
            count = Math.max(count, right++ - left + 1);// 更新 + 扩大窗口
        }
        return count;
    }
}
