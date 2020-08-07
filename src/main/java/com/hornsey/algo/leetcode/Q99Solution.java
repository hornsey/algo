package com.hornsey.algo.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author huangtao
 * @date 2020/8/8
 */
public class Q99Solution {
	public void recoverTree(TreeNode root) {
		List<Integer> nums = new LinkedList<>();
		inorder(root, nums);
		int[] swapped = findSwapNum(nums);
		recover(root, 2, swapped[0], swapped[1]);
	}

	private void inorder(TreeNode root, List<Integer> nums) {
		if (root == null) {
			return;
		}
		inorder(root.left, nums);
		nums.add(root.val);
		inorder(root.right, nums);
	}

	private int[] findSwapNum(List<Integer> nums) {
		int n = nums.size();
		int x = -1, y = -1;
		for (int i = 0; i < n-1; i++) {
			if (nums.get(i+1) < nums.get(i)) {
				y = nums.get(i+1);
				if (x == -1) {
					x = nums.get(i);
				} else {
					break;
				}
			}
		}
		return new int[]{x,y};
	}


	private void recover(TreeNode root, int count, int x, int y) {
		if (root != null) {
			if (root.val == x || root.val == y) {
				root.val = (root.val == x) ? y : x;
				if (--count == 0) {
					return;
				}
			}
			recover(root.left, count, x, y);
			recover(root.right, count, x, y);
		}
	}
}
