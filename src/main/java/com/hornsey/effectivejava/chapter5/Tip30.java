package com.hornsey.effectivejava.chapter5;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;

/**
 * @author huangtao
 * @date 2020/7/16
 */
public class Tip30 {

	public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
		Set<E> result = new HashSet<>(s1);
		result.addAll(s2);
		return result;
	}

	public static void main(String[] args) {
		Set<String> s1 = Sets.newHashSet("Tom", "Jack");
		Set<String> s2 = Sets.newHashSet("Lily", "Anna");
		Set<String> res = union(s1, s2);
		System.out.println(res);
	}
}
