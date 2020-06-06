package com.hornsey.guava.io;

import com.google.common.hash.Hashing;
import com.google.common.io.ByteSink;
import com.google.common.io.ByteSource;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @Author huangtao
 * @create 2020/5/5
 */
public class ByteSinkTest {
	private static final String SINK_FILE = "./src/test/java/resources/io/sink.txt";
	private static final String SOURCE_FILE = "./src/test/java/resources/io/source.txt";
	private static final String DEST_FILE = "./src/test/java/resources/io/dest.txt";

	@Test
	public void testWrite() throws IOException {
		File file = new File(SINK_FILE);
		ByteSink byteSink = Files.asByteSink(file);
		String content = "ByteSinkTest content";
		byteSink.write(content.getBytes());
		byte[] bytes = Files.toByteArray(file);
		assertThat(bytes, is(content.getBytes()));
	}

	@Test
	public void testFromSourceToSink() throws IOException {
		File sourceFile = new File(SOURCE_FILE);
		File destFile = new File(DEST_FILE);
		destFile.deleteOnExit();
		ByteSource byteSource = Files.asByteSource(sourceFile);
		ByteSink byteSink = Files.asByteSink(destFile);
		byteSource.copyTo(byteSink);
		assertThat(destFile.exists(), equalTo(true));
		System.out.println(byteSource.hash(Hashing.sha256()).toString());
		System.out.println(Files.asByteSource(destFile).hash(Hashing.sha256()).toString());


	}
}
