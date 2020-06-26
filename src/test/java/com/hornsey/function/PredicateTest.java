package com.hornsey.function;

import org.junit.Test;

import java.util.function.Predicate;

/**
 * @author huangtao
 * @date 2020/6/13
 */
public class PredicateTest {

	@Test
	public void test01() {
		Predicate<Integer> gt10 = n -> n > 10;
		Predicate<Integer> lt8 = n -> n < 8;
		Predicate<Integer> workTime = n -> n > 8 && n < 18;

		System.out.println(gt10.test(8));
		System.out.println(lt8.test(9));
		System.out.println(workTime.test(14));
	}
}
