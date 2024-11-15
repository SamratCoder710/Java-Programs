package com.coder.sanam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
	
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> triangle = new ArrayList<>() ;
		List<Integer> first_row = new ArrayList<>() ;
		first_row.add(1);
		triangle.add(first_row);
		
		for(int i=1;i< numRows;i++) {
			List<Integer> prev_row = triangle.get(i-1);
			List<Integer> row = new ArrayList<>();
			row.add(1);
			for(int j=0;j<i-1;j++) {
				row.add(prev_row.get(j)+prev_row.get(j+1));
			}
			row.add(1);
			triangle.add(row);
		}
		return triangle;
    
	}
	
	public static void main(String[] args) {
		List<List<Integer>> generateResult = generate(6);
		System.out.println(generateResult);
	}

}
