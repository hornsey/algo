package com.hornsey.function;

import org.junit.Test;

import java.util.function.Supplier;

/**
 * @author huangtao
 * @date 2020/6/13
 */
public class SupplierTest {

	@Test
	public void test01() {
		Supplier<String> sup = () -> "Hello World!";
		System.out.println(sup.get());
	}
}
