package com.hornsey.guava.utilities;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.HashMap;
import java.util.Map;


/**
 * @Author huangtao
 * @create 2020/5/3
 */
public class FunctionExample {
	public static void main(String[] args) {
		new FunctionExample().test3();
	}

	private void test1() {
		Function<String, Integer> function = s -> s != null ? s.length() : 0;
		System.out.println(function.apply("hello"));

		process("Hello", new Handler.LengthDoubleHandler());
	}

	private void test2() {
		Function<String, Long> compose = Functions.compose(new Function<Integer, Long>() {
			@Nullable
			@Override
			public Long apply(@Nullable Integer input) {
				return input * 1L;
			}
		}, new Function<String, Integer>() {
			@Nullable
			@Override
			public Integer apply(@Nullable String input) {
				return input.length();
			}
		});
		System.out.println(compose.apply("hello"));
	}

	private void test3() {
		Map<String, Integer> map = new HashMap<>();
		map.put("one", 10);
		map.put("two", 20);
		System.out.println(Functions.forMap(map).apply("one"));
	}


	interface Handler<IN, OUT> {
		OUT handle(IN input);

		class LengthDoubleHandler implements Handler<String, Integer> {

			@Override
			public Integer handle(String input) {
				return input.length()*2;
			}
		}
	}

	private static void process(String text, Handler<String, Integer> handler) {
		System.out.println(handler.handle(text));
	}
}
