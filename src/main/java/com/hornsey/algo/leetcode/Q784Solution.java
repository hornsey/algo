package com.hornsey.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangtao
 * @date 2020/7/28
 */
public class Q784Solution {
	List<String> res;
	int n;
	int diff;
	public List<String> letterCasePermutation(String S) {
		res = new ArrayList<>();
		n = S.length();
		diff = 'A' - 'a';

		if (n == 0) {
			return res;
		}

		backtrace(S, 0,new StringBuilder());
		return res;
	}

	private void backtrace(String s, int start, StringBuilder sb) {

		if (start == n) {
			res.add(sb.toString());
			return;
		}

		char c = s.charAt(start);
		sb.append(c);
		backtrace(s, start+1, sb);
		sb.deleteCharAt(start);
		if (c >= 'a' && c <= 'z') {
			sb.append((char)(c + diff));
			backtrace(s, start+1, sb);
			sb.deleteCharAt(start);
		} else if (c >= 'A' && c <= 'Z') {
			sb.append((char)(c - diff));
			backtrace(s, start+1, sb);
			sb.deleteCharAt(start);
		}

	}
}
