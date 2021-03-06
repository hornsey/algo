package com.hornsey.effectivejava.chapter5;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * @author huangtao
 * @date 2020/7/16
 */
public class Stack2<E> {
	private E[] elements;
	private int size;
	private static final int DEFAULT_INITIAL_SIZE = 16;

	@SuppressWarnings("unchecked")
	public Stack2() {
		elements = (E[])new Object[DEFAULT_INITIAL_SIZE];
	}

	public void push(E e) {
		ensureCapacity();
		elements[size++] = e;
	}

	private void ensureCapacity() {
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2*size + 1);
		}
	}

	public E pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		E result = elements[--size];
		elements[size] = null;
		return result;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void pushAll(Iterable<? extends E> src) {
		for (E e : src) {
			push(e);
		}
	}

	public void popAll(Collection<? super E> dst) {
		while (!isEmpty()) {
			dst.add(pop());
		}
	}

	public static void main(String[] args) {
		Stack2<Integer> stack2 = new Stack2<>();
		stack2.push(3);
		stack2.push(5);
		stack2.push(8);

		List<Integer> list = Lists.newArrayList(1,2,4);
		stack2.pushAll(list);

		List<Number> dst = new ArrayList<>();
		stack2.popAll(dst);

//		while (!stack2.isEmpty()) {
//			System.out.println(stack2.pop());
//		}


		System.out.println(dst);
	}

}
