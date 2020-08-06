package com.hornsey.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangtao
 * @date 2020/8/6
 */
public class Q336Solution {
	List<List<Integer>> result = new ArrayList<>();
	public List<List<Integer>> palindromePairs(String[] words) {
		if (words == null || words.length == 0) {
			return result;
		}

		int n = words.length;
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				if (words[i].length() == 0 || words[j].length() == 0){
					checkWord(words, i, j);
					checkWord(words, j, i);
					continue;
				}
				if (words[i].charAt(0) == words[j].charAt(words[j].length()-1)) {
					checkWord(words, i, j);
				}
				if (words[j].charAt(0) == words[i].charAt(words[i].length()-1)) {
					checkWord(words, j, i);
				}
			}
		}

		return result;
	}

	private void checkWord(String[] words, int i, int j) {
		String src = words[i] + words[j];
		String dest = new StringBuilder(src).reverse().toString();
		if (src.equals(dest)) {
			List<Integer> tmp = new ArrayList<>();
			tmp.add(i);
			tmp.add(j);
			result.add(tmp);
		}
	}

	public static void main(String[] args) {
		String[] words = new String[]{"abcd", "dcba"};
		Q336Solution solution = new Q336Solution();
		solution.palindromePairs(words);
		System.out.println(solution.result);
	}
}
