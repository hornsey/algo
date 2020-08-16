package com.hornsey.algo.leetcode;

/**
 * @author huangtao
 * @date 2020/8/16
 */
public class Q26Solution {
	public int removeDuplicates(int[] nums) {
		int n = nums.length;
		if (n < 2) {
			return n;
		}
		int pos = 0;
		for (int i = 1; i < n; i++) {
			if (nums[i] != nums[pos]) {
				nums[++pos] = nums[i];
			}
		}
		return pos;
	}
}
