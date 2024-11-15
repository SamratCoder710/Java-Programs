package com.coder.sanam;

public class GasStation {
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int gasSum = 0;
		int costSum = 0;
		for(int i=0;i<gas.length;i++) {
			gasSum += gas[i];
			costSum += cost[i];
		}
		if(gasSum < costSum) return -1;
		
		int total = 0;
		int res = 0;
		for(int i=0 ;i<gas.length;i++) {
			total += (gas[i] - cost[i]);
			if(total<0) {
				total = 0;
				res = i+1;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int canCompleteCircuit = canCompleteCircuit(new int[] {2,3,4}, new int[] {3,4,3});
		System.out.println(canCompleteCircuit);
	}

}
