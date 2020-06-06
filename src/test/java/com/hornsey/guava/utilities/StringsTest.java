package com.hornsey.guava.utilities;

import com.google.common.base.CharMatcher;
import com.google.common.base.Strings;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * @Author huangtao
 * @create 2020/4/5
 */
public class StringsTest {

	@Test
	public void test() {
		assertThat(Strings.emptyToNull(""), nullValue());
		assertThat(Strings.commonPrefix("Hello","Hot"), equalTo("H"));
		assertThat(Strings.repeat("---",3), equalTo("---------"));
		assertThat(Strings.isNullOrEmpty(""), equalTo(true));
		assertThat(Strings.padStart("hello", 8, '*'), equalTo("***hello"));
		assertThat(Strings.padEnd("hello", 8, '*'), equalTo("hello***"));
	}

	@Test
	public void testCharMatcher() {
		assertThat(CharMatcher.inRange('0','9').matches('5'), equalTo(true));
		assertThat(CharMatcher.inRange('0','9').matches('x'), equalTo(false));
		assertThat(Character.isDigit('x'), equalTo(false));
		assertThat(CharMatcher.breakingWhitespace().removeFrom("Hello World!"),equalTo("HelloWorld!"));

		assertThat(CharMatcher.is('o').countIn("Hello world!Welcome!"), equalTo(3));
		assertThat(CharMatcher.inRange('0','9').or(CharMatcher.whitespace()).removeFrom("Hello world, 222!"),
				equalTo("Helloworld,!"));
	}


}
