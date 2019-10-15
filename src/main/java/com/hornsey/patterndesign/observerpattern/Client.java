package com.hornsey.patterndesign.observerpattern;

/**
 * @Author hornsey
 * @create 2019/10/15 12:10
 */
public class Client {

	public static void main(String[] args) {
		RandomNumberGenerator generator = new RandomNumberGenerator(20);
		Observer observer1 = new DigitObserver();
		Observer observer2 = new AgeObserver();
		generator.addObserver(observer1);
		generator.addObserver(observer2);
		generator.execute();
	}
}
