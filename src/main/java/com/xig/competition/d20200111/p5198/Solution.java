package com.xig.competition.d20200111.p5198;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 请你帮忙设计一个程序，用来找出第 n 个丑数。
 *
 * 丑数是可以被 a 或 b 或 c 整除的正整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3, a = 2, b = 3, c = 5
 * 输出：4
 * 解释：The ugly numbers are 2, 3, 4, 5, 6, 8, 9, 10... The 3rd is 4.
 *
 *
 * 示例 2：
 *
 * 输入：n = 4, a = 2, b = 3, c = 4
 * 输出：6
 * 解释：丑数序列为 2, 3, 4, 6, 8, 9, 12... 其中第 4 个是 6。
 *
 *
 * 示例 3：
 *
 * 输入：n = 5, a = 2, b = 11, c = 13
 * 输出：10
 * 解释：丑数序列为 2, 4, 6, 8, 10, 11, 12, 13... 其中第 5 个是 10。
 *
 *
 * 示例 4：
 *
 * 输入：n = 1000000000, a = 2, b = 217983653, c = 336916467
 * 输出：1999999984
 *
 *
 * 提示：
 *
 * 1 <= n, a, b, c <= 10^9
 * 1 <= a * b * c <= 10^18
 * 本题结果在 [1, 2 * 10^9] 的范围内
 */
public class Solution {

    public static void main(String[] args) {

        int n = 1_000_000_000, a = 2, b = 217_983_653, c = 336_916_467;

        int ugly = new Solution().nthUglyNumber(n, a, b, c);

        System.out.println(ugly);
    }

    public int nthUglyNumber(int n, int a, int b, int c) {

        int res = 0;
        List<Integer> list = new ArrayList<>();

        list.add(a);
        list.add(b);
        list.add(c);

        if (a > b || b > c) {
            Collections.sort(list);
            a = list.get(0);
            b = list.get(1);
            c = list.get(2);    // 三个数排序取
        }

        int[] index = new int[]{1, 1, 1};
        int[] nums = new int[]{a, b, c};

        for (int count = 0; count < n; ++count) {

            int min = min(nums);
            int minIndex = minIndex(min, nums);

            res = min;
            index[minIndex]++;
            nums[minIndex] = list.get(minIndex) * index[minIndex];

            for (int i = 0; i < index.length; ++i) {
                if (nums[i] == min) {
                    index[i]++;
                    nums[i] = list.get(i) * index[i];
                }
            }
        }
        return res;
    }

    private int min(int[] nums) {
        return Math.min(Math.min(nums[0], nums[1]), nums[2]);
    }

    private int minIndex(int min, int[] nums) {
        for (int index = 0; index < nums.length; ++index) {
            if (nums[index] == min) {
                return index;
            }
        }
        return 0;
    }

}
