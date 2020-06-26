package com.hornsey.function;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author huangtao
 * @date 2020/6/13
 */
public class BiFunctionTest {


	@Test
	public void test01() {
		BiFunction<Integer, Integer, String> fun = (x,y) -> x + "-" + y;
		System.out.println(fun.apply(3,5));
	}

	@Test
	public void test02() {
		BiFunction<Integer, Integer, Integer> times = (x,y) -> x*y;
		Function<Integer, String> square = (x) -> "Result:" + x;

		System.out.println(times.andThen(square).apply(4, 5));
	}

}
