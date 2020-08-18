package com.hornsey.algo.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author huangtao
 * @date 2020/8/18
 * @version 2
 */
public class Q94Solution {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Deque<TreeNode> deque = new ArrayDeque<>();

		TreeNode tmp = root;
		while (tmp != null || !deque.isEmpty()) {
			while (tmp != null) {
				deque.push(tmp);
				tmp = tmp.left;
			}
			tmp = deque.pop();
			res.add(tmp.val);
			tmp = tmp.right;
		}

		return res;
	}




}
