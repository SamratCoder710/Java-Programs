package com.coder.sanam;

public class MinDistToTypeSpecialTypewriter {

    public static void main(String[] args) {
        MinDistToTypeSpecialTypewriter minDistToTypeSpecialTypewriter = new MinDistToTypeSpecialTypewriter();
        int result = minDistToTypeSpecialTypewriter.minTimeToType("abc");
        System.out.println(result);
    }

    public int minTimeToType(String word) {
        int result = 0;
        int n = word.length();
        int prevChar = 0; // 'a'
        for(char ch : word.toCharArray()){
            int curr = ch - 'a';
            if(curr > prevChar){
                result += Math.min(curr - prevChar, (prevChar - curr) + 26);
            }else{
                result += Math.min(prevChar - curr , (curr - prevChar) + 26);
            }
            prevChar = curr;
        }
        return result + n; // 1s for typing each character so(1*n)
    }
}
