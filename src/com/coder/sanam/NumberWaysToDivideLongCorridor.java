package com.coder.sanam;

public class NumberWaysToDivideLongCorridor {

    public static void main(String[] args) {
        NumberWaysToDivideLongCorridor numberWaysToDivideLongCorridor = new NumberWaysToDivideLongCorridor();
        String corridor = "SSPPSPS";
//        System.out.println(numberWaysToDivideLongCorridor.numberOfWays(corridor));

        String corridor2 = "SSSPPPSPPSPSSSSSSPPPSPP";
        System.out.println(numberWaysToDivideLongCorridor.numberOfWays(corridor2));
    }

    public int numberOfWays(String corridor) {
       final long MOD = 1_000_000_007L;
        long result = 1;
        int n = corridor.length();
        int idx = 0;
        int countS = 0;
        int seats = 0;
        for(char ch : corridor.toCharArray()){
            if(ch == 'S'){
                seats++;
            }
        }
        if(seats % 2 != 0) return 0;
        if(seats == 0) return 0;
        if (seats == 2) return 1;

        //count last P's
        int m = n-1;
        while(corridor.charAt(m) == 'P'){
            m--;
        }

        //skip last P's
        while(idx < m){
            if(corridor.charAt(idx) == 'S'){
                countS++;
            }
            idx++;

            if(countS == 2){
                int countP = 0;

                while(corridor.charAt(idx) == 'P' ){
                    countP++;
                    idx++;
                    if(idx >= m) break;
                }
                result = (result * (countP + 1)) % MOD;
                countS = 0;
            }

        }

        return (int)result;

    }
}
