package com.hornsey.algo.course;

/**
 * 动态规划算法
 * @Author hornsey
 * @create 2019/8/12 19:43
 */
public class C40DynamicPlan {

	/**
	 * 使用二维数组的额外空间
	 * @param weight 每个物品重量
	 * @param n 物品个数
	 * @param w 背包最大承重
	 * @return 可装物品最大重量
	 */
	public static int knapsack(int[] weight, int n, int w) {
		boolean[][] states = new boolean[n][w+1];
		states[0][0] = true;

		if (weight[0] < w) {
			states[0][weight[0]] = true;
		}

		for (int i = 1; i < n; i++) {
			//第i个物品不放入
			for (int j = 0; j <= w; j++) {
				if (states[i-1][j] = true) {
					states[i][j] = true;
				}
			}
			//第i个物品放入背包
			for (int j = 0; j <= w - weight[i]; j++) {
				if (states[i-1][j] = true) {
					states[i][j+weight[i]] = true;
				}
			}
		}

		for (int i = w; i >= 0; i--) {
			if (states[n-1][i] == true) {
				return i;
			}
		}

		return 0;
	}

	/**
	 * 使用一维数组的额外空间
	 * @param weight
	 * @param n
	 * @param w
	 * @return
	 */
	public static int knapsack2(int[] weight, int n , int w) {
		boolean[] states = new boolean[w + 1];
		states[0] = true;
		if (weight[0] < w) {
			states[weight[0]] = true;
		}

		for (int i = 1; i < n; i++) {
			for (int j = w-weight[i]; j>=0; j--) {
				if (states[j] == true) {
					states[j+weight[i]] = true;
				}
			}
		}

		for (int i = w; i >= 0; i--) {
			if (states[i] == true) {
				return i;
			}
		}

		return 0;
	}

	/**
	 * 使用二维数组的额外空间,并计算最大价值
	 * @param weight 每个物品重量
	 * @param value 每个物品价值
	 * @param n 物品个数
	 * @param w 背包最大承重
	 * @return 可装物品最大重量
	 */
	public static int knapsack3(int[] weight, int[] value, int n, int w) {
		int[][] states = new int[n][w+1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <=w; j++) {
				states[i][j] = -1;
			}
		}

		states[0][0] = 0;
		if (weight[0] < w) {
			states[0][weight[0]] = value[0];
		}

		for (int i = 1; i < n; i++) {
			//第i个物品不放入
			for (int j = 0; j <= w; j++) {
				if (states[i-1][j] >= 0) {
					states[i][j] = states[i-1][j];
				}
			}
			//第i个物品放入背包
			for (int j = 0; j <= w - weight[i]; j++) {
				if (states[i-1][j] >= 0) {
					int v = states[i-1][j] + value[i];
					if (v > states[i][j+weight[i]]) {
						states[i][j+weight[i]] = v;
					}
				}
			}
		}

		int maxValue = -1;
		for (int i = w; i >= 0; i--) {
			if (states[n-1][i] > maxValue) {
				maxValue = states[n-1][i];
			}
		}

		return maxValue;
	}

	public static void main(String[] args) {
		int[] weight = {2,2,4,8,3};
		int[] value = {3,4,8,9,6};
		int n = weight.length;
		int w = 9;
		int result = knapsack(weight, n, w);
		System.out.println("result = " + result);
		int result2 = knapsack3(weight, value, n, w);
		System.out.println("result2 = " + result2);
	}
}
