package com.hornsey.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangtao
 * @date 2020/7/20
 * @version 3
 */
public class Q78Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();

		backtrace(nums, 0, new ArrayList<>(), res);

		return res;
	}

	private void backtrace(int[] nums, int start,  List<Integer> cur, List<List<Integer>> res) {
		res.add(new ArrayList<>(cur));

		for (int i = start; i < nums.length; i++) {
			cur.add(nums[i]);
			backtrace(nums, i+1, cur, res);
			cur.remove(cur.size()-1);
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3};
		Q78Solution solution = new Q78Solution();
		List<List<Integer>> subsets = solution.subsets(nums);
		for (List<Integer> subset : subsets) {
			System.out.println(subset);
		}
	}
}
