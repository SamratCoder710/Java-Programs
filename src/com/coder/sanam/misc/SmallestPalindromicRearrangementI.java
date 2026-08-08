package com.coder.sanam.misc;

public class SmallestPalindromicRearrangementI {

    static void main() {
        SmallestPalindromicRearrangementI smallestPalindromicRearrangementI = new SmallestPalindromicRearrangementI();
        String result = smallestPalindromicRearrangementI.smallestPalindrome("aaabbbb");
        System.out.println(result);
    }

    public String smallestPalindrome(String s) {
        int n = s.length();
        if (n == 1) {
            return s;
        }
        int[] freq = new int[26];
        for (int i = 0; i < n / 2; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) {
                continue;
            }
            while (freq[i] > 0) {
                sb.append((char) (i + 'a'));
                freq[i]--;
            }

        }

        String middle = n % 2 != 0 ? String.valueOf(s.charAt(n / 2)) : "";
        return sb + middle + sb.reverse();
    }
}
