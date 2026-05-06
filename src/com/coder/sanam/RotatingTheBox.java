package com.coder.sanam;

import java.util.Arrays;

public class RotatingTheBox {

    public static void main(String[] args) {
        RotatingTheBox rotatingTheBox = new RotatingTheBox();
        char[][] result = rotatingTheBox.rotateTheBox(new char[][]{
                {'#','.','*','.','#'},
                {'#','#','*','.','.'},
                {'#','#','.','.','.'},
        });

        for(char[] arr : result){
            System.out.println(Arrays.toString(arr));
        }
    }


        public char[][] rotateTheBox(char[][] boxGrid) {
            int m = boxGrid.length;
            int n = boxGrid[0].length;

            char[][] result = new char[n][m];
            for(char [] arr: result){
                Arrays.fill(arr,'.');
            }


            for(int i=0;i<m;i++){
                int potentialCol = n-1;
                for(int j=n-1;j>=0;j--){
                    if(boxGrid[i][j] == '.') continue;

                    if(boxGrid[i][j] == '*'){
                        result[j][m-1-i] = '*';
                        potentialCol = j - 1;
                    }else{
                        result[potentialCol][m-1-i] = '#';
                        potentialCol--;
                    }
                }
            }

            return result;


        }

}
