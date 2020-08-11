package com.hornsey.algo.leetcode;

/**
 * @author huangtao
 * @date 2020/8/11
 */
public class Q24Solution {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = new ListNode(-1);
		pre.next = head;
		ListNode tmp = pre;
		while (tmp.next != null && tmp.next.next != null) {
			ListNode first = tmp.next;
			ListNode second = tmp.next.next;

			tmp.next = second;
			first.next = second.next;
			second.next = first;
			tmp = first;
		}
		return pre.next;
	}
}
