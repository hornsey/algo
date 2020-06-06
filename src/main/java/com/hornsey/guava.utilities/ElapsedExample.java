package com.hornsey.guava.utilities;

import com.google.common.base.Stopwatch;

import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

/**
 * @Author huangtao
 * @create 2020/5/4
 */
public class ElapsedExample {

	public static void main(String[] args) throws InterruptedException {
		test1("10001");
	}

	private static void test1(String orderNo) throws InterruptedException {
		Stopwatch stopwatch = Stopwatch.createStarted();
		TimeUnit.MILLISECONDS.sleep(100);
		System.out.println(String.format("The order %s elapsed %s ", orderNo,
				stopwatch.elapsed()));
		TimeUnit.MILLISECONDS.sleep(500);
		System.out.println(String.format("The order %s elapsed %s ", orderNo,
				stopwatch.elapsed()));

	}
}
