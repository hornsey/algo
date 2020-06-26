package com.hornsey.function;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/**
 * @author huangtao
 * @date 2020/6/13
 */
public class BinaryOperatorTest {


	@Test
	public void test01() {
		BiFunction<Integer, Integer, Integer> times = (x,y) -> x*y;
		BinaryOperator<Integer> binFun = (x, y) -> x*y;
		System.out.println(times.apply(3,5));
		System.out.println(binFun.apply(3,5));
	}

	@Test
	public void test02() {
		BinaryOperator<Integer> sum = (x, y) -> x + y;
		Function<Integer, String> result = (x) -> "Result:" + x;
		System.out.println(sum.andThen(result).apply(3,5));
	}

	@Test
	public void test03() {
		BiFunction<Integer, Integer, Integer> times = (x,y) -> x*y;
		Function<Integer, String> square = (x) -> "Result:" + x;

		System.out.println(times.andThen(square).apply(4, 5));
	}

}
