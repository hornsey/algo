package com.hornsey.algo.leetcode;

import com.hornsey.algo.util.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangtao
 * @date 2020/8/23
 */
public class Q589Solution {
	public List<Integer> preorder(Node root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		dfs(root, res);
		return res;
	}

	private void dfs(Node root, List<Integer> res) {
		if (root == null) {
			return;
		}
		res.add(root.val);
		for (Node child : root.children) {
			dfs(child, res);
		}
	}
}
