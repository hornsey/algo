package com.hornsey.algo.leetcode;

import java.util.*;

/**
 * @author huangtao
 * @date 2020/8/20
 */
public class Q347Solution {
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> countMap = new HashMap<>();
		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
				new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

		for (int num : nums) {
			countMap.merge(num, 1, Integer::sum);
		}

		for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
			maxHeap.add(entry);
		}

		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = maxHeap.poll().getKey();
		}
		return res;
	}
}
