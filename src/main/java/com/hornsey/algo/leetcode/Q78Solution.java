package com.hornsey.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangtao
 * @date 2020/7/20
 */
public class Q78Solution {
	private List<List<Integer>> res;
	private List<Integer> path;
	public List<List<Integer>> subsets(int[] nums) {
		res = new ArrayList<>();
		path = new ArrayList<>();

		backtrace(nums, path,0);
		return res;
	}

	private void backtrace(int[] nums, List<Integer> path, int start) {
		res.add(new ArrayList<>(path));

		for (int i = start; i < nums.length; i++) {
			path.add(nums[i]);
			backtrace(nums, path, i+1);
			path.remove(path.size()-1);
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
