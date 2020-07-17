package com.hornsey.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huangtao
 * @date 2020/7/14
 */
public class AtomicIntegerTest {

	public static void main(String[] args) {
		AtomicInteger count = new AtomicInteger(0);
		Thread[] threads = new Thread[10];
		CountDownLatch latch = new CountDownLatch(10);
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(() -> {
				ThreadLocalRandom random = ThreadLocalRandom.current();
				int x = random.nextInt(100);
				System.out.println(Thread.currentThread().getName() + ": x=" + x
						                   + ",count=" + count.addAndGet(x));
				latch.countDown();
			});
			threads[i].start();
		}
		System.out.println(latch.getCount());
		try {
			latch.await(3000, TimeUnit.MILLISECONDS);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Total = " + count.get());
	}
}
