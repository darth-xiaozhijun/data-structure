package com.geekshow.search;

public class FindIndex {

	public static void main(String[] args) {
		// 给定分数数组
		int[] scoreArr = { 89, 45, 78, 45, 100, 98, 86, 100, 65 };

		// 给定要查找的分数
		int score = 65;

		// 完成查找
		int index = search(scoreArr, score);

		// 输出结果
		if (index == -1) {
			System.out.println("该分数不存在");
		} else {
			System.out.println(score + "的索引是" + index);
		}

	}

	public static int search(int[] arr, int key) {
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				index = i;
				break;
			}
		}
		return index;
	}
}
