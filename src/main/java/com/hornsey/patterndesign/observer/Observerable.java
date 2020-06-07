package com.hornsey.patterndesign.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author hornsey
 * @create 2019/10/15 11:51
 */
public class Observerable {
	List<Observer> observers = new ArrayList<Observer>();

	public void addObserver(Observer observer) {
		if (!observers.contains(observer)) {
			observers.add(observer);
		}
	}

	public void removeObserver(Observer observer) {
		if (observers.contains(observer)) {
			observers.remove(observer);
		}
	}

	public void notifyObserver(Object args) {
		for (Observer observer : observers) {
			observer.update(args);
		}
	}
}
