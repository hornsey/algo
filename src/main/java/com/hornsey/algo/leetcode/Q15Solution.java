package com.hornsey.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangtao
 * @date 2020/8/11
 */
public class Q15Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		if (nums == null || nums.length <= 2) {
			return new ArrayList<>();
		}
		Arrays.sort(nums);
		int len = nums.length;
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < len-2; i++) {
			int l = i+1, r = len-1;
			if (nums[i] > 0) {
				break;
			}
			if (i > 0 && nums[i] == nums[i-1]) {
				continue;
			}
			while (l < r) {
				int sum = nums[i] + nums[l] + nums[r];
				if (sum < 0) {
					while (l < r && nums[l] == nums[++l]){}
				} else if (sum > 0) {
					while (l < r && nums[r] == nums[--r]){}
				} else {
					res.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
					while (l < r && nums[l] == nums[++l]){}
					while (l < r && nums[r] == nums[--r]){}
				}
			}
		}
		return res;
	}
}
