package com.coder.sanam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fibonacci {

	static Map<Integer, Integer> fibonacciMap = new HashMap<>();

	static int fibonacci(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int d ;
		if (fibonacciMap.get(n - 2) == null) {
			d = fibonacci(n - 2);
			fibonacciMap.put(n - 2, d);
		} else {
			d = fibonacciMap.get(n - 2);
		}
		
		int m;
		if (fibonacciMap.get(n - 1) == null) {
			m = fibonacci(n - 1);
			fibonacciMap.put(n - 1, m);
		} else {
			m = fibonacciMap.get(n - 1);
		}
		return  d+m;
		
		
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = fibonacci(50);
		System.out.println(k);
		scanner.close();
	}

}
