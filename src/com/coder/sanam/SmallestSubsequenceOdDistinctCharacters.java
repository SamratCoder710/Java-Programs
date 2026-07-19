package com.coder.sanam;

import java.util.Stack;

public class SmallestSubsequenceOdDistinctCharacters {

    static void main() {
        SmallestSubsequenceOdDistinctCharacters seq = new SmallestSubsequenceOdDistinctCharacters();
        String result = seq.smallestSubsequence("cbacdcbc");
        System.out.println(result);
    }

    public String smallestSubsequence(String s) {
        boolean[] visited = new boolean[26];
        int[] charRemaining = new int[26];
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            charRemaining[ch - 'a']++;
        }

        for (char curr : s.toCharArray()) {

            int idx = curr - 'a';
            charRemaining[idx]--;
            if (visited[idx]) {
                continue;
            }

            while (!st.isEmpty() && curr < st.peek()
                    && charRemaining[st.peek() - 'a'] > 0) {
                visited[st.peek() - 'a'] = false;
                st.pop();
            }

            st.push(curr);
            visited[idx] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : st) {
            sb.append(character);
        }
        return sb.toString();
    }


}
