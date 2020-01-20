package com.xig.convention.c8.p8.p88;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Solution {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;

        new Solution().merge(nums1, m, nums2, n);

        System.out.println();
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int ptr1 = 0;
        int ptr2 = 0;

        int[] res = new int[m + n];
        int index = 0;

        while (ptr1 < m && (ptr2 < n)) {
            if (nums1[ptr1] < nums2[ptr2]) {
                res[index++] = nums1[ptr1++];
            } else {
                res[index++] = nums2[ptr2++];
            }
        }

        while (ptr1 < m) {
            res[index++] = nums1[ptr1++];
        }
        while (ptr2 < n) {
            res[index++] = nums2[ptr2++];
        }

        System.arraycopy(res, 0, nums1, 0, m + n);
    }

}
