package com.hornsey.algo.leetcode;

/**
 * @author huangtao
 * @date 2020/7/30
 */
public class Q343Solution {
	public int integerBreak(int n) {
		if (n == 2) {
			return 1;
		} else if (n == 3) {
			return 2;
		}

		int a = n / 3;
		int b = n % 3;
		int res = 0;
		if (b == 1) {
			a -= 1;
			b = 4;
		} else if (b == 0) {
			b = 1;
		}
		res = (int)Math.pow(3,a) * b;
		return res;

	}
}
