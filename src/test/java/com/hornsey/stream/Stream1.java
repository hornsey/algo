package com.hornsey.stream;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author huangtao
 * @date 2020/6/18
 */
public class Stream1 {

	@Test
	public void test01() {
		IntStream.range(1,20)
				.peek(Stream1::print)
				.count();
	}

	@Test
	public void test02() {
		IntStream.range(1,20)
				.peek(Stream1::printRed)
				.parallel()
				.count();
	}

	@Test
	public void test03() {
		IntStream.range(1,20)
				.sequential()
				.peek(Stream1::printRed)
				.parallel()
				.peek(Stream1::print)
				.count();
	}

	@Test
	public void test04() {
		String key = "java.util.concurrent.ForkJoinPool.common.parallelism";
		System.setProperty(key, "31");

		IntStream.range(1,20)
				.sequential()
				.peek(Stream1::printRed)
				.parallel()
				.peek(Stream1::print)
				.count();
	}

	/**
	 * 自定义线程池
	 */
	@Test
	public void test05() {
		ForkJoinPool pool = new ForkJoinPool(8);
		pool.submit(() -> IntStream.range(1,20)
				                  .parallel()
				                  .peek(Stream1::print)
				                  .count());
		synchronized (pool) {
			try {
				pool.wait(3, 200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	public static void print(int i)  {
		String name = Thread.currentThread().getName();
		System.out.println(i  + "--" + name);

		try {
			TimeUnit.MILLISECONDS.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void printRed(int i)  {
		String name = Thread.currentThread().getName();
		System.err.println(i + "--" + name);

		try {
			TimeUnit.MILLISECONDS.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
