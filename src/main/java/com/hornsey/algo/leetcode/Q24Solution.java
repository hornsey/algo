package com.hornsey.algo.leetcode;

/**
 * @author huangtao
 * @date 2020/8/11
 * @version v2 递归
 */
public class Q24Solution {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode next = head.next;
		head.next = swapPairs(next.next);
		next.next = head;

		return next;
	}
}
