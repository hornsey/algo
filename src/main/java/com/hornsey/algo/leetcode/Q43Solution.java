package com.hornsey.algo.leetcode;

/**
 * 优化竖版
 *
 * @author huangtao
 * @date 2020/8/13
 * @version 2
 */
public class Q43Solution {
	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}

		int len1 = num1.length(), len2 = num2.length();
		int[] res = new int[len1+len2];
		for (int i = len1-1; i >= 0; i--) {
			int n1 = num1.charAt(i) - '0';
			for (int j = len2-1; j>=0; j--) {
				int n2 = num2.charAt(j) - '0';
				int sum = res[i+j+1] + n1*n2;
				res[i+j+1] = sum % 10;
				res[i+j] += sum/10;
			}
		}

		StringBuilder temp = new StringBuilder();
		for (int i = 0; i < res.length; i++) {
			if (i == 0 && res[i] == 0) {
				continue;
			}
			temp.append(res[i]);
		}
		return temp.toString();
	}

}
