package com.hornsey.effectivejava.chapter6;

/**
 * @author  huangtao
 * @date  2020/6/6
 */
public enum Operation {

	/**
	 *
	 */
	PLUS("+") {
		@Override
		public double apple(double x, double y) {
			return x + y;
		}
	},
	MINUS("-") {
		@Override
		public double apple(double x, double y) {
			return x - y;
		}
	},
	TIMES("*") {
		@Override
		public double apple(double x, double y) {
			return x - y;
		}
	},
	DIVIDE("/") {
		@Override
		public double apple(double x, double y) {
			return x / y;
		}
	},
	;

	private final String symbol;


	Operation(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}

	public abstract double apple(double x, double y);

	public static void main(String[] args) {
		double x = 4.0;
		double y = 2.0;
		for (Operation op : Operation.values()) {
			System.out.println(String.format("%1$f %2$s %3$f =  %4$f", x, op, y, op.apple(x,y)));
		}
	}
}
