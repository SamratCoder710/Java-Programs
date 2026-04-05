package com.coder.sanam;

public class StayingInGrid {

    public static void main(String[] args) {
        StayingInGrid stayingInGrid = new StayingInGrid();
        int[] result = stayingInGrid.executeInstructions(3, new int[]{0, 1}, "RRDDLU");
        for(int i: result){
            System.out.print(i + " ");
        }
    }

    public int[] executeInstructions(int n, int[] startPos, String s) {
        int len = s.length();
        int[] result = new int[len];
        for(int i=0;i<len;i++){
            int count = 0;
            int x = startPos[0];
            int y = startPos[1];
            for(int j=i;j<len;j++){
                char ch = s.charAt(j);
                if(ch == 'R'){
                    y++;
                }else if(ch == 'L'){
                    y--;
                }else if(ch =='U'){
                    x--;
                }else{
                    x++;
                }

                if(x < 0 || x>=n || y<0 || y>=n){
                    break;
                }else{
                    count++;
                }
            }
            result[i] = count;
        }

        return result;
    }
}
