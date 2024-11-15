package com.coder.sanam;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DeckRevealingIncreasingOrder {
	
	public static int[] deckRevealedIncreasing(int[] deck) {
		int n = deck.length;
        int[] result = new int[n];
        Queue<Integer> que = new LinkedList<>();
        for(int i=0;i<n;i++) {
        	que.add(i);
        }
        Arrays.sort(deck);
        int i=0;
        while(i<n) {
        	int idx = que.peek();
        	que.poll();
        	result[idx] = deck[i];
        	if(!que.isEmpty()) {
        		que.add(que.peek());
        		que.poll();
        	}
        	i++;
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		int[] deckRevealedIncreasing = deckRevealedIncreasing(new int[] {17,13,11,2,3,5,7});
		for(int i :deckRevealedIncreasing) {
			System.out.println(i);
		}
	}

}
