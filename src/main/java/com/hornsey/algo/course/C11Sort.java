package com.hornsey.algo.course;

import java.util.Arrays;

/**
 * @Author hornsey
 * @create 2019/9/2 20:21
 */
public class C11Sort {

	/**
	 * 冒泡排序
	 * 遍历数组，每次比较当前值与后一个值，将较大值交换到后面
	 * @param nums
	 * @param n
	 */
	public static void bubbleSort(int[] nums, int n) {
		if (n < 1) {
			return;
		}

		int tmp = 0;
		for (int i = 0; i < n; i++) {
			// 是否存在数据交换标志
			boolean flag = false;
			for (int j = 0; j < n-i-1; j++) {
				if (nums[j] > nums[j+1]) {
					tmp = nums[j+1];
					nums[j+1] = nums[j];
					nums[j] = tmp;
					flag = true;
				}
			}

			if (!flag) {
				return;
			}
		}
	}

	/**
	 * 插入排序
	 * 将数组分为已排序和待排序两部分，每次从待排序中找出一个插入到已排序中正确位置
	 * @param nums
	 * @param n
	 */
	public static void insertionSort(int[] nums, int n) {
		if (n < 1) {
			return;
		}

		for (int i = 1; i < n; i++) {
			int tmp = nums[i];
			int j = i-1;
			for (; j >= 0; j--) {
				if (nums[j] > tmp) {
					nums[j+1] = nums[j];
				} else {
					break;
				}
			}
			nums[j+1] = tmp;
		}
	}

	/**
	 * 选择排序
	 * 每次选择出最小值
	 * @param nums
	 * @param n
	 */
	public static void selectionSort(int[] nums, int n) {
		if (n < 1) {
			return;
		}


		for (int i = 0; i < n; i++) {
			int tmp = nums[i];
			int index = i;
			int j = i+1;
			for (; j < n; j++) {
				if (nums[j] < tmp) {
					tmp = nums[j];
					index = j;
				}
			}
			nums[index] = nums[i];
			nums[i] = tmp;
		}
	}


	public static void main(String[] args) {
		int[] nums = new int[]{5,1,3,9,7,2,8,4,6};
		System.out.println(Arrays.toString(nums));

//		bubbleSort(nums, nums.length);
//		insertionSort(nums, nums.length);
		selectionSort(nums, nums.length);
		System.out.println(Arrays.toString(nums));
	}
}
