package com.xig.competition.d20200111.p5197;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给你个整数数组 arr，其中每个元素都 不相同。
 *
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 * 示例 2：
 *
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 * 示例 3：
 *
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 *
 *
 * 提示：
 *
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 * */
public class Solution {

    public static void main(String[] args) {

        int arr[] = new int[]{3,8,-10,23,19,-4,-14,27};

        List<List<Integer>> res = new Solution().minimumAbsDifference(arr);
        System.out.println();

    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        if (arr == null || arr.length == 0) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        for (int num : arr) {
            list.add(num);
        }

        Collections.sort(list);

        int minDifference = Integer.MAX_VALUE;

        for (int i = 0, j = 1; j < list.size(); ++i, ++j) {

            int firstNum = list.get(i);
            int secondNum = list.get(j);

            if (Math.abs(firstNum - secondNum) < minDifference) {
                minDifference = Math.abs(firstNum - secondNum);
                res.clear();
                List<Integer> tmp = new ArrayList<>();
                tmp.add(firstNum);
                tmp.add(secondNum);
                res.add(tmp);
            } else if (Math.abs(firstNum - secondNum) == minDifference){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(firstNum);
                tmp.add(secondNum);
                res.add(tmp);
            }
        }
        return res;
    }

}


