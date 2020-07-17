package com.hornsey.algo.leetcode;

/**
 * @author huangtao
 * @date 2020/7/16
 */
public class Q200Solution {
	public int numIslands(char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int count = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					count++;
					grid[i][j] = 0;

					// 遍历周围的节点
					setZero(grid, i, j+1, m, n);
					setZero(grid, i+1, j, m, n);
				}
			}
		}

		return count;

	}

	private void setZero(char[][] grid, int i, int j, int m, int n) {
		if (i >= m || j >= n) {
			return;
		}
		if (grid[i][j] == 1) {
			grid[i][j] =0;
			setZero(grid, i, j+1, m, n);
			setZero(grid, i+1, j, m, n);
		}
	}

	public static void main(String[] args) {

//		char[][] grid = [["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]];
	}
}
