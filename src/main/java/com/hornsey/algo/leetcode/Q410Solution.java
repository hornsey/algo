package com.hornsey.algo.leetcode;

/**
 * @author huangtao
 * @date 2020/7/25
 */
public class Q410Solution {
	public int splitArray(int[] nums, int m) {
		long l = nums[0], h = 0;

		for (int num : nums) {
			h += num;
			l = num > l ? num : l;
		}

		while (l < h) {
			long mid = l + (h-l)/2;
			long tmp = 0;
			int count = 1;

			for (int num : nums) {
				tmp += num;
				if (tmp > mid) {
					tmp = num;
					count++;
				}
			}

			if (count > m) {
				l = mid + 1;
			} else {
				h = mid;
			}
		}
		return (int)l;

	}
}
