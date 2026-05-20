package com.coder.sanam;

public class FindPrefixCommonArrOfTwoArr {

    public static void main(String[] args) {
        FindPrefixCommonArrOfTwoArr findPrefixCommonArrOfTwoArr = new FindPrefixCommonArrOfTwoArr();
        int[] result = findPrefixCommonArrOfTwoArr.findThePrefixCommonArray(new int[]{1, 3, 2}, new int[]{2, 1, 3});
        for (int num : result) {
            System.out.print(num + " ");
        }
    }


    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] freq = new int[n];
        int[] result = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] == B[i]) {
                count++;
            } else {
                freq[A[i] - 1]++;
                freq[B[i] - 1]++;

                if (freq[A[i] - 1] == 2) {
                    count++;
                }
                if (freq[B[i] - 1] == 2) {
                    count++;
                }
            }

            result[i] = count;
        }

        return result;
    }

}
