package com.coder.sanam;

public class DetectCapital {

    public static void main(String[] args) {
        DetectCapital detectCapital = new DetectCapital();
        boolean result = detectCapital.detectCapitalUse("USA");
        System.out.println(result);
    }

    public boolean detectCapitalUse(String word) {
        int n = word.length();
        if(n == 0 || n==1) return true;

        int firstChar = word.charAt(0) - 'A';
        if(firstChar < 26){
            // firstChar capital
            int secondChar = word.charAt(1) - 'A';
            boolean secondCharCaps = secondChar < 26;
            for(int i=2;i<n;i++){
                int currentChar = word.charAt(i) - 'A';
                boolean currCharCaps = currentChar < 26;
                if(secondCharCaps != currCharCaps) return false;
            }
        }else{
            // firstChar lower
            for(int i=1;i<n;i++){
                int currentChar = word.charAt(i) - 'A';
                if(currentChar < 26) return false;
            }
        }
        return true;
    }
}
