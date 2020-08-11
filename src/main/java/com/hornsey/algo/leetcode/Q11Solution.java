package com.hornsey.algo.leetcode;

/**
 *
 */
class Q11Solution {
	public int maxArea(int[] height) {
		int i = 0, j = height.length-1, res = 0;
		while (i < j) {
			int area = Math.min(height[i], height[j])*(j-i);
			res = Math.max(res, area);
			if (height[i] < height[j]) {
				i++;
			} else {
				j--;
			}
		}
		return res;
	}
}