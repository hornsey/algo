package com.hornsey.algo.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * bfs 迭代实现前序遍历
 *
 * @author huangtao
 * @date 2020/8/22
 * @version 2
 */
public class Q144Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();

		if (root == null) {
			return res;
		}
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode tmp = stack.pop();
			res.add(tmp.val);
			if (tmp.right != null) {
				stack.push(tmp.right);
			}
			if (tmp.left != null) {
				stack.push(tmp.left);
			}
		}

		return res;
	}

}
