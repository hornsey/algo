package com.hornsey.algo.course;

import java.util.Arrays;

/**
 * @Author hornsey
 * @create 2019/9/2 20:21
 */
public class C12Sort {

	/**
	 * 归并排序
	 * @param nums
	 */
	public static void mergeSort(int[] nums, int low, int high) {
		if (low >= high) {
			return ;
		}

		int mid = low + (high - low)/2;
		mergeSort(nums, low, mid);
		mergeSort(nums, mid+1, high);

		merge(nums, low, mid, high);
		return;
	}

	private static void merge(int[] nums, int low, int mid, int high) {

		int[] dest = new int[high-low+1];
		for (int i = low, j = low, k = mid+1; i <= high; i++) {
			if (k > high || (j <= mid && (nums[j] <= nums[k]))) {
				dest[i-low] = nums[j++];
			} else {
				dest[i-low] = nums[k++];
			}
		}

		for (int i = 0; i < dest.length; i++) {
			nums[low+i] = dest[i];
		}
	}

	/**
	 * 归并排序
	 * @param nums
	 */
	public static int[] mergeSort1(int[] nums, int left, int right) {
		if (left >= right) {
			return new int[]{nums[left]};
		}

		int mid = left + (right - left)/2;
		return merge1(mergeSort1(nums, left, mid), mergeSort1(nums, mid + 1, right));
	}

	private static int[] merge1(int[] nums1, int[] nums2) {

		int length1 = nums1.length;
		int length2 = nums2.length;
		int length = length1 + length2;
		int[] result = new int[length];

		for (int i = 0, j = 0, k = 0; k < length; k++) {
			if (j >= length2 || (i < length1 && nums1[i] <= nums2[j])) {
				result[k] = nums1[i++];
			} else {
				result[k] = nums2[j++];
			}
		}

//		int i = 0, j = 0, k = 0;
//		int tmp1 = nums1[i], tmp2 = nums2[j];
//		for (; k < length; k++) {
//			if (tmp1 <= tmp2) {
//				result[k] = tmp1;
//				if (++i < length1) {
//					tmp1 = nums1[i];
//				} else {
//					tmp1 = nums2[length2-1] + 1;
//				}
//			} else {
//				result[k] = tmp2;
//				if (++j < length2) {
//					tmp2 = nums2[j];
//				} else {
//					tmp2 = nums1[length1-1] + 1;
//				}
//			}
//		}
		return result;
	}


	private static int partition(int[] nums, int left, int right) {
		int pivot = nums[right];
		int tmp = 0;
		int j = left;
		for (int i = left; i < right; i++) {
			if (nums[i] < pivot) {
				tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
				j++;
			}
		}
		nums[right] = nums[j];
		nums[j] = pivot;

		return j;
	}

	/**
	 * 快速排序
	 * @param nums
	 * @param left
	 */
	public static void quickSort(int[] nums, int left, int right) {
		if (left >= right) {
			return;
		}

		int pivot = nums[right];
		int tmp = 0;
		int j = left;
		for (int i = left; i < right; i++) {
			if (nums[i] < pivot) {
				tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
				j++;
			}
		}
		nums[right] = nums[j];
		nums[j] = pivot;
		quickSort(nums, left, j-1);
		quickSort(nums, j+1, right);

	}

	public static void main(String[] args) {
		int[] nums = new int[]{1,3,2,8,4,6};
		System.out.println(Arrays.toString(nums));

//		int[] result = mergeSort1(nums, 0, nums.length-1);
//		System.out.println(Arrays.toString(result));

//		mergeSort(nums, 0, nums.length-1);
//		System.out.println(Arrays.toString(nums));

		quickSort(nums, 0, nums.length-1);
		System.out.println(Arrays.toString(nums));
	}
}
