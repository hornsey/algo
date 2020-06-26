package com.hornsey.function;

import org.junit.Test;

import java.util.function.Function;

/**
 * @author huangtao
 * @date 2020/6/13
 */
public class FunctionTest {


	@Test
	public void test01() {
		Function<Integer, String> fun = n -> "The year is " + n;
		System.out.println(fun.apply(2020));
	}

	@Test
	public void test02() {
		Function<Integer, Integer> times = n -> n*2;
		Function<Integer, Integer> square = n -> n*n;

		System.out.println(times.andThen(square).apply(4));
	}

	@Test
	public void test03() {
		Function<Integer, Integer> times = n -> n*2;
		Function<Integer, Integer> square = n -> n*n;

		System.out.println(times.compose(square).apply(4));
	}
	@Test
	public void test04() {

		System.out.println(Function.identity().apply(8*2));
	}

}
