package com.hornsey.algo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author huangtao
 * @date 2020/8/2
 * @version 2
 */
public class Q114Solution {
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}

		List<TreeNode> list = new ArrayList<>();
		dfs(root, list);

		for (int i = 1; i < list.size(); i++) {
			TreeNode pre = list.get(i-1);
			pre.left = null;
			pre.right = list.get(i);
		}
	}

	private void dfs(TreeNode root, List<TreeNode> list) {
		if (root == null) {
			return;
		}
		list.add(root);
		dfs(root.left, list);
		dfs(root.right, list);
	}
}
