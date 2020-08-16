package com.hornsey.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author huangtao
 * @date 2020/8/16
 */
public class Q239Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		int[] res = new int[n - k + 1];

		Deque<Integer> deque = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			while (!deque.isEmpty() && deque.peek() <= i - k) {
				deque.poll();
			}
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.pollLast();
			}

			deque.offer(i);
			if (i >= k - 1) {
				res[i - k + 1] = nums[deque.getFirst()];
			}
		}

		return res;
	}
}
