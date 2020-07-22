package com.hornsey.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangtao
 * @date 2020/7/20
 */
public class Q78Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<>());

		for (Integer num : nums) {
			List<List<Integer>> curRes = new ArrayList<>(res);
			for (List<Integer> list : curRes) {
				res.add(new ArrayList<Integer>(list){{add(num);}});
			}
		}

		return res;
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
