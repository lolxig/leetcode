package com.xig.convention.c5.p1108;

/**
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 *
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 *
 * 示例 1：
 *
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 * 示例 2：
 *
 * 输入：address = "255.100.50.0"
 * 输出："255[.]100[.]50[.]0"
 *  
 *
 * 提示：
 *
 * 给出的 address 是一个有效的 IPv4 地址
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/defanging-an-ip-address
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * */
public class Solution {

	public String defangIPaddr(String address) {
		String result = "";
		int prec = 0;
		for (int i = 0; i < address.length(); ++i) {
			if (address.charAt(i + 1) != '.') {
				result += address.charAt(i);
			} else {
				result += address.charAt(i) + "[.]";
				if (++prec == 3) {
					for (int j = i + 2; j < address.length(); ++j) {
						result += address.charAt(j);
					}
					break;
				}
				i++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String s = "255.100.50.0";
		System.out.println(new Solution().defangIPaddr(s));
	}
}
