package com.hornsey.effectivejava.chapter7;

import com.google.common.base.Stopwatch;

import java.math.BigInteger;
import java.util.stream.LongStream;

/**
 * @author huangtao
 * @date 2020/6/21
 */
public class StreamParallel {

	static long pi(long n) {
		return LongStream.rangeClosed(2, n)
				       .mapToObj(BigInteger::valueOf)
				       .filter(i -> i.isProbablePrime(10))
				       .parallel()
				       .count();
	}

	public static void main(String[] args) {
		Stopwatch stopwatch = Stopwatch.createStarted();
		System.out.println(pi((long) 10e6));
		System.out.println(stopwatch.elapsed());
//		System.out.println(BigInteger.valueOf(13).isProbablePrime(30));
	}
}
