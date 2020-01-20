package com.xig.convention.c6.p67;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
class Solution {

	public String addBinary(String a, String b) {

		int i=a.length() -1;
		int j=b.length() -1;

		int carry = 0;// 进位

		StringBuilder sb = new StringBuilder();

		while(i > -1 || j > -1) {

			int abit = i > -1 ? a.charAt(i) - '0' : 0;
			int bbit = j > -1 ? b.charAt(j) - '0' : 0;

			int sum = abit + bbit + carry;// 00, 01, 10, 11

			sb.insert(0, sum & 1);
			carry = (sum >>> 1) & 1;

			i--;
			j--;
		}
		if(carry == 1)
			sb.insert(0, 1);
		return sb.toString();
	}

}
