package com.hornsey.effectivejava.chapter5;

import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author huangtao
 * @date 2020/7/13
 */
public class Chooser {
	private Object[] choiceArray;

	public Chooser(Collection choices) {
		this.choiceArray = choices.toArray();
	}

	public Object choose() {
		Random random = ThreadLocalRandom.current();
		return choiceArray[random.nextInt(choiceArray.length)];
	}

	public static void main(String[] args) {
		List<Integer> list = Lists.newArrayList(1,2,3);
		System.out.println(new Chooser(list).choose());
	}
}
