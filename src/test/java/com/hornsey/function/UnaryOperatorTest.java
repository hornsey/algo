package com.hornsey.function;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * @author huangtao
 * @date 2020/6/13
 */
public class UnaryOperatorTest {

	@Test
	public void test01() {
		Function<Integer, Integer> fun = x -> x*2;
		System.out.println(fun.apply(5));
	}

	@Test
	public void test02() {
		UnaryOperator<Integer> up = x -> x*2;
		System.out.println(up.apply(4));
	}
}
