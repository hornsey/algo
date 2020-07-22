package com.hornsey.algo.leetcode;

/**
 * @author huangtao
 * @date 2020/7/20
 */
public class Q53Solution {
	public int maxSubArray(int[] nums) {
		int n = nums.length;

		int result = 0;
		int sub = 0;
		for (int i = 0; i < n; i++) {
			sub += nums[i];
			if (sub < 0) {
				sub = 0;
			} else if (sub > result) {
				result = sub;
			}
		}
		return result;
	}
}
