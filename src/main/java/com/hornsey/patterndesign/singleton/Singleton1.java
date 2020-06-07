package com.hornsey.patterndesign.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 饿汉式
 *
 * @author huangtao
 * @date 2020/6/7
 */
public class Singleton1 {
	private AtomicLong id = new AtomicLong(0);
	private static Singleton1 instance = new Singleton1();
	private Singleton1() {
	}

	public static Singleton1 getInstance() {
		return instance;
	}

	public long getId() {
		return id.incrementAndGet();
	}

	public static void main(String[] args) {
		Singleton1 instance1 = Singleton1.getInstance();
		Singleton1 instance2 = Singleton1.getInstance();
		System.out.println(instance1.getId());
		System.out.println(instance2.getId());
	}
}
