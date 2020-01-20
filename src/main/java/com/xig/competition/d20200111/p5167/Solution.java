package com.xig.competition.d20200111.p5167;

import java.util.*;


/**
 * 如果出现下述两种情况，交易 可能无效：
 *
 * 交易金额超过 ¥1000
 * 或者，它和另一个城市中同名的另一笔交易相隔不超过 60 分钟（包含 60 分钟整）
 * 每个交易字符串 transactions[i] 由一些用逗号分隔的值组成，这些值分别表示交易的名称，时间（以分钟计），金额以及城市。
 *
 * 给你一份交易清单 transactions，返回可能无效的交易列表。你可以按任何顺序返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
 * 输出：["alice,20,800,mtv","alice,50,100,beijing"]
 * 解释：第一笔交易是无效的，因为第二笔交易和它间隔不超过 60 分钟、名称相同且发生在不同的城市。同样，第二笔交易也是无效的。
 * 示例 2：
 *
 * 输入：transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
 * 输出：["alice,50,1200,mtv"]
 * 示例 3：
 *
 * 输入：transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
 * 输出：["bob,50,1200,mtv"]
 *
 *
 * 提示：
 *
 * transactions.length <= 1000
 * 每笔交易 transactions[i] 按 "{name},{time},{amount},{city}" 的格式进行记录
 * 每个交易名称 {name} 和城市 {city} 都由小写英文字母组成，长度在 1 到 10 之间
 * 每个交易时间 {time} 由一些数字组成，表示一个 0 到 1000 之间的整数
 * 每笔交易金额 {amount} 由一些数字组成，表示一个 0 到 2000 之间的整数
 *
 *
 * 错误：
 * ["bob,689,1910,barcelona","alex,696,122,bangkok","bob,832,1726,barcelona","bob,820,596,bangkok","chalicefy,217,669,barcelona","bob,175,221,amsterdam"]
 *
 *
 * */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		String[] s = new String[]{"alice,20,800,mtv","alice,50,100,beijing"};
		String[] s1 = new String[]{"alice,20,800,mtv","alice,50,1200,mtv"};
		String[] s2 = new String[]{"bob,689,1910,barcelona",
				"alex,696,122,bangkok",
				"bob,832,1726,barcelona",
				"bob,820,596,bangkok",
				"chalicefy,217,669,barcelona",
				"bob,175,221,amsterdam"};

		List<String> res = solution.invalidTransactions(s2);

		System.out.println(res);
	}

	private static final String NAME = "name";
	private static final String TIME = "time";
	private static final String AMOUNT = "amount";
	private static final String CITY = "city";
	private static final String FLAG = "flag";

	public List<String> invalidTransactions(String[] transactions) {

		List<String> result = new ArrayList<>();
		Map<String, List<Map<String, String>>> map = new HashMap<>();

		for (String transaction : transactions) {

			String[] fields = transaction.split(",");
			String[] flag = new String[fields.length + 1];
			for (int i = 0; i < fields.length; ++i) {
				flag[i] = fields[i];
			}
			flag[4] = "0";
			fields = flag;  // 加入标志位
			flag = null;
			String name = fields[0];

			Map<String, String> tmpMap = new HashMap<>();
			tmpMap.put(NAME, fields[0]);
			tmpMap.put(TIME, fields[1]);
			tmpMap.put(AMOUNT, fields[2]);
			tmpMap.put(CITY, fields[3]);
			tmpMap.put(FLAG, "0");

			if (Integer.parseInt(tmpMap.get(AMOUNT)) > 1000) {
				tmpMap.put(FLAG, "1");
				result.add(transaction);
			}

			if (map.get(name) == null) {
				List<Map<String, String>> tmp = new ArrayList<>();
				map.put(name, tmp);
			}

			for (Map<String, String> elem : map.get(name)) {
				if (!elem.get(CITY).equals(tmpMap.get(CITY)) &&
						Math.abs(Integer.parseInt(elem.get(TIME)) - Integer.parseInt(tmpMap.get(TIME))) <= 60) {
					if (elem.get(FLAG).equals("0")) {
						elem.put(FLAG, "1");
						result.add(map2res(elem));
					}
					if (tmpMap.get(FLAG).equals("0")) {
						tmpMap.put(FLAG, "1");
						result.add(transaction);
					}
				}
			}

			map.get(name).add(tmpMap);
		}
		return result;
	}

	public static String map2res(Map<String, String> data) {
		return data.get(NAME) + "," + data.get(TIME) + "," + data.get(AMOUNT) + "," + data.get(CITY);
	}

}
