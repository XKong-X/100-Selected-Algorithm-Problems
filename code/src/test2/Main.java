package test2;

/**
 * Created with IntelliJ IDEA.
 * Description: 1089. 复写零(https://leetcode.cn/problems/duplicate-zeros/description/)
 * Author: 行空XKong
 * Date: 2024-09-24
 * Time: 13:42
 * Version:
 */
class Solution {
    public void duplicateZeros(int[] arr) {
        int i = 0, j = -1, n = arr.length;// j 落后 i 一个位置防止循环提前结束
        // j 不越界
        while (j < n) {
            if (arr[i] != 0) {
                ++j;
            } else {
                j += 2;
            }
            if (j >= n - 1) {// j 走到数组最后或者越界则跳出
                break;
            }
            ++i;
        }
        if (j == n) {// 处理越界的情况
            arr[n - 1] = 0;
            --i;
            j -= 2;
        }
        while (j >= 0) {
            if (arr[i] == 0) {
                arr[j--] = 0;
                arr[j--] = 0;
                --i;
            } else {
                arr[j--] = arr[i--];
            }
        }
        System.out.println(arr);
    }
}
