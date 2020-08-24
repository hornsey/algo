package com.hornsey.algo.leetcode;

import com.hornsey.algo.util.TreeNode;

/**
 * @author huangtao
 * @date 2020/8/24
 */
public class Q226Solution {
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		TreeNode tmp = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(tmp);
		return root;
	}
}
