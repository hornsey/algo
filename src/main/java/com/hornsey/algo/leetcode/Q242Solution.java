package com.hornsey.algo.leetcode;

import java.util.Arrays;

/**
 * @author huangtao
 * @date 2020/8/17
 */
public class Q242Solution {
	public boolean isAnagram(String s, String t) {
		int n1 = s.length(), n2 = t.length();
		if (n1 != n2) {
			return false;
		}
		int[] chars = new int[26];
		Arrays.fill(chars, 0);

		for (int i = 0; i < n1; i++) {
			chars[s.charAt(i)-'a']++;
			chars[t.charAt(i)-'a']--;
		}
		for (int c: chars) {
			if (c != 0) {
				return false;
			}
		}

		return true;
	}
}
