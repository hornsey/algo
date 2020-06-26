package com.hornsey.effectivejava.chapter7;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author huangtao
 * @date 2020/6/18
 */
public class SubLists {
	public static <E> Stream<List<E>> of(List<E> list) {
		return Stream.concat(Stream.of(Collections.emptyList()),
				prefixes(list).flatMap(SubLists::suffixes));
	}

	private static <E> Stream<List<E>> suffixes(List<E> list) {
		return IntStream.range(0, list.size())
				.mapToObj(start -> list.subList(start, list.size()));
	}

	private static <E> Stream<List<E>> prefixes(List<E> list) {
		return IntStream.rangeClosed(1, list.size())
				.mapToObj(end -> list.subList(0, end));
	}
	public static <E> Stream<List<E>> of2(List<E> list) {
		return IntStream.range(0, list.size())
				.mapToObj(start -> IntStream.rangeClosed(start+1, list.size())
						.mapToObj(end -> list.subList(start, end)))
				.flatMap(x -> x);
	}


	public static void main(String[] args) {
		List<String> list = Arrays.asList("a","b","c");
		List<Integer> list2 = Arrays.asList(1,2,3);
//		List<List<String>> lists = SubLists.of(list).collect(Collectors.toList());
//		System.out.println(lists);
//		List<List<String>> lists = suffixes(list).collect(Collectors.toList());
//		System.out.println(lists);

		List<List<String>> lists = SubLists.of2(list).collect(Collectors.toList());
		System.out.println(lists);


	}
}
