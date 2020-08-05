package com.hornsey.algo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author huangtao
 * @date 2020/8/4
 */
public class Q207Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] indegress = new int[numCourses];
		List<List<Integer>> adjacency = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < numCourses; i++) {
			adjacency.add(new ArrayList<>());
		}

		for (int[] cp : prerequisites) {
			indegress[cp[0]]++;
			adjacency.get(cp[1]).add(cp[0]);
		}

		for (int i = 0; i < numCourses; i++) {
			if (indegress[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int pre = queue.poll();
			numCourses--;
			for (int cur : adjacency.get(pre)) {
				if (--indegress[cur] == 0) {
					queue.add(cur);
				}
			}
		}
		return numCourses == 0;
	}
}
