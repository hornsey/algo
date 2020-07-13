package com.hornsey.algo.leetcode;

import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author huangtao
 * @date 2020/7/13
 */
public class Q350Solution {
	public int[] intersect(int[] nums1, int[] nums2) {

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int length1 = nums1.length;
		int length2 = nums2.length;

		int[] res = new int[Math.min(length1, length2)];

		int index = 0, index1 = 0, index2 = 0;
		while (index1 < length1 && index2 < length2) {
			if (nums1[index1] == nums2[index2]) {
				res[index++] = nums1[index1];
				index1++;
				index2++;
			} else if (nums1[index1] < nums2[index2]) {
				index1++;
			} else {
				index2++;
			}
		}

		return Arrays.copyOfRange(res, 0, res.length);

	}

	public static void main(String[] args) {
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};

		int[] intersect = new Q350Solution().intersect(nums1, nums2);
		System.out.println(Arrays.toString(intersect));


	}
}
