package com.hornsey.stream;

import org.apache.commons.collections.MapUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author huangtao
 * @date 2020/6/18
 */
public class Stream4 {
	private List<Student> students;

	@Before
	public void before() {
		Student student0 = new Student("Jack", "北京大学", "男", 20, 98);
		Student student1 = new Student("Jack1", "复旦大学", "男", 22, 98);
		Student student2 = new Student("Jack2", "清华大学", "女", 21, 90);
		Student student3 = new Student("Jack3", "清华大学", "男", 24, 98);
		Student student4 = new Student("Jack4", "北京大学", "女", 23, 98);
		Student student5 = new Student("Jack5", "复旦大学", "男", 22, 98);
		Student student6 = new Student("Jack6", "清华大学", "女", 22, 93);
		Student student7 = new Student("Jack7", "北京大学", "女", 20, 98);
		Student student8 = new Student("Jack8", "清华大学", "男", 23, 92);
		Student student9 = new Student("Jack9", "复旦大学", "男", 22, 97);

		students = Arrays.asList(student0,student1,student2,student3,student4,student5,
				student6,student7,student8,student9);
	}

	@Test
	public void test01() {
		Set<String> collect = students.stream().map(Student::getSchool).collect(Collectors.toSet());
		System.out.println(collect);
	}

	@Test
	public void test02() {
		Map<String, List<Student>> collect = students.stream().collect(Collectors.groupingBy(Student::getSchool));
//		System.out.println(collect);

		MapUtils.verbosePrint(System.out, "School", collect);
	}

	@Test
	public void test03() {
		Map<Boolean, Long> collect = students.stream().collect(Collectors.partitioningBy(s -> s.getGender().equals("男"), Collectors.counting()));

		MapUtils.verbosePrint(System.out, "Gender", collect);
	}

	@Test
	public void test04() {
		Map<Boolean, List<Student>> collect = students.stream().collect(Collectors.partitioningBy(s -> s.getScore() > 95));

		MapUtils.verbosePrint(System.out, "95成绩", collect);
	}

	@Test
	public void test05() {
		Map<Boolean, Double> collect = students.stream()
				                               .collect(Collectors.partitioningBy(s -> s.getScore() > 95, Collectors.averagingDouble(Student::getScore)));

		MapUtils.verbosePrint(System.out, "95成绩", collect);
	}

	@Test
	public void test06() {
		Map<Boolean, Double> collect = students.stream().collect(Collectors.groupingBy(s -> s.getScore() > 95,
				Collectors.averagingDouble(Student::getScore)));

		MapUtils.verbosePrint(System.out, "95成绩", collect);
	}

	@Test
	public void test07() {
		DoubleSummaryStatistics collect = students.stream().collect(Collectors.summarizingDouble(Student::getScore));

		System.out.println(collect);
	}

	@Test
	public void test08() {
		students.parallelStream()
				.forEach(student -> {
					if (student.getScore() < 95) {
						return;
					}
					System.out.println(student);
				});
	}


	@Test
	public void test() {
		Student student = new Student();
		System.out.println(student);
	}






}
