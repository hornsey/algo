package com.hornsey.algo.leetcode;

/**
 * @author huangtao
 * @date 2020/8/16
 * @version 3
 */
public class Q189Solution {
	public void rotate(int[] nums, int k) {
		int n = nums.length;
		k %= n;

		int count = 0;
		for (int i = 0; i < k && count < n; i++) {
			int curr = i;
			int prev = nums[i];
			do {
				int next = (curr + k) % n;
				int temp = nums[next];
				nums[next] = prev;
				prev = temp;
				curr = next;
				count++;
			} while (i != curr);
		}
	}
}
