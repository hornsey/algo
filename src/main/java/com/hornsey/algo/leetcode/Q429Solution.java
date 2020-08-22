package com.hornsey.algo.leetcode;

import com.hornsey.algo.util.Node;
import com.hornsey.algo.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历
 *
 * @author huangtao
 * @date 2020/8/22
 */
public class Q429Solution {
	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> res = new ArrayList<>();
		Queue<Node> queue = new LinkedList<>();
		if (root == null) {
			return res;
		}
		queue.offer(root);
		while (!queue.isEmpty()) {
			int count = queue.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < count; i++) {
				Node node = queue.poll();
				list.add(node.val);
				for (Node child : node.children) {
					queue.offer(child);
				}
			}
			res.add(list);
		}
		return res;
	}
}
