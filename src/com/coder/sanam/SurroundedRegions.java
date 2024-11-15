package com.coder.sanam;

public class SurroundedRegions {
	
	public static void solve(char[][] board) {
        int rows = board.length, cols = board[0].length ;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if((i==0 || i== rows -1 || j==0 || j== cols-1 ) && board[i][j] == 'O'){
                    capture(i,j,board,rows,cols);
                }  
            }
        }
        // (0-> X)
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

        // (T-> O)
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void capture(int i,int j,char[][] board,int rows ,int cols){
        if(i<0 || i == rows || j<0 || j==cols ||board[i][j] != 'O' ) return ;
        board[i][j] = 'T';
        capture(i+1,j,board,rows,cols);
        capture(i-1,j,board,rows,cols);
        capture(i,j+1,board,rows,cols);
        capture(i,j-1,board,rows,cols);

    }
    
    public static void main(String[] args) {
		char[][] board = {
				{'O','O'},{'O','O'}
		};
		solve(board);
		
		for(char[] x:board) {
			for(char ch:x) {
				System.out.print(ch+"::");
			}
			System.out.println();
		}
	}

}
