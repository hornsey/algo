package com.hornsey.algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author hornsey
 * @create 2019/8/26 15:53
 */
public class Q17Solution {
	Map<Character, String> charMap = new HashMap<Character, String>(8);

	public List<String> letterCombinations(String digits) {

		initMap();

		List<String> result = new ArrayList<String>();
		List<String> list = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		int length = digits.length();
		for (int i = 0; i < length; i++) {
			char c = digits.charAt(i);
			String chars = charMap.get(Character.valueOf(c));
			if (list.size() == 0) {
				for (int j = 0, l = chars.length(); j < l; j++) {
					list2.add(String.valueOf(chars.charAt(j)));
				}
			} else {
				for (String str : list) {
					for (int j = 0, l = chars.length(); j < l; j++) {
						list2.add(str + chars.charAt(j));
					}
				}
			}
			list.clear();
			list.addAll(list2);
			list2 = new ArrayList<String>();
		}

		for (String str : list) {
			result.add(str);
		}

		return result;
	}

	private void initMap() {
		charMap.put('2', "abc");
		charMap.put('3', "def");
		charMap.put('4', "ghi");
		charMap.put('5', "jkl");
		charMap.put('6', "mno");
		charMap.put('7', "pqrs");
		charMap.put('8', "tuv");
		charMap.put('9', "wxyz");
	}

	public static void main(String[] args) {
		String digits = "235";
		List<String> result = new Q17Solution().letterCombinations(digits);
		System.out.println(result);
	}

}
