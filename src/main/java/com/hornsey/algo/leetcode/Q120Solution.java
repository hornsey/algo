package com.hornsey.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明： 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 *
 * @Author hornsey
 * @create 2019/8/13 9:39
 */
public class Q120Solution {

	public static int minimumTotal(List<List<Integer>> triangle) {
		int h = triangle.size();

		int[] dp = new int[h];
		dp[0] = triangle.get(0).get(0);

		for (int i = 1; i < h; i++) {
			dp[i] = dp[i-1] + triangle.get(i).get(i);
			for (int j = i-1; j >0; j--) {
				dp[j] = Math.min(dp[j-1],dp[j]) + triangle.get(i).get(j);
			}
			dp[0] = dp[0] + triangle.get(i).get(0);;
		}

		int result = dp[0];
		for (int i = 1; i < h; i++) {
			if (dp[i] < result) {
				result = dp[i];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(Arrays.asList(2));
		list.add(Arrays.asList(3,4));
		list.add(Arrays.asList(5,6,7));
		list.add(Arrays.asList(3,1,4,8));
//		[[-1],[-2,-3]]

		int value = Q120Solution.minimumTotal(list);
		System.out.println("value = " + value);
	}
}