package com.hornsey.algo.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author huangtao
 * @date 2020/7/21
 */

public class Q95Solution {

	public List<TreeNode> generateTrees(int n) {
		if (n == 0) {
			return new LinkedList<TreeNode>();
		}
		return gen(1,n);

	}

	private List<TreeNode> gen(int start, int end) {
		List<TreeNode> res = new LinkedList<>();
		if (start > end) {
			res.add(null);
			return res;
		}

		for (int i = start; i <= end; i++) {
			List<TreeNode> leftTrees = gen(start, i-1);
			List<TreeNode> rightTrees = gen( i+1, end);

			for (TreeNode left : leftTrees) {
				for (TreeNode right : rightTrees) {
					TreeNode node = new TreeNode(i);
					node.left = left;
					node.right = right;
					res.add(node);
				}
			}

		}
		return res;
	}
}
