package com.hornsey.algo.leetcode;

/**
 * 给你一个由大小写英文字母组成的字符串 s 。
 *
 * 一个整理好的字符串中，两个相邻字符 s[i] 和 s[i + 1] 不会同时满足下述条件：
 *
 * 0 <= i <= s.length - 2
 * s[i] 是小写字符，但 s[i + 1] 是对应的大写字符；反之亦然 。
 * 请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。
 *
 * 请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。
 *
 * 注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。
 */

import java.util.Stack;

/**
 * @author huangtao
 * @date 2020/8/9
 */
public class Q5483Solution {
	public String makeGood(String s) {
		if (s == null || s.length() < 2) {
			return s;
		}

		Stack<Character> stack = new Stack<>();
		int diff1 = 'A' - 'a', diff2 = 'a' - 'A';
		for (int i = 0; i < s.length(); i++) {
			char x = s.charAt(i);
			if (stack.isEmpty()) {
				stack.push(x);
				continue;
			}

			char y = stack.peek();
			if (x - y == diff1 || x - y == diff2) {
				stack.pop();
			} else {
				stack.push(x);
			}

		}

		if (stack.isEmpty()) {
			return "";
		} else {
			StringBuilder sb = new StringBuilder();
			while (!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			return sb.reverse().toString();
		}
	}

	public static void main(String[] args) {
		Q5483Solution solution = new Q5483Solution();
		System.out.println(solution.makeGood("abBAcC"));
	}
}
