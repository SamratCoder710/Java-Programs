package com.coder.sanam;

public class TwoKeysKeyboard {

    public static void main(String[] args) {
        int i = minSteps(3);
        System.out.println(i);
    }

    public static int minSteps(int n){
        if(n==1) return 0;

        if(n==2) return 2;

        int[] t = new int[n+1];
        t[0] = 0;
        t[1] = 0;
        t[2] = 2;

        for(int i=3;i<=n;i++){
            int factor = i/2;
            while(factor>= 1){
                if(i%factor == 0){
                    int steps = t[factor];
                    int copy = 1 ;
                    int paste = (i/factor - 1);
                    t[i] = steps + copy + paste;
                    break;
                }else{
                    factor--;
                }

            }
        }

        return t[n];

//        return solve("A","A",n,1);
    }

    private static int solve(String np, String cb, int n,int steps) {
        if(np.length() == n) return steps;

        if(np.length() > n) return 10000000;

        int copyAllPaste = solve(np+ np,np,n,steps + 2);

        int paste = solve(np+cb,cb,n,steps+1);

        return Math.min(copyAllPaste,paste);
    }
}
