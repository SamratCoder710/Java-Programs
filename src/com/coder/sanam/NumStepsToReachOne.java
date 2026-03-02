package com.coder.sanam;

public class NumStepsToReachOne {

    public static void main(String[] args) {
        NumStepsToReachOne numStepsToReachOne = new NumStepsToReachOne();
        int res = numStepsToReachOne.numSteps("1101");
        System.out.println(res);
    }


    public int numSteps(String s) {
        int n = s.length();
        int num = 0;
        int power = 0;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i) == '1'){
                num += (int) Math.pow(2, power);
            }
            power++;
        }
        int steps = 0;
        while(num != 1){
            if((num & 1) == 0){
                num = num >> 1;
            }else{
                num += 1;
            }
            steps++;
        }
        return steps;
    }
}
