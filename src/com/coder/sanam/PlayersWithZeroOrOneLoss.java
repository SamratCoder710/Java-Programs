package com.coder.sanam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PlayersWithZeroOrOneLoss {
	
	public static void main(String[] args) {
		int[][] input = {
				{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}
		};
		List<List<Integer>> findWinners = findWinners(input);
		for(List<Integer> ls : findWinners) {
			for(int i: ls) {
				System.out.print(i+"::");
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> findWinners(int[][] matches) {
		int[] losses = new int[100001];
        for(int i=0;i<matches.length;i++){
        	int win = matches[i][0];
        	int loss = matches[i][1];
        	if (losses[win] == 0) {
                losses[win] = -1;
            } 

            if (losses[loss] == -1) {
                losses[loss] = 1;
            } else {
                losses[loss]++;
            }
        } 
        List<Integer> zeroLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < losses.length; i++) {
            if (losses[i] == -1) {
                zeroLoss.add(i);
            } else if (losses[i] == 1) {
                oneLoss.add(i);
            }
        }

        result.add(zeroLoss);
        result.add(oneLoss);

        return result;
        
    }
	
	

}
