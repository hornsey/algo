package com.hornsey.effectivejava.chapter6;

import java.util.EnumSet;
import java.util.Set;

/**
 * @author huangtao
 * @date 2020/6/7
 */
public class Text {
	public enum Style {BOLD, ITALIC, UNDERLINE, STRIKETHOUGH};

	public void appleStyle(Set<Style> styles) {
		for (Style style : styles) {
			System.out.println(style.ordinal());
		}
	}

	public static void main(String[] args) {
		Text text = new Text();
		text.appleStyle(EnumSet.of(Style.BOLD, Style.UNDERLINE));
	}
}
