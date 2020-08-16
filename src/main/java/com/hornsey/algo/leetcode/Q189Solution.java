package com.hornsey.algo.leetcode;

/**
 * @author huangtao
 * @date 2020/8/16
 */
public class Q189Solution {
	public void rotate(int[] nums, int k) {
		int n = nums.length;
		for (int i = 0; i < k; i++) {
			int prev = nums[n-1];
			for (int j = n-1; j > 0; j--) {
				nums[j] = nums[j-1];
			}
			nums[0] = prev;
		}
	}
}
