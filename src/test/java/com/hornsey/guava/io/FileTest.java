package com.hornsey.guava.io;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.CharSink;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;
import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @Author huangtao
 * @create 2020/5/4
 */
public class FileTest {
	public static final String SOURCE_FILE = "./src/test/java/resources/io/source.txt";
	public static final String DEST_FILE = "./src/test/java/resources/io/dest.txt";
	public static final String WRITE_FILE = "./src/test/java/resources/io/write.txt";
	private static final String TOUCH_FILE = "./src/test/java/resources/io/touch.txt";

	@Test
	public void copyFileWithGuava() throws IOException {
		File destFile = new File(DEST_FILE);
		Files.copy(new File(SOURCE_FILE), destFile);
		assertThat(destFile.exists(), equalTo(true));
	}

	@Test
	public void copyFileWithNio2() throws IOException {
		java.nio.file.Files.copy(Paths.get(SOURCE_FILE), Paths.get(DEST_FILE),
				StandardCopyOption.REPLACE_EXISTING);
		assertThat(new File(DEST_FILE).exists(), equalTo(true));
	}

	@Test
	public void testMoveFile() throws IOException {
		try {
			Files.move(new File(SOURCE_FILE), new File(DEST_FILE));
			assertThat(new File(SOURCE_FILE).exists(), equalTo(false));
			assertThat(new File(DEST_FILE).exists(), equalTo(true));
		} finally {
			Files.move(new File(DEST_FILE), new File(SOURCE_FILE));
		}
	}

	@Test
	public void testToString() throws IOException {
		final String expectString = "Today we will learn the guava io knowledge.\n" +
				                            "Please read the guava document or source code.\n" +
				                            "\n" +
				                            "The guava source code is very cleanly and nice.";
		List<String> list = Files.readLines(new File(SOURCE_FILE), Charsets.UTF_8);
		String fileString = Joiner.on("\n").join(list);
		assertThat(expectString.equals(fileString), equalTo(true));
	}

	@Test
	public void testProcessFile() throws IOException {
		LineProcessor<List<Integer>> lineProcessor = new LineProcessor<List<Integer>>() {
			private List<Integer> result = new ArrayList<>();
			@Override
			public boolean processLine(String line) throws IOException {
				int length = line.length();
				result.add(length);
				return true;
			}

			@Override
			public List<Integer> getResult() {
				return result;
			}
		};
		List<Integer> lines = Files.asCharSource(new File(SOURCE_FILE), Charsets.UTF_8).readLines(lineProcessor);
		System.out.println(lines);
	}

	@Test
	public void testFileMd5() throws IOException {
		File file = new File(SOURCE_FILE);
		HashCode hash = Files.asByteSource(file).hash(Hashing.sha256());
		System.out.println(hash);
	}

	@Test
	public void testFileWrite() throws IOException {
		File file = new File(WRITE_FILE);
		file.deleteOnExit();
		String content = "Test to write!";
		Files.write(content.getBytes(), file);
		String read = Files.asCharSource(file, Charsets.UTF_8).read();
		System.out.println(read);
	}

	@Test
	public void testFileAppend() throws IOException {
		File file = new File(WRITE_FILE);
		file.deleteOnExit();
		String content = "Test to write!Append content.";
		CharSink charSink = Files.asCharSink(file, Charsets.UTF_8, FileWriteMode.APPEND);
		charSink.write(content);
		String read = Files.asCharSource(file, Charsets.UTF_8).read();
		System.out.println(read);
	}

	@Test
	public void testTouchFile() throws IOException {
		File file = new File(TOUCH_FILE);
		file.deleteOnExit();
		Files.touch(file);
		assertThat(file.exists(), equalTo(true));
	}

	@Test
	public void testRecursive() {
		List<File> fileList = new ArrayList<>();
		recurseFile(new File("/Users/huangtao/IdeaProjects/algo/src/test"), fileList);
		fileList.forEach(System.out::println);
	}

	private void recurseFile(File root, List<File> fileList) {
		if (root.isHidden()) {
			return;
		}

		if (!root.isFile()) {
			File[] files = root.listFiles();
			for (File file : files) {
				recurseFile(file, fileList);
			}
		} else {
			fileList.add(root);
		}
	}

	@Test
	public void testTreeFiles() {
		List<File> fileList = new ArrayList<>();
		File root = new File("/Users/huangtao/IdeaProjects/algo/src/test");
		Iterable<File> files = Files.fileTraverser().depthFirstPreOrder(root);
		files.forEach(System.out::println);
	}

	@After
	public void tearDown() {
		File destFile = new File(DEST_FILE);
		if (destFile.exists()) {
			destFile.delete();
		}
	}


}
