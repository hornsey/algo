package com.hornsey.algo.leetcode;

import com.hornsey.Test;

/**
 * @author huangtao
 * @date 2020/7/28
 */
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
