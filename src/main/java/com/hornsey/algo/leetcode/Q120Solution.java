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
		int[][] values = new int[h][h];

		values[0][0] = triangle.get(0).get(0);
		for (int i=1; i<h; i++) {
			values[i][0] = values[i-1][0] + triangle.get(i).get(0);
			values[i][i] = values[i-1][i-1] + triangle.get(i).get(i);
			for (int j = 1; j<h-1 && j < i; j++) {
				int v1 = values[i-1][j-1] + triangle.get(i).get(j);
				int v2 = values[i-1][j] + triangle.get(i).get(j);
				values[i][j] = v1 < v2 ? v1 : v2;
			}
		}

		int minValue = Integer.MAX_VALUE;
		for (int i = 0; i<h; i++) {
			if (values[h-1][i] < minValue) {
				minValue = values[h-1][i];
			}
		}
		return minValue;
	}

	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(Arrays.asList(2));
		list.add(Arrays.asList(3,4));
		list.add(Arrays.asList(5,6,7));
		list.add(Arrays.asList(3,1,4,8));

		int value = Q120Solution.minimumTotal(list);
		System.out.println("value = " + value);
	}
}