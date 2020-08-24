package com.hornsey.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归实现
 *
 * @author huangtao
 * @date 2020/7/20
 *
 */
public class Q22Solution {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		helper(0,0,n,"", res);
		return res;
	}

	private void helper(int left, int right, int n, String s, List<String> res) {
		if (left == n && right == n) {
			res.add(s);
			return;
		}

		if (left < n) {
			helper(left+1, right, n, s+"(", res);
		}
		if (right < left) {
			helper(left, right+1, n,s+")", res);
		}
	}
}
