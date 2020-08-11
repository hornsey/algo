package com.hornsey.algo.leetcode;

/**
 * @author huangtao
 * @date 2020/8/11
 */
public class Q130Solution {
	int m, n;
	public void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}
		m = board.length;
		n = board[0].length;
		for (int i = 0; i < m; i++) {
			dfs(board, i, 0);
			dfs(board, i, n-1);
		}
		for (int i = 1; i < n-1; i++) {
			dfs(board, 0, i);
			dfs(board, m-1, i);
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == 'A') {
					board[i][j] = 'O';
				}
			}
		}
	}

	private void dfs(char[][] board, int x, int y) {
		if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O') {
			return;
		}
		board[x][y] = 'A';
		dfs(board, x - 1, y);
		dfs(board, x + 1, y);
		dfs(board, x, y - 1);
		dfs(board, x, y + 1);
	}
}
