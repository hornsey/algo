package com.hornsey.effectivejava.chapter11;


import com.hornsey.effectivejava.chapter4.ForwardingSet;

import java.util.ArrayList;
import java.util.Set;

/**
 * @author huangtao
 * @date 2020/7/22
 */
public class ObservableSet<E> extends ForwardingSet<E> {

	public ObservableSet(Set<E> s) {
		super(s);
	}

//	public final List<SetObserver<E>> observers = new ArrayList<>();
}
