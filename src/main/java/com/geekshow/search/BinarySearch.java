package com.geekshow.search;

public class BinarySearch {

	public static void main(String[] args) {
		// 给定数组
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		// 给定要查找的值
		int key = 0;

		// 进行折半二分查找
		int index = binarySearch(array, key);

		int index2 = binarySearch2(array, key, 0, array.length - 1);

		// 输出结果
		if (index2 == -1) {
			System.out.println("不存在");
		} else {
			System.out.println(key + "的索引是" + index);
		}
	}

	/**
	 * 使用递归
	 * 
	 * @param array
	 * @param key
	 * @param low
	 * @param high
	 * @return
	 */
	private static int binarySearch2(int[] array, int key, int low, int high) {
		if (low > high) {
			return -1;
		}
		int mid = (low + high) / 2;
		if (key == array[mid]) {
			return mid;
		} else if (key > array[mid]) {
			return binarySearch2(array, key, mid + 1, high);
		} else {
			return binarySearch2(array, key, low, mid - 1);
		}
	}

	private static int binarySearch(int[] array, int key) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (key == array[mid]) {
				return mid;
			} else if (key > array[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

}
