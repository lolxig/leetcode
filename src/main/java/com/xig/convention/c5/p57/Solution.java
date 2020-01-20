package com.xig.convention.c5.p57;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 *
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Solution {

	/******  算法待改进  ******/
	public static void main(String[] args) {

		int[][] intervals = {{0, 5}, {9, 12}};
		int[] newInterval = {7, 16};
		int[][] res;

		res = new Solution().insert(intervals, newInterval);


		System.out.printf("");
	}

	public int[][] insert(int[][] intervals, int[] newInterval) {

		if (intervals == null || intervals.length == 0) {
			return new int[][] {newInterval};
		}

		int begin = newInterval[0];
		int end = newInterval[1];

		int[][] res;

		if (begin < intervals[0][0]) {  // 插入在头部

			// 新区间在最头
			if (end < intervals[0][0]) {
				res = new int[intervals.length + 1][2];
				res[0] = newInterval;
				System.arraycopy(intervals, 0, res, 1, intervals.length);
				return res;
			}

			int flag = -1;   // 尾部标志,0表示在某区间内部，1标志在某区间外部

			int pos = 0;
			while (pos < intervals.length) {

				if (pos == intervals.length - 1) {
					if (end <= intervals[pos][1]) {
						return new int[][]{{begin, intervals[pos][1]}};
					} else {
						return new int[][]{newInterval};
					}
				} else if (end >= intervals[pos][0] && (end <= intervals[pos][1])) {
					flag = 0;
					break;
				} else if (end > intervals[pos][1] && (end < intervals[pos + 1][0])) {
					flag = 1;
					break;
				}
				pos++;
			}

			res = new int[intervals.length - pos][2];
			res[0] = new int[]{begin, flag == 0? intervals[pos][1] : end};
			System.arraycopy(intervals, pos+ 1, res, 1, intervals.length - pos - 1);
			return res;

		} else if (begin >= intervals[intervals.length - 1][0]) {   // 插入在尾部

			if (begin <= intervals[intervals.length - 1][1]) {
				if (end > intervals[intervals.length - 1][1]) {
					intervals[intervals.length - 1][1] = end;
				}
				return intervals;
			} else {                                                // 插入在最尾部
				res = new int[intervals.length + 1][2];
				res[intervals.length] = newInterval;
				System.arraycopy(intervals, 0, res, 0, intervals.length);
				return res;
			}
		}

		// 找到插入位置
		int pos_begin = 0;
		int pos_end;
		int flag = -1;  // 尾部标志,0表示在某区间内部，1标志在某区间外部

		// 找到头部位置
		while (pos_begin < intervals.length - 1) {
			if (begin < intervals[pos_begin + 1][0]) {
				if (begin <= intervals[pos_begin][1]) {
					flag = 0;
					break;
				} else {
					flag = 1;
					break;
				}
			}
			pos_begin++;
		}
		pos_end = pos_begin;

		// 如果尾部在最尾部
		if (end >= intervals[intervals.length - 1][0]) {
			res = new int[pos_begin + 1 + flag][2];
			res[pos_begin + flag] = new int[]{flag == 0? intervals[pos_begin][0] : begin, Math.max(end, intervals[intervals.length - 1][1])};
			System.arraycopy(intervals, 0, res, 0, pos_begin + flag);
			return res;
		}

		// 找到尾部位置
		while (pos_end < intervals.length - 1) {
			if (end >= intervals[pos_end][0] && (end < intervals[pos_end + 1][0])) {
				break;
			}
			pos_end++;
		}

		if (flag == 0) {    // 区间在所找的位置里面

			// 不涉及新分配区间
			if (pos_begin == pos_end) {
				if (end > intervals[pos_begin][1]) {
					intervals[pos_begin][1] = end;
				}
				return intervals;

			} else {
				res = new int[intervals.length - (pos_end - pos_begin)][2];
				System.arraycopy(intervals, 0, res, 0, pos_begin);
				res[pos_begin] = new int[]{intervals[pos_begin][0], Math.max(intervals[pos_end][1], end)};
				System.arraycopy(intervals, pos_end + 1, res, pos_begin + 1, intervals.length - pos_end - 1);
				return res;
			}

		} else {

			// 不涉及合并区间
			if (pos_begin == pos_end) {
				res = new int[intervals.length + flag][2];
				System.arraycopy(intervals, 0, res, 0, pos_begin + flag);
				res[pos_begin + flag] = new int[]{begin, end};
				System.arraycopy(intervals, pos_end + 1, res, pos_end + 1 + flag, intervals.length - pos_begin - flag);
				return res;

			} else {

				// 不涉及重新分配空间
				if (pos_end == pos_begin + 1) {

					if (end > intervals[pos_end][1]) {
						intervals[pos_end][1] = end;
					}
					intervals[pos_end][0] = begin;
					return intervals;

				} else {
					res = new int[intervals.length - (pos_end - (pos_begin + flag))][2];
					System.arraycopy(intervals, 0, res, 0, pos_begin + flag);
					res[pos_begin + flag] = new int[]{begin, Math.max(end, intervals[pos_end][1])};
					System.arraycopy(intervals, pos_end + 1, res, pos_begin + flag + 1, intervals.length - pos_end - flag);
					return res;
				}
			}
		}
	}

}
