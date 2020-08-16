package com.hornsey.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * @author huangtao
 * @date 2020/8/16
 * @version 2
 */
public class Q84Solution {
	public int largestRectangleArea(int[] heights) {
		int n = heights.length;
		int area = 0;

		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
				int h = heights[stack.pop()];
				int l = stack.isEmpty() ? -1 : stack.peek();
				area = Math.max(area, h*(i - l -1));
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			int h = heights[stack.pop()];
			int l = stack.isEmpty() ? -1 : stack.peek();
			area = Math.max(area, h*(n - l -1));
		}
		return area;
	}
}
