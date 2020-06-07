package com.hornsey.patterndesign.observer;

/**
 * @Author hornsey
 * @create 2019/10/15 12:06
 */
public class AgeObserver implements Observer {
	@Override
	public void update(Object args) {
		System.out.println("Age = " + (Integer)args);
	}
}
