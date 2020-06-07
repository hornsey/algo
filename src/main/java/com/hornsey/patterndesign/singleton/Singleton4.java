package com.hornsey.patterndesign.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author huangtao
 * @date 2020/6/7
 */
public class Singleton4 {
	private AtomicLong id = new AtomicLong(0);
	private Singleton4() {
	}

	public static Singleton4 getInstance() {
		return InnerSingleton4.instance;
	}

	private static class InnerSingleton4 {
		private static final Singleton4 instance = new Singleton4();
	}

	public long getId() {
		return id.incrementAndGet();
	}

	public static void main(String[] args) {
		Singleton4 instance1 = Singleton4.getInstance();
		Singleton4 instance2 = Singleton4.getInstance();
		System.out.println(instance1.getId());
		System.out.println(instance2.getId());
	}
}
