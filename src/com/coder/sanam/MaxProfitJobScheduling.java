package com.coder.sanam;

import java.util.Arrays;
import java.util.TreeMap;

public class MaxProfitJobScheduling {
	public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		int n = startTime.length;
		int[][] jobs = new int[n][3];
		for(int i=0;i<n;i++) {
			jobs[i] = new int[] {startTime[i],endTime[i],profit[i]};
		}
		Arrays.sort(jobs,(a,b) -> a[1]-b[1]);
		
		TreeMap<Integer,Integer> dp = new TreeMap<>();
		dp.put(0,0);
		for(int[] job:jobs) {
			int value = job[2] + dp.floorEntry(job[0]).getValue();
			if(value >dp.lastEntry().getValue()) {
				dp.put(job[1], value);
			}
		}
		
		return dp.lastEntry().getValue();
    }
	
	public static void main(String[] args) {
		
		int jobScheduling = jobScheduling(new int[] {1,2,3,4,6}, new int[] {3,5,10,6,9}, new int[] {20,20,100,70,60});
		System.out.println(jobScheduling);
	}
}
