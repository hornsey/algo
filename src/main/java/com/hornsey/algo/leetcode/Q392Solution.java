package com.hornsey.algo.leetcode;

/**
 * @author huangtao
 * @date 2020/7/27
 */
public class Q392Solution {
	public boolean isSubsequence(String s, String t) {

		int i = 0, j = 0;
		for (; i < s.length() && j < t.length(); j++) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
			}
		}
		return i == s.length();

	}
}
