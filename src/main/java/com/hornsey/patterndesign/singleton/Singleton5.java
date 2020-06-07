package com.hornsey.patterndesign.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 枚举
 *
 * @author huangtao
 * @date 2020/6/7
 */
public enum Singleton5 {
	/**
	 *
	 */
	SINGLETON;

	private AtomicLong id = new AtomicLong(0);

	private static Singleton5 instance = null;
	private Singleton5() {
	}

	public static Singleton5 getInstance() {
		return SINGLETON;
	}

	public long getId() {
		return id.incrementAndGet();
	}

	public static void main(String[] args) {
		Singleton5 instance1 = Singleton5.getInstance();
		Singleton5 instance2 = Singleton5.getInstance();
		System.out.println(instance1.getId());
		System.out.println(instance2.getId());
	}
}
