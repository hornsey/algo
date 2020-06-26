package com.hornsey.stream;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author huangtao
 * @date 2020/6/18
 */
public class Stream2 {
	private final static String words = "Welcome to Beijing I love Beijing";


	@Test
	public void test01() {
		String[] str = words.split(" ");
		Stream.of(str).peek(System.out::println)
				.map(String::length)
				.forEach(System.out::println);
	}

	@Test
	public void test02() {
		String[] str = words.split(" ");
		Map<String, Integer> map = Stream.of(str).collect(Collectors.toMap(s -> s, String::length, (k1,k2)-> k1));
		System.out.println(map);

	}

	@Test
	public void test03() {
		String[] str = words.split(" ");
		Stream.of(str)
				.flatMap(word -> Stream.of(word.split("")))
				.distinct()
				.sorted()
				.forEach(System.out::print);
	}

	@Test
	public void test04() {
		String[] str = words.split(" ");
		Stream.of(str).skip(2).forEach(System.out::print);
	}

	@Test
	public void test05() {
		Stream.of(words.split(" "))
				.flatMap(word -> Stream.of(word.split("")))
				.sorted()
				.peek(System.out::print)
				.forEach(System.out::print);
	}

	@Test
	public void test06() {
		List<String> collect = Stream.of(words.split(" "))
				                       .flatMap(word -> Stream.of(word.split("")))
				                       .collect(Collectors.toList());
		System.out.println(collect);
	}







}
