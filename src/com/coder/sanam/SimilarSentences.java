package com.coder.sanam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SimilarSentences {

    public static void main(String[] args) {
        boolean b = areSentencesSimilar("Eating right now", "Eating");
        System.out.println(b);
    }

    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        Deque<String> s1 = new ArrayDeque<>(Arrays.asList(sentence1.split(" ")));
        Deque<String> s2 = new ArrayDeque<>(Arrays.asList(sentence2.split(" ")));

        while(!s1.isEmpty() && !s2.isEmpty() && s1.peek().equals(s2.peek())){
            s1.poll();
            s2.poll();
        }

        while(!s1.isEmpty() && !s2.isEmpty() && s1.peekLast().equals(s2.peekLast())){
            s1.pollLast();
            s2.pollLast();
        }

        return s1.isEmpty() || s2.isEmpty();

    }
}
