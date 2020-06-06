package com.hornsey.guava.utilities;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.google.common.collect.ImmutableMap.of;

/**
 * @Author huangtao
 * @create 2020/3/29
 */
public class JoinerTest {

	private final List<String> stringList = Arrays.asList(
			"Google", "Guava", "Java", "Test", "Kafka"
	);
	private final List<String> stringListWithNull = Arrays.asList(
			"Google", "Guava", "Java", "Test", null, "Kafka"
	);

	@Test
	public void test1() {
		String result = Joiner.on("-").join(stringList);
		System.out.println(result);
	}

	@Test
	public void test2() {
		String result = Joiner.on("-").skipNulls().join(stringListWithNull);
		System.out.println(result);
	}

	@Test
	public void test3() {
		String result = Joiner.on("-").useForNull("Default").join(stringListWithNull);
		System.out.println(result);
	}

	@Test
	public void test4() {
		StringBuilder builder = new StringBuilder("src-");
		StringBuilder result = Joiner.on("-").useForNull("Default").appendTo(builder, stringListWithNull);
		System.out.println(builder);
		System.out.println(result);
	}

	@Test
	public void testAppendToFile() {
		try {
			FileWriter fileWriter = new FileWriter(new File("./joiner.txt"));
			Joiner.on("-").useForNull("Default").appendTo(fileWriter, stringListWithNull);
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testJoiningByStream() {
		String result = stringListWithNull.stream().filter(item -> item != null && !item.isEmpty())
				                 .collect(Collectors.joining("-"));
		System.out.println(result);
	}

	@Test
	public void testJoiningByStreamWithDefault() {
		String result = stringListWithNull.stream()
				                .map(item -> item==null||item.isEmpty() ? "Default" : item)
				                .collect(Collectors.joining("-"));
		System.out.println(result);
	}

	@Test
	public void testJoinMapToStringBuilder() {
		Map<String, String> stringMap = of("Google", "Guava", "Java", "Kafka");
		String result = Joiner.on(",").withKeyValueSeparator("-").join(stringMap);
		System.out.println(result);
	}

	@Test
	public void testJoinMap() {
		Map<String, String> stringMap = of("Google", "Guava", "Java", "Kafka");
		StringBuilder builder = new StringBuilder("src:");
		Joiner.on(",").withKeyValueSeparator("-").appendTo(builder,stringMap);
		System.out.println(builder);
	}

}
