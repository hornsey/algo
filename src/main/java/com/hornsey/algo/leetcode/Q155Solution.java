package com.hornsey.algo.leetcode;

import java.util.Stack;

/**
 * @author huangtao
 * @date 2020/8/16
 */
public class Q155Solution {
	Stack<Integer> stack;
	Stack<Integer> minStack;

	/** initialize your data structure here. */
	public Q155Solution() {
		stack = new Stack<>();
		minStack = new Stack<>();
		minStack.push(Integer.MAX_VALUE);
	}

	public void push(int x) {
		stack.push(x);
		int min = minStack.peek();
		if (x < min) {
			min = x;
		}
		minStack.push(min);
	}

	public void pop() {
		if (!stack.isEmpty()) {
			stack.pop();
			minStack.pop();
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}
