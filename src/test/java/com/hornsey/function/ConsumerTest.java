package com.hornsey.function;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @author huangtao
 * @date 2020/6/13
 */
public class ConsumerTest {

	@Test
	public void test01() {
		Consumer<String> con = s -> System.out.println("Hello, " + s);
		con.accept("hello");
	}

	@Test
	public void test02() {
		Consumer<Integer> con1 = n -> System.out.println(n*2);
		Consumer<Integer> con2 = n -> System.out.println(n*n);
		con1.andThen(con2).accept(5);
	}


}
