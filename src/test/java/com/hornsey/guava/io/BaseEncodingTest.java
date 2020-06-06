package com.hornsey.guava.io;

import com.google.common.io.BaseEncoding;
import org.junit.Test;

/**
 * @Author huangtao
 * @create 2020/5/5
 */
public class BaseEncodingTest {

	@Test
	public void testEncoding() {
		BaseEncoding encoding = BaseEncoding.base64();
		System.out.println(encoding.encode("HelloWorld".getBytes()));
		System.out.println(Base64.encode("HelloWorld"));
	}

	@Test
	public void testDecoding() {
		BaseEncoding encoding = BaseEncoding.base64();
		System.out.println(new String(encoding.decode("aGVsbG8=")));
	}
}
