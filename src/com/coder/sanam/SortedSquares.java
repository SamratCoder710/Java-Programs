package com.coder.sanam;

import java.util.Arrays;

public class SortedSquares {
	
	public static int[] sortedSquares(int[] nums) {
		int [] squares = new int[nums.length];
        for(int i=0;i<nums.length ;i++) {
        	squares[i] = nums[i]*nums[i];
        }
        Arrays.sort(squares);
        return squares;
    }
	
	public static void main(String[] args) {
		int[] sortedSquares = sortedSquares(new int[] {-4,-1,0,3,10});
		for(int square : sortedSquares) {
			System.out.println(square);
		}
		
	}

}
