package com.coder.sanam;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
	
	public static int snakesAndLadders(int[][] board) {
		int n = board.length;
		int goal = n*n;
		 Queue<Integer> queue = new LinkedList<>();
		 boolean[] visited = new boolean[goal+1];
		 int steps = 0;
		 queue.offer(1);
		 visited[1] = true;
        while(!queue.isEmpty()) {
        	int N = queue.size();
        	while(N != 0) {
        		int ele = queue.poll();
        		if(ele == goal) {
        			return steps;
        		}
        		for(int i=1;i<=6;i++) {
            		int val = ele+i;
            		if(val > goal) {
            			break;
            		}
            		int[] cords = getCoordinates(val,n);
            		int r = cords[0];
            		int c = cords[1];
            		if(visited[val] == true) {
            			continue;
            		}
            		visited[val]= true;
            		if(board[r][c] == -1) {
            			queue.offer(val);
            			
            		}else {
            			queue.offer(board[r][c]);
            		}

            	}
        		N--;
        	}
        	
        	
        	steps++;
        }
        return -1;
    }
	
	
	private static int[] getCoordinates(int val,int n) {
		int rowFromTop = (val-1)/n;
		int rowFromBottom = n-1-rowFromTop;
		if((n%2==1 && rowFromBottom%2==1) || (n%2==0 && rowFromBottom%2==0)) {
			return new int[] {rowFromBottom,n-1-((val-1)%n)};
		}else {
			return new int[] {rowFromBottom,((val-1)%n)};
		}
	}


	public static void main(String[] args) {
		int[][] inputArr = new int[][] {
		{-1,-1,-1,-1,-1,-1},
		 {-1,-1,-1,-1,-1,-1},
		 {-1,-1,-1,-1,-1,-1},
		 {-1,35,-1,-1,13,-1},
		 {-1,-1,-1,-1,-1,-1},
		 {-1,15,-1,-1,-1,-1}};
		 
		 int snakesAndLadders = snakesAndLadders(inputArr);
		 System.out.println(snakesAndLadders);
	}

}
