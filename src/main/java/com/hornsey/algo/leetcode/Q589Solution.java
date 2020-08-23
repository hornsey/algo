package com.hornsey.algo.leetcode;

import com.hornsey.algo.util.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * bfs前序遍历
 * @author huangtao
 * @date 2020/8/23
 * @version 3
 */
public class Q589Solution {
	public List<Integer> preorder(Node root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		Deque<Node> stack = new ArrayDeque<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node tmp = stack.pop();
			res.add(tmp.val);
			int size = tmp.children.size();
			for (int i = size-1; i >= 0; i--) {
				stack.push(tmp.children.get(i));
			}
		}
		return res;
	}

}
