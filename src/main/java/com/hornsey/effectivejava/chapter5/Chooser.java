package com.hornsey.effectivejava.chapter5;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author huangtao
 * @date 2020/7/13
 */
public class Chooser<T> {
	private List<T> choiceArray;

	public Chooser(Collection<T> choices) {
		this.choiceArray = new ArrayList<>(choices);
	}

	public T choose() {
		Random random = ThreadLocalRandom.current();
		return choiceArray.get(random.nextInt(choiceArray.size()));
	}

	public static void main(String[] args) {
		List<Integer> list = Lists.newArrayList(1,2,3);
		Integer choose = new Chooser<>(list).choose();
		System.out.println(choose);
	}
}
