package com.hornsey.algo.leetcode;

/**
 * @author huangtao
 * @date 2020/8/16
 * @version 1
 */
public class Q84Solution {
	public int largestRectangleArea(int[] heights) {
		int area = 0;
		int n = heights.length;

		for (int i = 0; i < n; i++) {
			int l = i, r = i;
			while (l - 1 >= 0 && heights[l-1] >= heights[i]) {
				l--;
			}
			while (r + 1 < n && heights[r+1] >= heights[i]) {
				r++;
			}
			area = Math.max(area, (r-l+1)*heights[i]);
		}
		return area;
	}
}
