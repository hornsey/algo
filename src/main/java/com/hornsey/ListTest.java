package com.hornsey;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangtao
 * @date 2020/7/22
 */
public class ListTest {

	public static void main(String[] args) {
		ListTest test = new ListTest();
		test.test01();
	}

	void test01() {
		List<Integer> list = Lists.newArrayList(1,2,3);
		ArrayList newList = new ArrayList<Integer>(list) {
			{
				remove(2);
				add(5);
			}
		};

		System.out.println(newList);
	}
}
