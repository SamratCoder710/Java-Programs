package com.coder.sanam;

public class RotateImage {
	public static void rotate(int[][] matrix) {
			int left = 0,right = matrix.length -1;
			while(left<right) {
				for(int i=0;i<right-left;i++) {
					int top=left,bottom = right;
					int topLeft = matrix[top][left +i];
					matrix[top][left +i] = matrix[bottom-i][left];
					matrix[bottom-i][left] = matrix[bottom][right-i];
					matrix[bottom][right-i] = matrix[top+i][right];
					matrix[top+i][right]= topLeft;
				}
				left +=1;
				right -= 1;
			}
		}
	
	public static void main(String[] args) {
		int[][] board = {
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}
        };
		rotate(board);
	}
}
