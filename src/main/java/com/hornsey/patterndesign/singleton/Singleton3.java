package com.hornsey.patterndesign.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 双重检测
 *
 * @author huangtao
 * @date 2020/6/7
 */
public class Singleton3 {
	private AtomicLong id = new AtomicLong(0);
	private static volatile Singleton3 instance = null;

	private Singleton3() {
	}

	public static Singleton3 getInstance() {
		if (instance == null) {
			synchronized (Singleton3.class) {
				if (instance == null) {
					instance = new Singleton3();
				}
			}
		}
		return instance;
	}

	/**
	 * 优化版
	 *
	 * @return
	 */
	public static Singleton3 getInstance2() {
		Singleton3 temp = instance;
		if (null == temp) {
			synchronized (Singleton3.class) {
				temp = instance;
				if (null == temp) {
					temp = new Singleton3();
					instance = temp;
				}
			}
		}
		return instance;
	}

	public long getId() {
		return id.incrementAndGet();
	}

	public static void main(String[] args) {
		Singleton3 instance1 = Singleton3.getInstance();
		Singleton3 instance2 = Singleton3.getInstance();
		System.out.println(instance1.getId());
		System.out.println(instance2.getId());
	}
}
