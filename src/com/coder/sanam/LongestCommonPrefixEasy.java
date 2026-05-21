package com.coder.sanam;

import java.util.Arrays;

public class LongestCommonPrefixEasy {

    public static void main(String[] args) {
        LongestCommonPrefixEasy longestCommonPrefixEasy = new LongestCommonPrefixEasy();
        String result = longestCommonPrefixEasy.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        System.out.println(result);
    }


    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return sb.toString();
            }
            sb.append(first.charAt(i));
        }

        return sb.toString();
    }

}
