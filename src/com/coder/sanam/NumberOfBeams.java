package com.coder.sanam;

public class NumberOfBeams {
	
	/**
	 * @param bank
	 * @return
	 */
	public static int numberOfBeams(String[] bank) {
		int[] countArr = new int[bank.length];
		int count = 0;
        for(int i=0;i<bank.length;i++){
        	System.out.println(countOnes(bank[i]));
        	if(countOnes(bank[i]) != 0) {
        		countArr[count] = countOnes(bank[i]);
        		count++;
        	}
        	
        }
        
        int result = 0;
        for(int i=0;i<countArr.length-1;i++) {
        	result += countArr[i] * countArr[i+1];
        }
        return result; 
    }

	private static int countOnes(String string) {
		int counter = 0;
		for(char s: string.toCharArray()) {
			if(s == '1') counter += 1;
		}
		return counter;
	}
	
	public static void main(String[] args) {
		int numberOfBeams = numberOfBeams(new String[] {"011001","000000","010100","001000"});
		System.out.println(numberOfBeams);
	}

}
