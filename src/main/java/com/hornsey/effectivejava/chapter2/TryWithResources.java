package com.hornsey.effectivejava.chapter2;

import java.io.*;

/**
 * @author huangtao
 * @date 2020/6/23
 */
public class TryWithResources {
	public static void main(String[] args) {
		try {
			new TryWithResources().test2();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	void test1() throws IOException {
		String path1 = "/Users/huangtao/IdeaProjects/algo/src/test/java/resources/io/source.txt";

		try(BufferedReader reader = new BufferedReader(new FileReader(path1))) {
			String line;
			System.out.println("<===>");
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			System.out.println("<===>");
		}
	}

	void test2() throws IOException {
		String path1 = "/Users/huangtao/IdeaProjects/algo/src/test/java/resources/io/source.txt";
		String path2 = "/Users/huangtao/IdeaProjects/algo/src/test/java/resources/io/touch.txt";

		try(InputStream in = new FileInputStream(path1);
		    OutputStream out = new FileOutputStream(path2)) {
			System.out.println("<===>");
			byte[] buffer = new byte[2048];
			int n;
			while ((n = in.read(buffer)) >=0) {
				out.write(buffer, 0, n);
			}
			System.out.println("<===>");
		}
	}


}
