package com.hornsey.guava.io;

import com.google.common.io.ByteSource;
import com.google.common.io.Closer;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * @Author huangtao
 * @create 2020/5/5
 */
public class CloserTest {

	private static final String SOURCE_FILE = "./src/test/java/resources/io/source.txt";

	@Test
	public void testTryCatch() throws IOException {
		File file = new File(SOURCE_FILE);
		ByteSource byteSource = Files.asByteSource(file);


		Closer closer = Closer.create();
		try {
			InputStream inputStream = closer.register(byteSource.openStream());
			byte[] buffer = new byte[1024];
			int read = inputStream.read(buffer);
			if (read != -1) {
				System.out.println(read);
				String x = new String(buffer);
				System.out.println(x.length());
				System.out.println(x);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw closer.rethrow(e);
		} finally {
			closer.close();
		}
	}
}
