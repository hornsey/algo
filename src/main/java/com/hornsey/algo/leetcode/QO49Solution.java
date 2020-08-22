package com.hornsey.algo.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author huangtao
 * @date 2020/8/22
 */
public class QO49Solution {
	public int nthUglyNumber(int n) {
		int[] dp = new int[n];
		int p1 = 0, p2 = 0, p3 = 0;
		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			int a = dp[p1]*2, b = dp[p2]*3, c = dp[p3]*5;
			dp[i] = Math.min(Math.min(a,b), c);
			if (dp[i] == a) {
				p1++;
			}
			if (dp[i] == b) {
				p2++;
			}
			if (dp[i] == c) {
				p3++;
			}
		}

		return dp[n-1];
	}
}
