package com.hornsey.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangtao
 * @date 2020/8/15
 */
public class Q299Solution {
	public String getHint(String secret, String guess) {

		int len = secret.length();
		int bulls = 0, cows = 0;
		int[] numbers = new int[10];
		for (int i = 0; i < len; i++) {

			if (secret.charAt(i) == guess.charAt(i)) {
				bulls++;
			} else {
				int s = secret.charAt(i) - '0';
				int g = guess.charAt(i) - '0';
				if (numbers[s] < 0) {
					cows++;
				}
				if (numbers[g] > 0) {
					cows++;
				}
				numbers[s]++;
				numbers[g]--;
			}
		}

		return String.format("%dA%dB", bulls, cows);
	}
}
