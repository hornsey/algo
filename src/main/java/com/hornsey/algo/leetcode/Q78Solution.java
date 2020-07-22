package com.hornsey.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangtao
 * @date 2020/7/20
 * @version 4
 */
public class Q78Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		int n = nums.length;

		for (int i = (int)Math.pow(2, n); i < Math.pow(2, n+1); i++) {
			String bitmask = Integer.toBinaryString(i).substring(1);
			System.out.println(bitmask);

			List<Integer> cur = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				if (bitmask.charAt(j) == '1') {
					cur.add(nums[j]);
				}
			}
			res.add(cur);
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,4,5,6};
		Q78Solution solution = new Q78Solution();
		List<List<Integer>> subsets = solution.subsets(nums);
		for (List<Integer> subset : subsets) {
			System.out.println(subset);
		}
	}
}
