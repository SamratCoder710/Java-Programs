package com.coder.sanam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
	public static int[][] merge(int[][] arr) {
        List<Integer> a=new ArrayList<>();
        Arrays.sort(arr, (c, b) -> Integer.compare(c[0], b[0]));
        a.add(arr[0][0]);
        a.add(arr[0][1]);
        for(int i=1;i<arr.length;i++){
            if(a.get(a.size()-1)<arr[i][0]){
                a.add(arr[i][0]);
                a.add(arr[i][1]);
            }else if(a.get(a.size()-1)<arr[i][1]){
                a.set(a.size()-1,arr[i][1]);
            }
        }
        int ans[][]=new int[a.size()/2][2];
        int k=0;
        for(int i=0;i<ans.length;i++){
            ans[i][0]=a.get(k++);
            ans[i][1]=a.get(k++);
        }
        return ans;
    }
	
	
	
	public static void main(String[] args) {
		int [][] arr = {
				{1,4},{4,5}
		};
		
		 int[][] merge = merge(arr);
		
		for(int[] a: merge) {
			for(int x:a) {
				System.out.print(x+"::");
			}
			System.out.println();
		}
		
	}
}
