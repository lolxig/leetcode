package com.xig.convention.c1.p169;


/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 **/
public class Solution {

    public static void main(String[] args) {

        int[] nums = {2,2,1,1,1,2,2};
        int in = new Solution().majorityElement(nums);

        System.out.println(in);

    }

    /************投票算法***********/
    public int majorityElement(int[] nums) {
        int max = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; ++i)
            if (count == 0) {
                max = nums[i];
                count = 1;
            } else if (nums[i] == max)
                count++;
             else
                count--;
        return max;
    }


    /******自己想的垃圾算法*******/
//    public int majorityElement(int[] nums) {
//
//        int max = nums[0];  // 记录最大节点
//        int maxCount = 1;
//        Map<Integer, Integer> map = new HashMap<>();    // 记录索引和计数
//
//        for (int value : nums) {
//            if (map.get(value) == null) {
//                map.put(value, 1);
//            } else {
//                int count = map.get(value) + 1;
//                map.put(value, count);
//                if (count > maxCount) {
//                    max = value;
//                    maxCount = count;
//                }
//            }
//        }
//        return max;
//    }

}
