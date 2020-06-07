package com.hornsey.patterndesign.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 懒汉式
 *
 * @author huangtao
 * @date 2020/6/7
 */
public class Singleton2 {
	private AtomicLong id = new AtomicLong(0);
	private static Singleton2 instance;
	private Singleton2() {
	}

	public synchronized static Singleton2 getInstance() {
		if (instance == null) {
			instance = new Singleton2();
		}
		return instance;
	}

	public long getId() {
		return id.incrementAndGet();
	}

	public static void main(String[] args) {
		Singleton2 instance1 = Singleton2.getInstance();
		Singleton2 instance2 = Singleton2.getInstance();
		System.out.println(instance1.getId());
		System.out.println(instance2.getId());
	}
}
