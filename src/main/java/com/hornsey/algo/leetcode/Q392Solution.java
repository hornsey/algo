package com.hornsey.algo.leetcode;

/**
 * @author huangtao
 * @date 2020/7/27
 * @version 2 动态规划
 */
public class Q392Solution {
	public boolean isSubsequence(String s, String t) {

		int n = s.length(), m = t.length();
		int[][] f = new int[m+1][26];
		for (int i = 0; i < 26; i++) {
			f[m][i] = m;
		}

		for (int i = m-1; i >= 0 ; i--) {
			for (int j = 0; j < 26; j++) {
				if (t.charAt(i) == i + 'a') {
					f[i][j] = i;
				} else {
					f[i][j] = f[i+1][j];
				}
			}
		}

		int index = 0;
		for (int i = 0; i < n; i++) {
			if (f[index][s.charAt(i) - 'a'] == m) {
				return false;
			}
			index = f[index][s.charAt(i) - 'a'] + 1;
		}

		return true;

	}
}
