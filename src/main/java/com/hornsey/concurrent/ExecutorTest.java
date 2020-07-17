package com.hornsey.concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.lang.math.IntRange;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huangtao
 * @date 2020/7/14
 */
@Component
public class ExecutorTest {

	private ExecutorService executor;

	AtomicInteger count = new AtomicInteger(0);

	public static void main(String[] args) {
		ExecutorTest test = new ExecutorTest();
		test.test();
	}

	private void test() {
		init();
		for (int i = 0; i < 5; i++) {
			executor.submit(() -> {
				ThreadLocalRandom random = ThreadLocalRandom.current();
				int x = random.nextInt(100);
				System.out.println(Thread.currentThread().getName() + ": x=" + x
						                   + ",count=" + count.addAndGet(x));
			});
		}
	}

	@PostConstruct
	private void init() {
		executor = new ThreadPoolExecutor(4, 8, 60000, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<>(1000),
				new ThreadFactoryBuilder().build(),
				new ThreadPoolExecutor.DiscardOldestPolicy());
	}
}
