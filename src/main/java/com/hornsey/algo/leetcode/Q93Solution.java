package com.hornsey.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangtao
 * @date 2020/8/9
 */
public class Q93Solution {
	List<String> res;
	public List<String> restoreIpAddresses(String s) {
		res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		backtrace(s,  0, list);

		return res;
	}

	private void backtrace(String s, int curStart, List<Integer> list) {
		if (list.size() == 4) {
			if (curStart == s.length()) {
				res.add(composeIp(list));
			}
			return;
		}

		for (int i = curStart+1; i <= s.length() && i <= curStart+3; i++) {
			if (s.charAt(curStart) == '0' && i > curStart+1) {
				return;
			}

			Integer num = Integer.parseInt(s.substring(curStart, i));
			if (num > 255) {
				return;
			}
			list.add(num);
			backtrace(s, i, list);
			list.remove(list.size()-1);
		}
	}

	private String composeIp(List<Integer> tmp) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			sb.append(tmp.get(i));
			if (i != 3) {
				sb.append(".");
			}
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

	public static void main(String[] args) {
		Q93Solution solution = new Q93Solution();
		List<String> list = solution.restoreIpAddresses("0000");
		System.out.println(list);
	}

}
