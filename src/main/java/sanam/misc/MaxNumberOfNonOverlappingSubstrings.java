package sanam.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxNumberOfNonOverlappingSubstrings {

    static void main() {
        MaxNumberOfNonOverlappingSubstrings maxNumberOfNonOverlappingSubstrings = new MaxNumberOfNonOverlappingSubstrings();
        List<String> result = maxNumberOfNonOverlappingSubstrings.maxNumOfSubstrings("adefaddaccc");
        System.out.println(result);
    }

    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] startIdx = new int[26];
        int[] endIdx = new int[26];
        Arrays.fill(startIdx, -1);
        boolean[] isInvalid = new boolean[26];

        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            if (startIdx[ch] == -1) {
                startIdx[ch] = i;
            }
            endIdx[ch] = i;
        }


        for (int c = 0; c < 26; c++) {
            // c=0 :: 'a'
            if (startIdx[c] == -1) continue;

            for (int i = startIdx[c]; i <= endIdx[c]; i++) {
                int ch = s.charAt(i) - 'a';
                if (startIdx[ch] < startIdx[c]) {
                    isInvalid[c] = true;
                    break;
                }
                endIdx[c] = Math.max(endIdx[c], endIdx[ch]);
            }
        }

        int lastIdxTaken = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            int ch = s.charAt(i) - 'a';
            if (isInvalid[ch]) continue;

            if (i == startIdx[ch] && endIdx[ch] < lastIdxTaken) {
                result.add(s.substring(i, endIdx[ch] + 1));
                lastIdxTaken = i;
            }
        }

        return result;
    }
}
