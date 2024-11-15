package com.coder.sanam;

public class BS {

	static int search(int[] arr, int target, int s, int e) {
		if (s > e) {
			return -1;
		}
		int m = s + (e - s) / 2;
		if (arr[m] == target) {
			return m;
		}
		if (arr[m] > target) {
			return search(arr, target, s, m - 1);
		}
		return search(arr, target, m + 1, e);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 6, 8, 9, 13, 35, 66, 78, 91 };
		int target = 13;
		int res = search(arr, target, 0, arr.length - 1);
		System.out.println(res);
	}

}
