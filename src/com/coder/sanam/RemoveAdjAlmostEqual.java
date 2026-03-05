package com.coder.sanam;

public class RemoveAdjAlmostEqual {
    public static void main(String[] args) {
        RemoveAdjAlmostEqual removeAdjAlmostEqual = new RemoveAdjAlmostEqual();
        int res = removeAdjAlmostEqual.removeAlmostEqualCharacters("zyxyxyz");
        System.out.println(res);
    }

    public int removeAlmostEqualCharacters(String word) {
        int n = word.length();
        int count = 0;
        for(int i=1;i<n;i++){
            if(Math.abs(word.charAt(i) - word.charAt(i-1)) <= 1){
                count++;
                i++;
            }
        }

        return count;
    }
}
