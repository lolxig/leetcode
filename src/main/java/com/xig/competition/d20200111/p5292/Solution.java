package com.xig.competition.d20200111.p5292;

import java.util.*;

/**
 * 给你一个整数数组 nums 和一个正整数 k，请你判断是否可以把这个数组划分成一些由 k 个连续数字组成的集合。
 * 如果可以，请返回 True；否则，返回 False。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,3,4,4,5,6], k = 4
 * 输出：true
 * 解释：数组可以分成 [1,2,3,4] 和 [3,4,5,6]。
 * <p>
 * 示例 2：
 * 输入：nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
 * 输出：true
 * 解释：数组可以分成 [1,2,3] , [2,3,4] , [3,4,5] 和 [9,10,11]。
 * <p>
 * 示例 3：
 * 输入：nums = [3,3,2,2,1,1], k = 3
 * 输出：true
 * <p>
 * 示例 4：
 * 输入：nums = [1,2,3,4], k = 3
 * 输出：false
 * 解释：数组不能分成几个大小为 3 的子数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 1 <= k <= nums.length
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {3,2,1,2,3,4,3,4,5,9,10,11};
        new Solution().isPossibleDivide(nums, 1);
    }

    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        List<List<Integer>> lists = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            lists.add(Arrays.asList(entry.getKey(), entry.getValue()));
        }

        int preIndex = 0;
        int currentIndex = 0;

        while (preIndex < lists.size()) {

            for (int i = 0; i < k - 1; ++i) {
                int preNum = lists.get(preIndex + i).get(0);




            }



        }

        return true;
    }

}
