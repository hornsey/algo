package com.hornsey.algo.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author huangtao
 * @date 2020/8/16
 */
public class Q641Solution {
	int[] deque;
	int capacity;
	int head;
	int tail;

	/** Initialize your data structure here. Set the size of the deque to be k. */
	public Q641Solution(int k) {
		capacity = k + 1;
		this.deque = new int[capacity];
		head = 0;
		tail = 0;
	}

	/** Adds an item at the front of Deque. Return true if the operation is successful. */
	public boolean insertFront(int value) {
		if (isFull()) {
			return false;
		}
		head = (head - 1 + capacity) % capacity;
		deque[head] = value;
		return true;
	}

	/** Adds an item at the rear of Deque. Return true if the operation is successful. */
	public boolean insertLast(int value) {
		if (isFull()) {
			return false;
		}
		deque[tail] = value;
		tail = (tail + 1) % capacity;
		return true;
	}

	/** Deletes an item from the front of Deque. Return true if the operation is successful. */
	public boolean deleteFront() {
		if (isEmpty()) {
			return false;
		}
		head = (head + 1) % capacity;
		return true;
	}

	/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
	public boolean deleteLast() {
		if (isEmpty()) {
			return false;
		}
		tail = (tail - 1 + capacity) % capacity;
		return true;
	}

	/** Get the front item from the deque. */
	public int getFront() {
		if (isEmpty()) {
			return -1;
		}
		return deque[head];
	}

	/** Get the last item from the deque. */
	public int getRear() {
		if (isEmpty()) {
			return -1;
		}
		int tmp = (tail - 1 + capacity) % capacity;
		return deque[tmp];
	}

	/** Checks whether the circular deque is empty or not. */
	public boolean isEmpty() {
		return head == tail;
	}

	/** Checks whether the circular deque is full or not. */
	public boolean isFull() {
		return (head - 1 + capacity) % capacity == tail;
	}
}
