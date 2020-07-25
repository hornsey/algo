package com.hornsey.algo.leetcode;

/**
 * @author huangtao
 * @date 2020/7/25
 * @version 1
 */
public class Q287Solution {
	public int findDuplicate(int[] nums) {

		int l = 1, h = nums.length-1;
		while (l < h) {
			int m = l + (h-l)/2;
			int count = 0;
			for (int num : nums) {
				if (num <= m) {
					count++;
				}
			}
			if (count > m) {
				h = m;
			} else {
				l = m + 1;
			}
		}
		return l;
	}

	public static void main(String[] args) {
		Q287Solution solution = new Q287Solution();
		System.out.println(solution.findDuplicate(new int[]{1,3,4,3,2}));
	}
}
