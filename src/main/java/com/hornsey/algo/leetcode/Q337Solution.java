package com.hornsey.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangtao
 * @date 2020/8/5
 */
public class Q337Solution {
	/**
	* 选择该节点的收益
	**/
	Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>();
	/**
	 * 不选择该节点的收益
	 **/
	Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();

	public int rob(TreeNode root) {
		dfs(root);
		return Math.max(f.getOrDefault(root,0), g.getOrDefault(root,0));
	}

	private void dfs(TreeNode root) {
		if (root == null) {
			return;
		}

		dfs(root.left);
		dfs(root.right);
		f.put(root, root.val + g.getOrDefault(root.left, 0) + g.getOrDefault(root.right, 0));
		g.put(root, Math.max(f.getOrDefault(root.left, 0), g.getOrDefault(root.left, 0)) +
				            Math.max(f.getOrDefault(root.right, 0), g.getOrDefault(root.right, 0)));
	}
}
