package com.hornsey.algo.leetcode;

/**
 * @author huangtao
 * @date 2020/8/18
 */
public class Q1021Solution {
	public String removeOuterParentheses(String S) {
		int n = S.length();
		int left = 0, start = 0;
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if (S.charAt(i) == '(') {
				left++;
			} else {
				left--;
			}
			if (left == 0) {
				res.append(S, start+1, i);
				start = i + 1;
			}
		}
		return res.toString();
	}

	public static void main(String[] args) {
		Q1021Solution solution = new Q1021Solution();
		String s = solution.removeOuterParentheses("(()())(())(()(()))");
		System.out.println(s);
	}
}
