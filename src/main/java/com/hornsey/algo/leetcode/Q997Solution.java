package com.hornsey.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangtao
 * @date 2020/7/26
 * @version 2
 */
public class Q997Solution {
	public int findJudge(int N, int[][] trust) {
		int[] inDegree = new int[N+1];
		int[] outDegree = new int[N+1];

		for (int[] ints : trust) {
			inDegree[ints[1]] += 1;
			outDegree[ints[0]] += 1;
		}

		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == N-1 && outDegree[i] == 0) {
				return i;
			}
		}

		return -1;

	}
}
