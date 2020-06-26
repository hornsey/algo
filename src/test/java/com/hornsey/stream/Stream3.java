package com.hornsey.stream;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author huangtao
 * @date 2020/6/18
 */
public class Stream3 {
	private final static String words = "Welcome to Beijing I love Beijing";


	@Test
	public void test01() {
		String[] str = words.split(" ");
		Stream.of(str)
				.parallel()
				.forEach(System.out::println);
	}

	@Test
	public void test02() {
		String[] str = words.split(" ");
		Stream.of(str)
				.parallel()
				.forEachOrdered(System.out::println);
	}

	/**
	 * 单纯长度求和
	 */
	@Test
	public void test03() {
		String[] str = words.split(" ");
		Optional<Integer> reduce = Stream.of(str)
				                           .map(String::length)
										   .filter(n -> n>200)
				                           .reduce(Integer::sum);
		System.out.println(reduce.orElse(-1));
	}

	/**
	 * 单纯长度求和
	 */
	@Test
	public void test4() {
		String[] str = words.split(" ");
		Integer reduce = Stream.of(str)
				                 .map(String::length)
//				                 .filter(n -> n > 200)
				                 .reduce(0, Integer::sum);
		System.out.println(reduce);
	}

	/**
	 * 找最长单词
	 */
	@Test
	public void test5() {
		String[] str = words.split(" ");
		String s = Stream.of(str)
//						   .filter(s1 -> s1.length() > 20)
				           .max((s1, s2) -> s1.length() - s2.length()).orElse("没有元素");
		System.out.println(s);
	}

	/**
	 * 判断是否所有单词长度大于3
	 */
	@Test
	public void test6() {
		String[] str = words.split(" ");
		boolean allMatch = Stream.of(str).allMatch(s -> s.length() > 3);
		System.out.println(allMatch);
	}

	/**
	 * 判断是否存在单词长度大于3
	 */
	@Test
	public void test7() {
		String[] str = words.split(" ");
		boolean anyMatch = Stream.of(str).anyMatch(s -> s.length() > 3);
		System.out.println(anyMatch);
	}

	/**
	 * 判断是否不存在单词长度大于3
	 */
	@Test
	public void test8() {
		String[] str = words.split(" ");
		boolean noneMatch = Stream.of(str).noneMatch(s -> s.length() > 3);
		System.out.println(noneMatch);
	}

	@Test
	public void test9() {
		String[] str = words.split(" ");
		String s = Stream.of(str).findFirst().orElse("没有元素");
		System.out.println(s);
	}








}
