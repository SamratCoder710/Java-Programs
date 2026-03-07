package com.coder.sanam;

public class MinOpsToMakeArrayAlternating {

    public static void main(String[] args) {
        MinOpsToMakeArrayAlternating minOpsToMakeArrayAlternating = new MinOpsToMakeArrayAlternating();
        int i = minOpsToMakeArrayAlternating.minimumOperations(new int[]{3, 1, 3, 2, 4, 1});
        System.out.println(i);
    }


    public int minimumOperations(int[] nums) {
        int[] arr1 = new int[1000001]; // even
        int[] arr2 = new int[1000001]; // odd
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr1[nums[i]]++;
            } else {
                arr2[nums[i]]++;
            }
        }

        int evenMax = 0;
        int evenSecondMax = 0;

        int evenMaxNum = 0;
        int evenSecondMaxNum = 0;

        int oddMax = 0;
        int oddSecondMax = 0;

        int oddMaxNum = 0;
        int oddSecondMaxNum = 0;


        for (int i = 0; i < arr1.length; i++) {
            int num = arr1[i];
            if (num > evenMax) {
                evenSecondMax = evenMax;
                evenSecondMaxNum = evenMaxNum;

                evenMax = num;
                evenMaxNum = i;
            } else if (num > evenSecondMax) {
                evenSecondMax = num;
                evenSecondMaxNum = i;
            }

            int num2 = arr2[i];
            if (num2 > oddMax) {
                oddSecondMax = oddMax;
                oddSecondMaxNum = oddMaxNum;

                oddMax = num2;
                oddMaxNum = i;
            } else if (num2 > oddSecondMax) {
                oddSecondMax = num2;
                oddSecondMaxNum = i;
            }
        }

        System.out.println(evenMax + " :: " + evenSecondMax);
        System.out.println(evenMaxNum + " :: " + evenSecondMaxNum);
        System.out.println("<<<<<>>>>>>>");
        System.out.println(oddMax + " :: " + oddSecondMax);
        System.out.println(oddMaxNum + " :: " + oddSecondMaxNum);

        if (evenMaxNum != oddMaxNum) {
            return n - evenMax - oddMax;
        }

        return Math.min(n - oddMax - evenSecondMax, n - oddSecondMax - evenMax);

    }


}
