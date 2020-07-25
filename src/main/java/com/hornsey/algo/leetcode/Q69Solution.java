package com.hornsey.algo.leetcode;

/**
 * @author huangtao
 * @date 2020/7/25
 */
public class Q69Solution {
	public int mySqrt(int x) {

		int l = 1, h = x/2+1;
		while (l < h) {
			int m = l + (h-l)/2;
			if (m*m > x) {
				h = m;
			} else {
				l = m + 1;
			}
		}

		return l-1;

	}

	public static void main(String[] args) {
		Q69Solution solution = new Q69Solution();
		System.out.println(solution.mySqrt(4));
	}
}
