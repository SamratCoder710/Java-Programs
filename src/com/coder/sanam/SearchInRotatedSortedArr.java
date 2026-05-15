package com.coder.sanam;

public class SearchInRotatedSortedArr {


    public static void main(String[] args) {
        SearchInRotatedSortedArr searchInRotatedSortedArr = new SearchInRotatedSortedArr();
        int resIdx = searchInRotatedSortedArr.search(new int[]{4,5,6,7,0,1,2}, 0);
        System.out.println(resIdx);

    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        while(l<=r){
            int mid = l +(r-l)/2;
            if(nums[mid] == target) return mid;

            if(nums[l] <= nums[mid]){
                //left side sorted
                if(target >= nums[l] && target < nums[mid]){
                    r = mid -1;
                }else{
                    l = mid +1;
                }
            }else{
                //right side sorted
                if(target <= nums[r] && target > nums[mid]){
                    l = mid +1;
                }else{
                    r = mid -1;
                }
            }
        }
        return -1;
    }
}
