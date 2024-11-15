package com.coder.sanam;

public class ContainerWithMostWater {
	
	public int maxArea(int[] height) {
        int largestArea = 0;
        int left = 0, right = height.length-1;
        int area = 0;
        while(left<=right){
            area = (right-left) * Math.min(height[right],height[left]);
            if(area > largestArea){
                largestArea = area;
            }
            if(height[right] > height[left]){
                left++;
            }else if(height[right] < height[left]){
                right--;
            }
        }
        return largestArea;
    }

}
