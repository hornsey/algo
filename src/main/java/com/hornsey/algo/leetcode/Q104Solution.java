package com.hornsey.algo.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huangtao
 * @date 2020/7/28
 */
public class Q104Solution {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		int level = 0;
		while (!q.isEmpty()) {
			level++;
			int len = q.size();
			for (int i = 0; i < len; i++) {
				TreeNode node = q.poll();
				if (node.left != null) {
					q.offer(node.left);
				}
				if (node.right != null) {
					q.offer(node.right);
				}
			}
		}
		return level;
	}
}
