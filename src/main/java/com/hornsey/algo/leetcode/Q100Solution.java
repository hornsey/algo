package com.hornsey.algo.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huangtao
 * @date 2020/8/7
 */
public class Q100Solution {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		Queue<TreeNode> q1 = new LinkedList<>();
		Queue<TreeNode> q2 = new LinkedList<>();
		q1.add(p);
		q2.add(q);

		while (!q1.isEmpty() && !q2.isEmpty()) {
			TreeNode node1 = q1.poll();
			TreeNode node2 = q2.poll();
			if (node1.val != node2.val) {
				return false;
			}

			TreeNode left1 = node1.left,left2 = node2.left;
			TreeNode right1 = node1.right,right2 = node2.right;
			if (left1 == null ^ left2 == null) {
				return false;
			}
			if (right1 == null ^ right2 == null) {
				return false;
			}
			if (node1.left != null) {
				q1.add(node1.left);
			}
			if (node1.right != null) {
				q1.add(node1.right);
			}
			if (node2.left != null) {
				q2.add(node2.left);
			}
			if (node2.right != null) {
				q2.add(node2.right);
			}
		}

		return q1.isEmpty() && q2.isEmpty();

	}
}
