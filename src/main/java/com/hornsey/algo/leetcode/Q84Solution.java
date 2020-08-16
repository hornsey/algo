package com.hornsey.algo.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author huangtao
 * @date 2020/8/16
 * @version 2
 */
public class Q84Solution {
	public int largestRectangleArea(int[] heights) {
		int area = 0;
		int n = heights.length;
		int[] l = new int[n];
		int[] r = new int[n];
		Arrays.fill(r, n);

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
				r[stack.pop()] = i;
			}
			l[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(i);
		}

		for (int i = 0; i < n; i++) {
			area = Math.max(area, (r[i]- l[i] - 1)*heights[i]);
		}
		return area;
	}
}
