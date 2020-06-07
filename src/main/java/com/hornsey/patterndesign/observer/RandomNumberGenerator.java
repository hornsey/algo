package com.hornsey.patterndesign.observer;

import java.util.Random;

/**
 * @Author hornsey
 * @create 2019/10/15 11:58
 */
public class RandomNumberGenerator extends Observerable {
	private Random random = new Random();;
	private int value;
	private int limit;

	public RandomNumberGenerator(int limit) {
		this.limit = limit;
	}

	public int getValue() {
		return value;
	}

	public void execute() {
		for (int i = 0; i < 10; i++) {
			value = random.nextInt(limit);
			System.out.println("Generate new value : " + value);
			notifyObserver(getValue());
		}
	}
}
