package com.hornsey.guava.io;

import com.google.common.base.Strings;

/**
 * @Author huangtao
 * @create 2020/5/5
 */
public class Base64 {
	private static final String CODE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567890+/";
	private static final char[] CODE_BYTE = CODE.toCharArray();

	private void Base64() {
	}

	public static String encode(String plain) {
		StringBuilder result = new StringBuilder();

		String binary = toBinary(plain);
		int padLen = 0;
		if (binary.length() % 6 == 0) {
			padLen = 0;
		} else {
			padLen = 6 - binary.length() % 6;
		}
		int newLen = binary.length() + padLen;
		if (padLen > 0) {
			binary = Strings.padEnd(binary, newLen, '0');
		}

		for (int i = 0; i < newLen; i=i+6) {
			Integer value = Integer.valueOf(binary.substring(i, i + 6), 2);
			result.append(CODE_BYTE[value]);
		}
		while (padLen>0) {
			result.append("=");
			padLen -= 2;
		}

		return result.toString();
	}

	private static String toBinary(String plain) {
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < plain.length(); i++) {
			String binary = Integer.toBinaryString(plain.charAt(i));
			result.append(Strings.padStart(binary, 8, '0'));
		}
		return result.toString();
	}
}
