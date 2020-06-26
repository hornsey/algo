package com.hornsey.effectivejava.chapter2;

import java.util.Objects;

/**
 * @author huangtao
 * @date 2020/6/9
 */
public class Calzone extends Pizza {
	private final boolean sauceInside;

	public static class Builder extends Pizza.Builder<Builder> {
		private boolean sauceInside = false;

		public Builder sauceInside() {
			this.sauceInside = true;
			return this;
		}

		@Override
		Calzone build() {
			return new Calzone(this);
		}

		@Override
		protected Builder self() {
			return this;
		}
	}

	private Calzone(Builder builder) {
		super(builder);
		sauceInside = builder.sauceInside;
	}

	public static void main(String[] args) {
		NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL)
				.addTopping(Topping.SAUSAGE).addTopping(Topping.ONION).build();
		System.out.println(nyPizza.toString());
	}
}
