package com.hornsey.effectivejava.chapter7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author huangtao
 * @date 2020/6/16
 */
public class Anagrams {
	public static void main(String[] args) {
		new Anagrams().demo01();
	}

	private void demo01() {
		String path = "/Users/huangtao/IdeaProjects/algo/src/test/java/resources/io/source.txt";
		File dictionary = new File(path);
		int minGroupSize = 5;

		Map<String, Set<String>> groups = new HashMap<>();
		try (Scanner s = new Scanner(dictionary)) {
			while (s.hasNext()) {
				String word = s.next();
				groups.computeIfAbsent(alphabetize(word), (unused) -> new TreeSet<>()).add(word);
			}

			for (Map.Entry<String, Set<String>> entry : groups.entrySet()) {
				System.out.println(entry.getKey() +  ": " + entry.getValue());
			}
			System.out.println("===");

			for (Set<String> group : groups.values()) {
					System.out.println(group.size() + ": " + group);
//				if (group.size() >= minGroupSize) {
//				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private String alphabetize(String word) {
		char[] a = word.toCharArray();
		Arrays.sort(a);
		return new String(a);
	}

}
