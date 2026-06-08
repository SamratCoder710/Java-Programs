package com.coder.sanam;

public class PartitionArrayAccordingToGivenPivot {

    public static void main(String[] args) {
        PartitionArrayAccordingToGivenPivot partitionArrayAccordingToGivenPivot = new PartitionArrayAccordingToGivenPivot();
        int[] result = partitionArrayAccordingToGivenPivot.pivotArray(new int[]{9, 12, 5, 10, 14, 3, 10}, 10);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int numsEqualToPivot = 0;
        int numsGreaterThanPivot = 0;
        int[] res = new int[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == pivot) {
                numsEqualToPivot++;
            } else if (nums[i] < pivot) {
                res[idx++] = nums[i];
            }
        }

        for (int i = 0; i < numsEqualToPivot; i++) {
            res[idx++] = pivot;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > pivot) {
                res[idx++] = nums[i];
            }
        }

        return res;
    }
}
