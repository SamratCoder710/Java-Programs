package com.coder.sanam;

import java.util.*;

public class PyramidTransition {

    Map<String, Boolean> memo = new HashMap<>();

    public static void main(String[] args) {
        PyramidTransition obj = new PyramidTransition();
        String bottom = "AAAA";
        List<String> allowed = Arrays.asList("AAB","AAC","BCD","BBE","DEF");
        System.out.println(obj.pyramidTransition(bottom, allowed));
    }

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> mp = new HashMap<>();
        for(String s : allowed){
            String pair = s.substring(0,2);
            mp.computeIfAbsent(pair,_ -> new ArrayList<>()).add(s.charAt(2));
        }
        return solve(bottom,0,mp,new StringBuilder());

    }

    private boolean solve(String bottom, int index, Map<String, List<Character>> mp, StringBuilder nextLevel){
        if(bottom.length() == 1) return true;

        String key = bottom + "_"+ index + "_"+ nextLevel.toString();

        if(memo.containsKey(key)){
            return memo.get(key);
        }

        if(index == bottom.length() - 1){
            boolean result = solve(nextLevel.toString(),0,mp,new StringBuilder());
            memo.put(key,result);
            return result;
        }

        String pair = bottom.substring(index,index+2);
        if(!mp.containsKey(pair)){
            boolean flag = false;
            memo.put(key,flag);
            return flag;
        }

        for(char ch : mp.get(pair)){
            nextLevel.append(ch);

            if(solve(bottom,index+1,mp,nextLevel)) {
                boolean flag = true;
                memo.put(key,flag);
                return flag;
            }

            nextLevel.deleteCharAt(nextLevel.length()-1);
        }

        memo.put(key, false);
        return false;
    }
}
