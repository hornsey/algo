package com.hornsey.concurrent.jksjwbl;

import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/**
 * @author huangtao
 * @date 2020/7/19
 */
public class C07Test {
	private long count = 0;
	private synchronized long get(){
		return count;
	}
	private synchronized void set(long v){
		count = v;
	}
	private void add10K() {
		int idx = 0;
		while(idx++ < 10000) {
			set(get()+1);
//			count = count + 1;
		}
	}

	public static void main(String[] args) {
		C07Test test = new C07Test();
		CountDownLatch latch = new CountDownLatch(2);
		new Thread(() -> {
			test.add10K();
			latch.countDown();
		}).start();
		new Thread(() -> {
			test.add10K();
			latch.countDown();
		}).start();
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(test.get());

//		Vector<Integer> vector = new Vector<>();
//		vector.contains(1);
	}
}