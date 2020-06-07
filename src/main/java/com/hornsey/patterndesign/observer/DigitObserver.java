package com.hornsey.patterndesign.observer;


/**
 * @Author hornsey
 * @create 2019/10/15 11:57
 */
public class DigitObserver implements Observer {
	@Override
	public void update(Object args) {
		System.out.println("Digit = " + args);
	}

}
