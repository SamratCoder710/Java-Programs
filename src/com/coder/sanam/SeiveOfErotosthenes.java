package com.coder.sanam;

import java.util.Arrays;

public class SeiveOfErotosthenes {
	
	public static int countPrimes(int n) {
         if(n<=1){
            return 0;
        }
        boolean[] primeArr = new boolean[n];
        for(int i=2;i<Math.sqrt(n);i++){
            if(primeArr[i]==false){
                for(int k=i*i;k<n;k=k+i){
                    primeArr[k]= true;
                }
            }
        }
        int noOfPrimes = 0;
        for(int i=2;i<primeArr.length;i++){
            if(primeArr[i]==false){
                noOfPrimes++;
            }
        }
        return noOfPrimes;
    }
	
	public static void main(String[] args) {
		int countPrimes = countPrimes(3);
		System.out.println(countPrimes);
	}

}
