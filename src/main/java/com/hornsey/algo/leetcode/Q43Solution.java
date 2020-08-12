package com.hornsey.algo.leetcode;

/**
 * @author huangtao
 * @date 2020/8/13
 */
public class Q43Solution {
	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}

		String res = "0";

		for (int i = num2.length()-1; i>=0; i--) {
			int carry = 0;
			StringBuilder temp = new StringBuilder();
			for (int j = 0; j < num2.length() - 1 - i; j++) {
				temp.append(0);
			}
			int n2 = num2.charAt(i) - '0';

			for (int j = num1.length()-1; j>=0||carry != 0; j--) {
				int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
				int product = n1*n2 + carry;
				temp.append(product % 10);
				carry = product / 10;
			}
			res = addStrings(res, temp.reverse().toString());
		}
		return res;
	}

	private String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		for (int i = num1.length()-1, j = num2.length()-1; i>=0||j>=0||carry!=0; i--,j--) {
			int x = i < 0 ? 0 : num1.charAt(i) - '0';
			int y = j < 0 ? 0 : num2.charAt(j) - '0';
			int sum = (x + y + carry);
			sb.append(sum%10);
			carry = sum / 10;
		}
		return sb.reverse().toString();
	}
}
