package com.coder.sanam;

import java.util.ArrayList;

public class LinearSearchRecursion {

	
	static ArrayList<Integer> findAllIndex(int[] arr,int target, int i,ArrayList<Integer> list) {
		if(i == arr.length) {
			return list;
		}
		if(arr[i] == target) {
			list.add(i);
		}
		return findAllIndex(arr,target,i+1,list);
		 
	}
	
	static ArrayList<Integer> findAllIndex2(int[] arr,int target, int i) {
		ArrayList<Integer> list = new ArrayList<>();
		if(i == arr.length) {
			return list;
		}
		if(arr[i] == target) {
			list.add(i);
		}
		ArrayList<Integer> ans = findAllIndex2(arr,target,i+1);
		list.addAll(ans);
		return list;
		 
	}
	
	public static void main(String[] args) {
		int[] eleArr = {1,2,1,9,8,10,12,76,23,445,8,10,10,1,10};
		int target = 10;
		//System.out.println(searchIndex(eleArr,target,0));
		ArrayList<Integer> allIndexArray = findAllIndex2(eleArr,target,0 );
		System.out.println(allIndexArray);
		
	}

	static boolean search(int[] arr,int target, int i) {
		if(i == arr.length) {
			return false;
		}
		return (arr[i] == target) || search(arr,target,i+1);
		 
	}
	
	static int searchIndex(int[] arr,int target, int i) {
		if(i == arr.length) {
			return -1;
		}
		if(arr[i] == target) {
			return i;
		}
		return searchIndex(arr,target,i+1);
		 
	}
	
	static int searchLastIndex(int[] arr,int target, int i) {
		if(i == -1) {
			return -1;
		}
		if(arr[i] == target) {
			return i;
		}
		return searchIndex(arr,target,i-1);
		 
	}
	
}
