package com.xig.competition.d20200111.p5168;


/**
 * 我们来定义一个函数 f(s)，其中传入参数 s 是一个非空字符串；该函数的功能是统计 s  中（按字典序比较）最小字母的出现频次。
 *
 * 例如，若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。
 *
 * 现在，给你两个字符串数组待查表 queries 和词汇表 words，请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是满足 f(queries[i]) < f(W) 的词的数目，W 是词汇表 words 中的词。
 *
 *
 *
 * 示例 1：
 *
 * 输入：queries = ["cbd"], words = ["zaaaz"]
 * 输出：[1]
 * 解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
 * 示例 2：
 *
 * 输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * 输出：[1,2]
 * 解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
 *
 *
 * 提示：
 *
 * 1 <= queries.length <= 2000
 * 1 <= words.length <= 2000
 * 1 <= queries[i].length, words[i].length <= 10
 * queries[i][j], words[i][j] 都是小写英文字母
 *
 * */
public class Solution {

	public static void main(String[] args) {

		String[] queries = new String[]{"bbb","cc"};
		String[] words = new String[]{"a","aa","aaa","aaaa"};

		int[] res = new Solution().numSmallerByFrequency(queries, words);

		System.out.print("[");
		for (int i = 0; i < res.length; ++i) {
			System.out.print(res[i] + ",");
		}
		System.out.println("]");
	}


	public int[] numSmallerByFrequency(String[] queries, String[] words) {
		int[] result = new int[queries.length];

		int[] f1 = f(queries);
		int[] f2 = f(words);

		for (int i = 0, count = 0; i < f1.length; ++i) {
			int tmp = f1[i];
			for (int j = 0; j < f2.length; ++j) {
				if (tmp < f2[j]) {
					count++;
				}
			}
			result[i] = count;
			count = 0;
		}

		return result;
	}

	private static int[] f(String[] data) {
		int[] res = new int[data.length];

		for (int i = 0, count = 0; i < data.length; ++i) {
			int min = 'z' + 1;
			String str = data[i];
			for (int j = 0; j < str.length(); ++j) {
				if (str.charAt(j) < min) {
					min = str.charAt(j);
					count = 1;
				} else if (str.charAt(j) == min) {
					count++;
				}
			}
			res[i] = count;
		}
		return res;
	}

}
