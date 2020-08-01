package com.hornsey.algo.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huangtao
 * @date 2020/8/2
 */
public class Q114Solution {
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		dfs(root, queue);
		queue.poll();
		root.left = null;

		TreeNode tmp;
		TreeNode tail = root;
		while (!queue.isEmpty()) {
			tmp = queue.poll();
			tmp.left = null;
			tail.right = tmp;
			tail = tmp;
		}
	}

	private void dfs(TreeNode root, Queue<TreeNode> queue) {
		if (root == null) {
			return;
		}
		queue.offer(root);
		dfs(root.left, queue);
		dfs(root.right, queue);
	}
}
