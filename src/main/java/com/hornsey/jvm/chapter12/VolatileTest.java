package com.hornsey.jvm.chapter12;

/**
 * @author huangtao
 * @date 2020/6/28
 */
public class VolatileTest {
	private static volatile int race = 0;
	private static final int THREADS_COUNT = 20;

	public static void increase() {
		race++;
	}

	public static void main(String[] args) {
		Thread[] threads = new Thread[THREADS_COUNT];
		for (int i = 0; i < THREADS_COUNT; i++) {
			threads[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 1000; j++) {
						increase();
					}
				}
			});
			threads[i].start();
		}

		System.out.println(Thread.activeCount());
		while (Thread.activeCount() > 2) {
			System.out.println(Thread.activeCount());
			System.out.println(Thread.currentThread().getThreadGroup());
			Thread.yield();
		}
		System.out.println(Thread.activeCount());
		System.out.println(Thread.currentThread().getThreadGroup());
		System.out.println(Thread.currentThread().getThreadGroup().toString());

		System.out.println(race);
	}
}
