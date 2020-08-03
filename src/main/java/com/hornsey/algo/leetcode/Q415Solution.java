package com.hornsey.algo.leetcode;

/**
 * @author huangtao
 * @date 2020/8/3
 */
public class Q415Solution {
	public String addStrings(String num1, String num2) {

		int len1 = num1.length(), len2 = num2.length();

		int sum = 0;
		StringBuilder sb = new StringBuilder();
		int add = 0;
		for (int i = 1; i <= len1 || i <= len2 || add > 0; i++) {
			int n1 = len1 >= i ? num1.charAt(len1-i) - '0' : 0;
			int n2 = len2 >= i ? num2.charAt(len2-i) - '0' : 0;
			sum = (add + n1 + n2) % 10;
			add = (add + n1 + n2) / 10;
			sb.append((char)('0' + sum));
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		Q415Solution solution = new Q415Solution();
		System.out.println(solution.addStrings("18582506933032752", "366213329703"));
	}
}
