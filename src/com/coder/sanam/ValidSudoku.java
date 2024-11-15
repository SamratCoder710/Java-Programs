package com.coder.sanam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
	
	public static boolean isValidSudoku(char[][] board) {
		Map<Integer,Set<Character>> rows = new HashMap<>();
        Map<Integer,Set<Character>> cols = new HashMap<>();
        Map<String,Set<Character>> squares = new HashMap<>();
        
        for(int i=0;i<board.length;i++) {
        	for(int j=0;j<board[i].length;j++) {
        		if(board[i][j] == '.') continue;
        		
        		if((rows.get(i) != null && rows.get(i).contains(board[i][j])) ||
        			((cols.get(j) != null) && cols.get(j).contains(board[i][j])) || 
        			((squares.get((i/3)+","+(j/3)) != null) && squares.get((i/3)+","+(j/3)).contains(board[i][j]))
        		) {
        			return false;
        		}
        		Set<Character> rowSet = rows.getOrDefault(i, new HashSet<>());
        		Set<Character> colSet = cols.getOrDefault(j, new HashSet<>());
        		Set<Character> squareSet = squares.getOrDefault((i/3)+","+(j/3), new HashSet<>());
        		rowSet.add(board[i][j]);
        		colSet.add(board[i][j]);
        		squareSet.add(board[i][j]);
        		rows.put(i, rowSet);
        		cols.put(j, colSet);
        		squares.put((i/3)+","+(j/3), squareSet);
        	}
        	
        }
        return true;
        
    }
	
	public static void main(String[] args) {
		char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
		boolean validSudoku = isValidSudoku(board);
		System.out.println(validSudoku);
	}
	
	

}
