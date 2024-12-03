package com.coder.sanam;

import java.util.ArrayList;
import java.util.List;

public class AddingSpacesToString {

    public static void main(String[] args) {
        String s = addSpaces("LeetcodeHelpsMeLearn", new int[]{8, 13, 15});
        System.out.println(s);
    }


    public static String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s);
        int idx = -1;
        for(int i: spaces){
            idx += 1;
            sb.insert(i+ idx," ");
        }
        return sb.toString();
    }

    public static String addSpacesAlternative(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int idx = 0 ;
        int i = 0;
        while(i<s.length()){
            if(idx< spaces.length && spaces[idx]==i){
                idx++;
                sb.append(" ");
            }else{
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}
