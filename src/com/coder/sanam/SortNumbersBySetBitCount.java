package com.coder.sanam;

import java.util.Arrays;
import java.util.List;

public class SortNumbersBySetBitCount {

    public static void main(String[] args) {
        SortNumbersBySetBitCount sortNumbersBySetBitCount = new SortNumbersBySetBitCount();
        int [] res = sortNumbersBySetBitCount.sortByBits(new int[]{0,1,2,3,4,5,6,7,8});
        String result = Arrays.toString(res);
        System.out.println(result);

    }

    public int[] sortByBits(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().sorted((a, b) -> {
            int aCount = Integer.bitCount(a);
            int bCount = Integer.bitCount(b);

            if (aCount != bCount) {
                return aCount - bCount;
            }
            return (a - b);
        }).toList();

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
