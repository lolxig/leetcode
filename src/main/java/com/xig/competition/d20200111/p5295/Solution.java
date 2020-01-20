package com.xig.competition.d20200111.p5295;

import java.util.Arrays;

/**
 * 5295. 和为零的N个唯一整数
 *
 * 给你一个整数 n，请你返回 任意 一个由 n 个各不相同的 整数 组成的数组，并且这 n 个数相加和为 0 。
 *
 *
 *
 * 示例 1：
 * 输入：n = 5
 * 输出：[-7,-1,1,3,4]
 * 解释：这些数组也是正确的 [-5,-1,1,2,3]，[-3,-1,2,-2,4]。
 *
 * 示例 2：
 * 输入：n = 3
 * 输出：[-1,0,1]
 *
 * 示例 3：
 * 输入：n = 1
 * 输出：[0]
 *
 *
 * 提示：
 * 1 <= n <= 1000
 */
public class Solution {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new Solution().sumZero(5)));

    }

    public int[] sumZero(int n) {
        int[] result = new int[n];
        int index = 0;

        if (n % 2 != 0) {   //奇数
            result[index++] = 0;
            n -= 1;
        }
        int min = - n / 2;
        int max = n / 2;

        for (int num = min; num < 0; ++num) {
            result[index++] = num;
        }
        for (int num = 1; num <= max; ++num) {
            result[index++] = num;
        }
        return result;
    }


}
