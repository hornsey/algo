package com.hornsey.algo.leetcode;

/**
 * @author huangtao
 * @date 2020/8/5
 */
public class Q337Solution {

	public int rob(TreeNode root) {
		int[] status = dfs(root);
		return Math.max(status[0], status[1]);
	}

	private int[] dfs(TreeNode root) {
		if (root == null) {
			return new int[]{0,0};
		}

		int[] l = dfs(root.left);
		int[] r = dfs(root.right);
		int selected = root.val + l[1] + r[1];
		int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
		return new int[]{selected, notSelected};
	}
}
