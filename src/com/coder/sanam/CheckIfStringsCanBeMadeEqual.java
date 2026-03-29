package com.coder.sanam;

public class CheckIfStringsCanBeMadeEqual {

    public static void main(String[] args) {
        CheckIfStringsCanBeMadeEqual obj = new CheckIfStringsCanBeMadeEqual();
        System.out.println(obj.canBeEqual("abcd", "cdab"));
    }

    public boolean canBeEqualSolutionI(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        boolean even = ch1[0] == ch2[0] && ch1[2] == ch2[2] ||
                ch1[0] == ch2[2] && ch1[2] == ch2[0];

        boolean odd = ch1[1] == ch2[1] && ch1[3] == ch2[3] ||
                ch1[1] == ch2[3] && ch1[3] == ch2[1];

        return even && odd;
    }

    public boolean canBeEqual(String s1, String s2) {
        int[] even = new int[26];
        int[] odd = new int[26];
        int n = s1.length();
        for(int i =0;i<n;i++){
            int i1 = s1.charAt(i) - 'a';
            int i2 = s2.charAt(i) - 'a';

            if(i % 2 == 0){
                even[i1]++;
                even[i2]--;
            }else{
                odd[i1]++;
                odd[i2]--;
            }
        }

        for(int i =0;i<26;i++){
            if(even[i] !=0 || odd[i] != 0){
                return false;
            }
        }

        return true;
    }
}
