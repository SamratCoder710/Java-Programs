package com.coder.sanam;

public class Pattern {

	public static void main(String[] args) {
		//printPattern1();
		recursionPrintPattern2(4,0);	
		
	}
// Pattern 2
//   *
//   **
//   ***
//   ****
	
	private static void recursionPrintPattern2(int row,int column) {
		if(row == 0) {
			return;
		}
		if(row <= column ) {
			recursionPrintPattern2(row-1, 0);
			System.out.print("\n");
		}else {
			recursionPrintPattern2(row, column + 1);
			System.out.print("*");
		}
		
	}
	
	
//	Pattern 1
//	
//	****
//	***
//	**
//	*
	private static void recursionPrintPattern1(int row,int column) {
		if(row == 0) {
			return;
		}
		if(row <= column ) {
			System.out.print("\n");
			recursionPrintPattern1(row-1, 0);
		}else {
			System.out.print("*");
			recursionPrintPattern1(row, column + 1);
		}
		
	}
	
	static void printPattern1(){
		for(int j=4;j>=0;j--) {
			String s = "*";
			System.out.println(s.repeat(j));
		}
	}
	
	
	
}
