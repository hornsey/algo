package com.hornsey.algo.leetcode;

/**
 * @author huangtao
 * @date 2020/7/25
 * @version 2
 */
public class Q287Solution {
	public int findDuplicate(int[] nums) {

		int fast = 0, slow = 0;

		do {
			fast = nums[nums[fast]];
			slow = nums[slow];
		} while (fast != slow);

		int finder = 0;
		while (slow != finder) {
			finder = nums[finder];
			slow = nums[slow];
		}
		return finder;
	}

	public static void main(String[] args) {
		Q287Solution solution = new Q287Solution();
		System.out.println(solution.findDuplicate(new int[]{1,2,4,3,2}));
	}
}
