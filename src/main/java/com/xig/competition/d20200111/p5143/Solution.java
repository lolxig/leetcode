package com.xig.competition.d20200111.p5143;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2020-01-11 22:36
 * Author: xig
 * Description:
 *
 * 5143. 解压缩编码列表
 *
 * 给你一个以行程长度编码压缩的整数列表 nums 。
 *
 * 考虑每相邻两个元素 [a, b] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后有 a 个值为 b 的元素。
 *
 * 请你返回解压后的列表。
 *
 *
 *
 * 示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[2,4,4,4]
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 100
 * nums.length % 2 == 0
 * 1 <= nums[i] <= 100
 *
 */
public class Solution {

    public static void main(String[] args) {

        int[] input = {1,2,3,4};
        int[] res = new Solution().decompressRLElist(input);
        System.out.println();
    }

    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] res;
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                list.add(nums[i + 1]);
            }
        }
        res = new int[list.size()];
        int top = 0;
        for (Integer elem : list) {
            res[top++] = elem;
        }
        return res;
    }

}
