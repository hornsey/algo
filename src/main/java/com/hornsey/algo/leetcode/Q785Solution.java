package com.hornsey.algo.leetcode;

import java.util.Arrays;

/**
 * @author huangtao
 * @date 2020/7/16
 */
public class Q785Solution {
	private static final int UNCOLORED = 0;
	private static final int RED = 1;
	private static final int GREEN = 2;
	private int[] color;
	private boolean valid;

	public boolean isBipartite(int[][] graph) {
		int n = graph.length;
		valid = true;
		color = new int[n];
		Arrays.fill(color, UNCOLORED);

		for (int i = 0; i < n; i++) {
			if (color[i] == UNCOLORED) {
				dfs(i, RED, graph);
			}
		}

		return valid;

	}

	private void dfs(int node, int c, int[][] graph) {
		color[node] = c;
		int cls = c == RED ? GREEN : RED;

		for (int neighbour : graph[node]) {
			if (color[neighbour] == UNCOLORED) {
				dfs(neighbour, cls, graph);
				if (!valid) {
					return;
				}
			} else if (color[neighbour] != cls){
				valid = false;
				return;
			}
		}
	}
}
