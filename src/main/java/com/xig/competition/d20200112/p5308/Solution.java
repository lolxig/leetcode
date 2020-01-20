package com.xig.competition.d20200112.p5308;

/**
 * Created with IntelliJ IDEA.
 * Date: 2020-01-12 11:19
 * Author: xig
 * Description:
 * <p>
 * 5308. 或运算的最小翻转次数
 * <p>
 * 给你三个正整数 a、b 和 c。
 * <p>
 * 你可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算   a OR b == c  成立的最小翻转次数。
 * <p>
 * 「位翻转操作」是指将一个数的二进制表示任何单个位上的 1 变成 0 或者 0 变成 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = 2, b = 6, c = 5
 * 输出：3
 * 解释：翻转后 a = 1 , b = 4 , c = 5 使得 a OR b == c
 * <p>
 * 示例 2：
 * 输入：a = 4, b = 2, c = 7
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：a = 1, b = 2, c = 3
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= a <= 10^9
 * 1 <= b <= 10^9
 * 1 <= c <= 10^9
 */
public class Solution {

    public static void main(String[] args) {

        int a = 1;
        int b = 2;
        int c = 3;

        System.out.println(new Solution().minFlips(a, b, c));


    }

    public int minFlips(int a, int b, int c) {
        int tmp = a | b;
        int result = tmp ^ c;
        int count = 0;
        int index = 0;

        while (result != 0) {
            if ((result & 1) != 0) {
                if (test(tmp, index) == 0) {
                    ++count;
                } else {
                    if (test(a, index) == 1 && test(b, index) == 1) {
                        count += 2;
                    } else {
                        ++count;
                    }
                }
            }
            result /= 2;
            ++index;
        }
        return count;
    }

    private int changeBit(int num, int index) {
        if (test(num, index) == 0) {
            return zero2One(num, index);
        } else {
            return one2zero(num, index);
        }
    }

    private int zero2One(int num, int index) {
        return num | (1 << index);
    }

    private int one2zero(int num, int index) {
        return num & ~(1 << index);
    }

    private int test(int num, int index) {
        return (num & (0x1 << index)) >> index;
    }


}
