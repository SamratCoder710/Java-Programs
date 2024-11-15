package com.coder.sanam;

import java.util.HashMap;
import java.util.Map;

// [0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]
class OnlineVoting{
	
	public static void main(String[] args) {
		int[] a = {0,0,1,1,2};
		int[] b = {0,67,69,74,87};
		int[] qSet = {87};
		TopVotedCandidate candidate = new TopVotedCandidate(a, b); 
		for(int k : qSet) {
			System.out.print(candidate.q(k)+"::");
		}
		System.out.println();
		
	}
}

class TopVotedCandidate {
	private Map<Integer,Integer> lead = new HashMap<>();
	private int[] times ;
	
    public TopVotedCandidate(int[] persons, int[] times) {
		int leader = -1;
		this.times = times;
		
        Map<Integer,Integer> count = new HashMap<>();
        for(int i =0;i<persons.length;i++) {
        	count.put(persons[i], count.getOrDefault(persons[i],0) + 1);
        	
        	if(count.get(persons[i]) >= count.getOrDefault(leader,0)) {
        		leader = persons[i];
        	}
        	lead.put(times[i], leader);
        }
        
        for(Map.Entry<Integer,Integer> e: lead.entrySet()) {
        	System.out.println(e.getKey()+":: "+e.getValue());
        }
    }
    
    //0 12 23 32 36 40      ==> 36 ,   38 , 40, 0, 10, 12
    
    public int q(int t) {
    	int start = 0;
    	int end = times.length; 
    	if(t<times[end-1]) {
    		return lead.get(times[searchLowerBound(start, end,t,times)]);
    	}else {
    		return lead.get(times[times.length-1]);
    	}
    	
    	
        
    }

	private int searchLowerBound(int start, int end,int t,int[] times) {
		if(end-start == 1) {
			return start;
		}
    	int mid = start + (end-start)/2;
    	if(times[mid] == t) {
    		return mid;
    	}else if(times[mid] < t) {
    		return searchLowerBound(mid,end,t,times);
    	}else {
    		return searchLowerBound(start,mid,t,times);
    	}
		
		
	}
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
