package com.coder.sanam;

public class MinFlipToMakeBinaryStringAlternating {

    public static void main(String[] args) {
        MinFlipToMakeBinaryStringAlternating minFlipToMakeBinaryStringAlternating = new MinFlipToMakeBinaryStringAlternating();
        int res = minFlipToMakeBinaryStringAlternating.minFlipsOptimized("111000");
        System.out.println(res);
    }

    public int minFlipsOptimized(String s) {
        String str = s+s;
        int n = s.length();

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for(int i=0;i<2*n;i++){
            s1.append((i % 2 == 0) ? 0 : 1);
            s2.append((i % 2 == 0) ? 1 : 0);
        }
        System.out.println(s1+ "::"+s2);

        int i = 0, j = 0;
        int flip1 = 0;
        int flip2 = 0;
        int res = Integer.MAX_VALUE;
        while(j<str.length()){

            if(str.charAt(j) != s1.charAt(j)){
                flip1++;
            }

            if(str.charAt(j) != s2.charAt(j)){
                flip2++;
            }

            if(j-i+1 > n){ //shrink window
                if(str.charAt(i) != s1.charAt(i)){
                    flip1--;
                }

                if(str.charAt(i) != s2.charAt(i)){
                    flip2--;
                }
                i++;

            }

            if(j-i+1 == n){
                res = Math.min(res,Math.min(flip1,flip2));
            }
            j++;

        }
        return res;

    }


    public int minFlips(String s) {
        String str = s + s;
        int n = s.length();
        int ans = Integer.MAX_VALUE;

        int i = 0, j = n - 1;
        while (j < str.length()) {
            String sub = str.substring(i, j + 1);
            ans = Math.min(ans, minOps(sub));
            j++;
            i++;
        }
        return ans;

    }

    private int minOps(String s) {
        return Math.min(check(s, true), check(s, false));
    }

    private int check(String s, boolean flag) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (flag) {
                if (s.charAt(i) != '1') count++;
            } else {
                if (s.charAt(i) != '0') count++;
            }
            flag = !flag;
        }
        return count;
    }

}
