package com.coder.sanam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
	
	public static void main(String[] args) {
		
		int leastInterval = leastInterval(new char[] {'A','A','A','B','B','B', 'C','C','C', 'D', 'D', 'E'}, 2);
		System.out.println(leastInterval);
	}
	
	public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int time = 0;
        for(char ch : tasks){
            freq[ch-'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int num:freq){
            if(num >0){
                pq.add(num);
            } 
        }

        while(!pq.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for(int i=1;i<=n+1;i++){
                if(!pq.isEmpty()){
                    int topEle = pq.peek();
                    topEle--;
                    temp.add(topEle);
                }
            }

            for(int x:temp){
                if(x>0){
                    pq.add(x);
                }
            }

            if(pq.isEmpty()){
                time += temp.size(); 
            }else{
                time += n+1;
            }
        }

        return time;
    }

}
