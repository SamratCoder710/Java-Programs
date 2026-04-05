package com.coder.sanam;

public class FurthestPointFromOrigin {

    public static void main(String[] args) {
        FurthestPointFromOrigin furthestPointFromOrigin = new FurthestPointFromOrigin();
        int result = furthestPointFromOrigin.furthestDistanceFromOrigin("_R__LL_");
        System.out.println(result);
    }

    public int furthestDistanceFromOrigin(String moves) {
        int L = 0 , R = 0,space = 0;
        for(char ch : moves.toCharArray()){
            if(ch == 'L'){
                L++;
            }else if(ch == 'R'){
                R++;
            }else{
                space++;
            }
        }

        if(L == R){
            return space;
        }
        return Math.max((L + space) - R, (R + space) - L);

    }


}
