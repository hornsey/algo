package com.hornsey.guava.utilities;

import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @Author huangtao
 * @create 2020/3/29
 */
public class SplitterTest {

	private String string1 = "hello |  world";
	private String string2 = "hello|world|||bye";

	@Test
	public void test1() {
		List<String> list = Splitter.on("|").splitToList(string1);
		System.out.println(list.size());
		System.out.println(list);
	}

	@Test
	public void testSplitterOmitEmpty() {
		List<String> list = Splitter.on("|").omitEmptyStrings().splitToList(string2);
		System.out.println(list.size());
		System.out.println(list);
	}

	@Test
	public void testSplitterOmitEmptyTrimResult() {
		List<String> list = Splitter.on("|").omitEmptyStrings().trimResults().splitToList("hello |  world");
		System.out.println(list.size());
		System.out.println(list);
	}

	@Test
	public void testSplitterFixlength() {
		List<String> list = Splitter.fixedLength(4).splitToList("aaaabbbbccccddddee");
		System.out.println(list.size());
		System.out.println(list);
	}

	@Test
	public void testSplitterOnSplitLimit() {
		List<String> list = Splitter.on("#").limit(3).splitToList("aaaa#bbbb#cccc#dddd#ee");
		System.out.println(list.size());
		System.out.println(list);
	}

	@Test
	public void testSplitterOnPatternString() {
		List<String> list = Splitter.onPattern("\\|").omitEmptyStrings().trimResults().splitToList("hello | world| ||bye");
		System.out.println(list.size());
		System.out.println(list);
	}

	@Test
	public void testSplitterOnSplitToMap() {
		Map<String, String> list = Splitter.on(Pattern.compile("\\|")).omitEmptyStrings().trimResults()
									.withKeyValueSeparator("=")
				                    .split("hello=HELLO | world=WORLD| ||");
		System.out.println(list.size());
		System.out.println(list);
	}

}
