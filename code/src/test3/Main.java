package test3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description: 202. 快乐数(https://leetcode.cn/problems/happy-number/description/)
 * Author: 行空XKong
 * Date: 2024-09-24
 * Time: 13:44
 * Version:
 */
class Solution {
    private static int func(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        // // 方法一（哈希）
        // int num = n;
        // Set<Integer> set = new HashSet<>();
        // while (!set.contains(num)) {
        //     set.add(num);
        //     num = func(num);
        // }
        // if (num == 1) {
        //     return true;
        // }
        // return false;

        // 方法二（快慢指针）
        int slow = n, fast = func(n);
        while (slow != fast) {
            slow = func(slow);
            fast = func(func(fast));
        }
        if (slow == 1) {// slow == fast
            return true;
        }
        return false;
    }
}
