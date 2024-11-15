package com.coder.sanam;

import java.util.HashMap;
import java.util.Map;

public class NoOfSubmatricesThatSumToTarget {
	
	public static int numSubmatrixSumTargetBruteForce(int[][] matrix, int target) {
		int rowLength = matrix.length;
		int colLength = matrix[0].length;
		int result = 0;
        for(int s_r = 0;s_r<rowLength;s_r++) {
        	for(int s_c = 0; s_c<colLength;s_c++) {
        		for(int e_r = s_r;e_r <rowLength;e_r++) {
        			for(int e_c = s_c;e_c<colLength;e_c++) {
        				int sum = 0;
        				for(int r = s_r;r<=e_r;r++) {
        					for(int c= s_c;c<= e_c;c++) {
        						sum += matrix[r][c];
        					}
        				}
        				if(sum == target) {
        					result++;
        				}
        			}
        		}
        	}
        }
        
        return result;
    }
	
	// Cummulative Row Sum
	public static int numSubmatrixSumTarget(int[][] matrix, int target) {
		int rowLength = matrix.length;
		int colLength = matrix[0].length;
		
		for(int row = 0;row<rowLength;row++) {
			for(int col = 1;col<colLength;col++) {
				matrix[row][col] += matrix[row][col-1]; 
			}
		}
		
		int result = 0;
		
		//check downwards for the sum of submatrices
		for(int s_c = 0;s_c< colLength;s_c++) {
			
			for(int j = s_c; j< colLength;j++) {
				Map<Integer,Integer> map = new HashMap<>();
				map.put(0, 1);
				int cummSum = 0;
				for(int row = 0;row<rowLength ; row++) {
					cummSum +=  matrix[row][j] - (s_c>0 ? matrix[row][s_c-1]:0);
					if(map.containsKey(cummSum - target)) {
						result += map.get(cummSum-target);
					}
					map.put(cummSum, map.getOrDefault(cummSum, 0)+ 1);
				}
				
				
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[][] input = {
				{1,-1},{-1,1}
		};
		
		int numSubmatrixSumTarget = numSubmatrixSumTarget(input, 0);
		System.out.println(numSubmatrixSumTarget);
		
	}

}
