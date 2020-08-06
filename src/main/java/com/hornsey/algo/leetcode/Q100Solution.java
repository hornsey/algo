package com.hornsey.algo.leetcode;

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

		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

	}
}
