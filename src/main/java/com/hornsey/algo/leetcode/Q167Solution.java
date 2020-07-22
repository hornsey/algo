package com.hornsey.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangtao
 * @date 2020/7/20
 */
public class Q167Solution {
	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length == 0) {
			return new int[2];
		}
		int n = numbers.length;
		int h = 0;
		int t = n-1;
		while (h < t) {
			if (numbers[h] + numbers[t] == target) {
				return new int[]{h+1, t+1};
			} else if (numbers[h] + numbers[t] > target){
				t--;
			} else {
				h--;
			}
		}
		return new int[2];
	}
}
